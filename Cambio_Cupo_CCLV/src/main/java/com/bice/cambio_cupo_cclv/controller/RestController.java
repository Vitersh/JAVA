package com.bice.cambio_cupo_cclv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bice.cambio_cupo_cclv.entities.MontoCorredora;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class RestController {
	
	private static final Logger log = LoggerFactory.getLogger(RestController.class);

	@GetMapping("/saludar")
	public MontoCorredora saludo(@RequestParam(name = "nombre", required = false, defaultValue = "Usuario") String nombre) {
		log.info("Llegando al rest controller");
		Date date = new Date();
		return new MontoCorredora("rut corredora",1234,"cuenta corredora","nombre corredora",date,5678);
	}
	
//	@PostMapping(value = "/desbloqueaClaveAdmin", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity desbloqueaClaveAdmin(@RequestBody RequestDesbloqueoTO datos) throws ParseException {
//        return this.desbloqueoClaveService.desbloqueoClaveAdmin(datos);
//    }

}
