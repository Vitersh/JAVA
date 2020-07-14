package com.bice.cambio_cupo_cclv.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	   protected void customizeRegistration(ServletRegistration.Dynamic registration) {
	       registration.setMultipartConfig(getMultipartConfigElement());
	   }

	   private MultipartConfigElement getMultipartConfigElement() {
	       MultipartConfigElement multipartConfigElement = new MultipartConfigElement( LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
	       return multipartConfigElement;
	   }

	   private static final String LOCATION = System.getProperty("java.io.tmpdir"); // Temporary location where files will be stored
	   private static final long MAX_FILE_SIZE = -1; //5242880; // 5MB : Max file size.
	   private static final long MAX_REQUEST_SIZE =134217728;// 20971520; // 20MB : Total request size containing Multi part.
	   private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk

	   
   @Override
    protected Filter[] getServletFilters(){
         
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

 
        HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{characterEncodingFilter, httpMethodFilter};
    }

}
