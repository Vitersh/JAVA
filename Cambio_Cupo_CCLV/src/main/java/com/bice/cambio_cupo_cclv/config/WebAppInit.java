package com.bice.cambio_cupo_cclv.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class WebAppInit {
	
	private static final Logger log = LoggerFactory.getLogger(WebAppInit.class);
	
	String DB_JNDI						= "SIN DATOS";
	
	@EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
		
		try {

    	MvcConfig conf = MvcConfig.get();

		DB_JNDI						 = conf.getDB_JNDI();
		
		log.info("JNDI : " + DB_JNDI);
		} catch(Exception e) {
			log.error("No se pudo cargar la configuracion de inicio : " , e);
		}
	}

}
