/**
 * 
 */
package com.hcl.poc.service;

import org.springframework.stereotype.Service;

import com.hcl.poc.entity.User;

/**
 * Service interface for {@link User}
 * @author Yogeesha R M
 *
 */
@Service
public interface UserService extends GenericService<User, Integer> {

}
