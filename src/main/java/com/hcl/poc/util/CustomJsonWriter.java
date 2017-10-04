package com.hcl.poc.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;


/**
 * Custom JSON provider for the application
 * @author Yogeesha R M
 *
 */
@Component
@Provider
public class CustomJsonWriter extends JacksonJsonProvider{
   
	public CustomJsonWriter() {}

    @Override
    public ObjectMapper locateMapper(Class<?> type, MediaType mediaType) {
        ObjectMapper mapper = super.locateMapper(type, mediaType);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        return mapper;
    }
}
