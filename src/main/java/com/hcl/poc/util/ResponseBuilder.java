package com.hcl.poc.util;

import java.net.URI;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

/**
 * This Class is used to Create Response Object
 * 
 * @author Yogeesha R M
 *
 */
public final class ResponseBuilder {

	private ResponseBuilder(){
	}
	
	/**
	 * This method is used to build Create Response
	 * 
	 * @param uriInfo
	 * @param entity
	 * @param hasEntityContext
	 * @return
	 */
    public static <T> Response buildCreateResponse(UriInfo uriInfo, T entity) {
    	UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        URI location;
        location = ub.build();
        return Response.status(HttpStatus.CREATED).location(location).entity(entity).build();
    }

    /**
     * This method is used to build Update Response
     * 
     * @param entity
     * @return
     */
    public static <T> Response buildUpdateResponse(T entity) {
        return Response.ok().entity(entity).build();
    }
}
