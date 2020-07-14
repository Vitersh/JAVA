package com.bice.cambio_cupo_cclv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class RootConfig {
	
	@Bean
	 static public PropertySourcesPlaceholderConfigurer
	 		propertySourcesPlaceholderConfigurer() {

		 PropertySourcesPlaceholderConfigurer
	 	 		propertySourcesPlaceholderConfigurer =
	 	 				new PropertySourcesPlaceholderConfigurer();

	 	 propertySourcesPlaceholderConfigurer
	 		.setLocations(
	 				new AppFileSystemResource(
//	 						  System.getProperty("DOMAIN_HOME")
	 						"C:/Oracle/Middleware/Oracle_Home/user_projects/domains/base_domain"
	 						+ "/servers/AdminServer/properties/cambio_cupo_cclv/cambio_cupo_cclv.properties"));
	 	 
		 return propertySourcesPlaceholderConfigurer;
	}

}
