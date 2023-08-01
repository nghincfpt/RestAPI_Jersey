package com.nghinc.JerseyConfig;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class JerseyConfig  extends ResourceConfig{
	
	 private static final Logger logger = Logger.getLogger(JerseyConfig.class);
		
	  @Value("${logs.directory}")
	    private String logsDirectory;
	  
	public JerseyConfig() {
		packages("src/main/resources");
		packages("com.nghinc.controller");

		   try {
	            ClassPathResource resource = new ClassPathResource("log4j.properties");
	            Properties props = new Properties();
	            props.load(resource.getInputStream());
	            PropertyConfigurator.configure(props);

	        } catch (Exception e) {
	        	  logger.error("Không tìm thấy file" + e.getMessage(), e);
	            e.printStackTrace();
	        }

        logger.error("Jersey application started.");
    }
}
