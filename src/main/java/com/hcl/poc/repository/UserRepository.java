package com.hcl.poc.repository;

import org.springframework.stereotype.Repository;

import com.hcl.poc.entity.User;

/**
 * Repository interface for {@link User}
 * @author Yogeesha R M
 *
 */
@Repository
public interface UserRepository extends GenericRepository<User, Integer> {

}
