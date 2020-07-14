package com.bice.cambio_cupo_cclv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

	private static MvcConfig config;

	@Value("${DB_JNDI}")
	private String DB_JNDI;

	public String getDB_JNDI() {
		return DB_JNDI;
	}

	public void setDB_JNDI(String db_jndi) {
		DB_JNDI = trim(db_jndi);
	}

	public static synchronized MvcConfig get() {
		if (config != null) {
			return config;
		}

		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class,
				MvcConfig.class);

		config = context.getBean(MvcConfig.class);

		context.close();

		return config;
	}

	private String trim(String s) {
		if (s != null) {
			s = s.trim();
		}

		return s;
	}

}