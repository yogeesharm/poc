package com.hcl.poc.service;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import com.hcl.poc.exception.POCException;

/**
 * Generic Servie interface
 * @author Yogeesha R M
 *
 * @param <T> Entity
 * @param <ID> Primary key of the Entity
 */
public interface GenericService<T, ID extends Serializable> {
	
	/**
	 *  This method is used to find all the Entity details
	 * @return {@link List<T>}
	 * @throws POCException
	 */
	List<T> findAll() throws POCException;
	
	/**
	 * This method is used to get a entity detail using it's id
	 * @param id
	 * @return {@link List<T>}
	 * @throws POCException
	 */
	T find(ID id) throws POCException ;
	
	/**
	 * This method is used to save entity details
	 * @param entity
	 * @return {@link ID}
	 * @throws POCException
	 */
	ID save(T entity) throws POCException ;
    
    /**
	 * This method is used to update entity details
	 * @param entity
	 * @throws POCException
	 */
    T update(T entity) throws POCException ;
    
    /**
     * This method is used to delete entity details
     * @param id
     * @throws POCException
     */
    void delete(ID id) throws POCException;
    
    /**
     * This method is used get the DomainClass
     * @return {@link Type}
     */
    Type getDomainClass();
    
    /**
     * This method is used to save or update entity details
     * @param entity
     * @throws POCException
     */
	void saveOrUpdate(T entity) throws POCException;
}