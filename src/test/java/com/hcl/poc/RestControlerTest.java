package com.hcl.poc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hcl.poc.entity.User;
import com.hcl.poc.exception.POCException;
import com.hcl.poc.rest.api.Client;
import com.hcl.poc.rest.api.Response;

public class RestControlerTest {
	
	public static String URL = "http://localhost:8080/RestPoc/rest/users/";
	public static String ID = "1012";

	public static void testGetUsers() {
		Client client = new Client(URL);
		try {
			System.out.println("Test for getting all the Users");
			Response response =	client.get();
			System.out.println(response.getBody());
		} catch (POCException e) {
			e.printStackTrace();
		}
	}

	public static void testGetUser() {
		System.out.println("Test for getting the User");
		Client client = new Client(URL + ID);
		try {
			Response response =	client.get();
			System.out.println(response.getBody());
		} catch (POCException e) {
			e.printStackTrace();
		}
	}

	public static void testCreateUser() {
		System.out.println("Test for creating new user");
		User user = new User();
		user.setFirstName("Yogeesha");
		user.setLastName("R M");
		user.setDateOfBirth(new Date());
		user.setSex("Male");
		user.setEmail("yogeesha@gmail.com");
		user.setAddress("Bengaluru");
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
			String body = mapper.writeValueAsString(user);
			Client client = new Client(URL);
			Response response = client.post(body);
			System.out.println(response.getBody());
		} catch (JsonProcessingException | POCException e) {
			e.printStackTrace();
		}

	}

	public static void testUpdateUser() {
		System.out.println("Test for updating the user");
		Client client = new Client(URL + ID);
		try {
			Response response =	client.get();
			System.out.println(response.getBody());
			ObjectMapper mapper = new ObjectMapper();
			if(response.getBody() != null && !response.getBody().isEmpty()){
				User user = mapper.readValue(response.getBody(), User.class);
				user.setAddress("New Address");
				
				ObjectMapper om = new ObjectMapper();
				mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
				mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
				String body = om.writeValueAsString(user);
				Response response2 = client.put(body);
				System.out.println(response2.getBody());
			} else {
				System.out.println("User not exists");
			}
			
		} catch (POCException | IOException e) {
			e.printStackTrace();
		}

	}

	public static void testDeleteUser() {
		System.out.println("Test for deleting the user");
		Client client = new Client(URL + ID);
		try {
			Response response =	client.delete();
			System.out.println(response.getBody());
		} catch (POCException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		testGetUsers(); 
		System.out.println("---------------------------------------------------");
		testGetUser();
		System.out.println("---------------------------------------------------");
		testCreateUser();
		System.out.println("---------------------------------------------------");
		testUpdateUser();
		System.out.println("---------------------------------------------------");
		testDeleteUser();
	}
}
