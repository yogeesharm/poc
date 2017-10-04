package com.hcl.poc.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.data.repository.NoRepositoryBean;

import com.hcl.poc.exception.POCPersistenceException;

/**
 * Generic Repository interface 
 * @author Yogeesha R M
 *
 * @param <T> Entity class
 * @param <ID> Primary key value of the Entity
 */
@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> {

	/**
	 * This method is used to save an entity
	 * 
	 * @param entity
	 * @return {@link <ID>}
	 * @throws POCPersistenceException
	 */
	ID save(T entity) throws POCPersistenceException;

	/**
	 * This method is to delete a entity
	 * 
	 * @param id contains the id of the entity object
	 * @exception KinveyException when entity is not found
	 * @throws POCPersistenceException
	 */
	void delete(ID id) throws POCPersistenceException;

	/**
	 * This method is used to get a entity detail using it's id
	 * 
	 * @param id
	 * @return {@link <T>}
	 * @throws POCPersistenceException
	 */
	T findOne(ID id) throws POCPersistenceException;

	/**
	 * This method is used to find all the Entity details
	 * 
	 * @return {@link List<T>}
	 * @throws POCPersistenceException
	 */
	List<T> findAll() throws POCPersistenceException;

	/**
	 * This method is used to update an entity
	 * 
	 * @param entity
	 * @return {@link <T>}
	 * @throws POCPersistenceException
	 */
	T update(T entity) throws POCPersistenceException;

	/**
	 * This method is used to save or  update an entity
	 * @param entity
	 * @return
	 * @throws POCPersistenceException
	 */
	void saveOrUpdate(T entity) throws POCPersistenceException;
	
    /**
	 * Returns the hibernate current session
	 * @return {@link Session} hibernate session
	 */
	Session getHibernateSession();
	
    /**
     * This executes an update query
     * 
     * @param query
     */
    void executeQuery(String queryString, Map<String,Object> parameters);
}