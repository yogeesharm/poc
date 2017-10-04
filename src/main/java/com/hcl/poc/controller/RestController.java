package com.hcl.poc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.poc.entity.User;
import com.hcl.poc.exception.POCException;
import com.hcl.poc.service.UserService;

/**
 * Controller class for REST Services
 * @author Yogeesha R M
 *
 */
@Service
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class RestController {

	private static final Logger logger = LogManager.getLogger(RestController.class);
	
	@Autowired
	private UserService userService;

	/**
	 * Get the User details for the ID
	 * @param userId primary key of the {@link User}
	 * @return User details in JSON format 
	 */
	@GET
	@Path("/{id}")
	public Response getUser(@PathParam("id") Integer userId){
		logger.info("Request to get the user details for user with id " + userId);
		User user = null;
		try {
			user = userService.find(userId);
		} catch (NumberFormatException | POCException e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.OK).entity(user).build();
	}
	
	/**
	 * Gets list of all the User details
	 * @return List of all the user details in JSON format
	 */
	@GET
	public Response getUsers(){
		List<User> users = new ArrayList<>();
		try {
			users = userService.findAll();
		} catch (POCException e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.OK).entity(users).build();
	}
	
	/**
	 * Creates the new user in the system
	 * @param user {@link User}
	 * @return Created user details in JSON format
	 */
	@POST
	public Response saveUser(User user){
		try {
			Integer id = userService.save(user);
			System.out.println(id);
		} catch (POCException e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.OK).entity(user).build();
	}
	
	/**
	 * Updates the user details 
	 * @param userId the primary key for the {@link User}
	 * @param user {@link User} 
	 * @return Updated user details in JSON format
	 */
	@PUT
	@Path("/{id}")
	public Response updateUser(@PathParam("id") Integer userId, User user){
		try {
			user = userService.update(user);
		} catch (POCException e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.OK).entity(user).build();
	}
	
	/**
	 * Deletes the user details
	 * @param userId primary key of the {@link User}
	 * @return Success message on successful deletion
	 */
	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") Integer userId){
		try {
			userService.delete(userId);
		} catch (POCException e) {
			e.printStackTrace();
		}
		return Response.ok("User details deleted Successfully", MediaType.APPLICATION_JSON).build();
	}
	
}
