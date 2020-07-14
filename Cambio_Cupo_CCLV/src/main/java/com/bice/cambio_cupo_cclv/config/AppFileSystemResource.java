package com.bice.cambio_cupo_cclv.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;

public class AppFileSystemResource extends FileSystemResource {
	
	private static final Logger log = LoggerFactory.getLogger(AppFileSystemResource.class);
	
	private static class ResourceStatus {
		private byte[]      data;
		private long        contentLength;
		private IOException ioException;
	}

	private static final Map<String, ResourceStatus> rsMap =
			new HashMap<String, ResourceStatus>();

	private String               path;
	private ByteArrayInputStream bais;
	private long                 contentLength;
	private IOException          ioException;

	public AppFileSystemResource(String path) {
		super(path);

		/*
		 * springframework puede llamar varias veces al constructor de una clase
		 * que carga un recurso desde el filsystem, dependiendo de cómo se
		 * inicializan los componentes que utilizan sprintframework. En este caso
		 * , esto sucede al cargar el archivo de propiedades
		 * 
		 * Para controlar que la carga de este archivo sea realizada una sóla
		 * vez, la variable 'rsMap' sincroniza los múltiples accesos que pueden
		 * ocurrir sobre este constructor.
		 */
		synchronized (rsMap) {
			ResourceStatus rs = rsMap.get(path);

			if (rs != null) {
				if (rs.data != null) {
					bais = new ByteArrayInputStream(rs.data);
				} else {
					bais = null;
				}

				contentLength = rs.contentLength;
				ioException = rs.ioException;

				return;
			}

			log.info("Loading configuration file '" + path + "'...");
			
			byte[] data = null;

			try {
				data = Files.readAllBytes(Paths.get(path));

				if (data == null) {
					ioException = new IOException(path + " cannot be read.");

					return;
				}

				contentLength = data.length;
				bais = new ByteArrayInputStream(data);
				
				log.info("exito");
			} catch (IOException e) {
				log.error("no se pudo cargar archivo properties");
				ioException = e;
			} finally {
				rs = new ResourceStatus();

				rs.data = data;
				rs.contentLength = contentLength;
				rs.ioException = ioException;

				rsMap.put(path, rs);
			}
		}
	}

}
