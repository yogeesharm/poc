package com.hcl.poc.repository;

import org.springframework.stereotype.Repository;

import com.hcl.poc.entity.User;

/**
 * Repository implementation for {@link User}
 * @author Yogeesha R M
 *
 */
@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<User, Integer> implements UserRepository {

}
