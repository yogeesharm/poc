package com.hcl.poc.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.hcl.poc.controler.RestControler;

public class RestApplication extends ResourceConfig {

	private final static Logger ORG_GLASSFISH_JERSEY_LOGGER = Logger
			.getLogger("org.glassfish.jersey");
	static {
		ORG_GLASSFISH_JERSEY_LOGGER.setLevel(Level.OFF);
	}
	
	public RestApplication() {
		register(RequestContextFilter.class);
		register(RestControler.class);
		register(CustomJsonWriter.class);
		register(CORSFilter.class);
	}
}
