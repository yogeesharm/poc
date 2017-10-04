package com.hcl.poc.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hcl.poc.exception.POCException;
import com.hcl.poc.exception.POCPersistenceException;
import com.hcl.poc.repository.GenericRepository;


/**
 * Generic service implementation
 * @author Yogeesha R M
 *
 * @param <T> Entity
 * @param <ID> Primary key of the Entity
 */
@Transactional(readOnly = true)
public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID>{

	private Type domainClass;
	
    private GenericRepository<T, ID> repository;
    
    public GenericServiceImpl(GenericRepository<T, ID> repository) throws POCException {
        this.repository = repository;
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        domainClass = pt.getActualTypeArguments()[0];
    }	
   
    @Override
	public List<T> findAll() throws POCException {
		try {
			return repository.findAll();
		} catch (POCPersistenceException e) {
			throw new POCException(e);
		}
	}
    
	@Override
	public T find(ID id) throws POCException {
		try {
			return repository.findOne(id);
		} catch (POCPersistenceException e) {
			throw new POCException(e);
		}
	}

	@Override
	@Transactional
	public ID save(T entity) throws POCException {
		try {
			return repository.save(entity);
		} catch (POCPersistenceException e) {
			throw new POCException(e);
		}
	}

	@Override
	@Transactional
	public T update(T entity) throws POCException {
		try {
			return repository.update(entity);
		} catch (POCPersistenceException e) {
			throw new POCException(e);
		}
	}
	
	@Override
	@Transactional
	public void delete(ID id) throws POCException {
		try {
			repository.delete(id);
		} catch (POCPersistenceException e) {
			throw new POCException(e);
		}
	}

	@Override
	public Type getDomainClass() {
		return domainClass;
	}

	@Override
	@Transactional
	public void saveOrUpdate(T entity) throws POCException {
		try {
			 repository.saveOrUpdate(entity);
		} catch (POCPersistenceException e) {
			throw new POCException(e);
		}
	}

}