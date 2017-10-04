/**
 * 
 */
package com.hcl.poc.service;

import org.springframework.stereotype.Service;

import com.hcl.poc.entity.User;
import com.hcl.poc.exception.POCException;
import com.hcl.poc.repository.UserRepository;

/**
 * Service implementation for {@link User}
 * @author Yogeesha R M
 *
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {

	public UserServiceImpl(UserRepository repository) throws POCException {
		super(repository);
	}

}
