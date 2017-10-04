package com.hcl.poc.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.poc.exception.POCPersistenceException;

/**
 * Generic repository implementation
 * @author Yogeesha R M
 *
 * @param <T> Entity
 * @param <ID> Primary key value of the Entity
 */
@Component
@SuppressWarnings("unchecked")
@Transactional(readOnly = true)
public abstract class GenericRepositoryImpl<T, ID extends Serializable> implements GenericRepository<T, ID> {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public Session getHibernateSession(){
    	return sessionFactory.getCurrentSession();
	}
	
	private Class<T> domainClass;
	
	public GenericRepositoryImpl(){
		domainClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	@Transactional
	public ID save(T entity) throws POCPersistenceException {
		Session session = sessionFactory.getCurrentSession();
		ID id = (ID) session.save(entity);
		session.flush();
		return id;
	}
	
	@Override
	@Transactional
	public void delete(ID id) throws POCPersistenceException {
		Session session = sessionFactory.getCurrentSession();
		Object entity = findOne(id);
		if(entity != null){
			session.delete(entity);
			session.flush();
		}
	}
	
	@Override
	public T findOne(ID id) throws POCPersistenceException {
		Session session = sessionFactory.getCurrentSession();
		return session.get(domainClass, id);
	}

	@Override
	public List<T> findAll() throws POCPersistenceException {
		Session session = sessionFactory.getCurrentSession();
	   	Criteria crit = session.createCriteria(domainClass);
	    return crit.list();
	}
	
	protected Criteria getHibernateCriteria(){
		Session session = sessionFactory.getCurrentSession();
		return  session.createCriteria(domainClass);
	   	
	}
	
	@Override
	public T update(T entity) throws POCPersistenceException {
		Session session = sessionFactory.getCurrentSession();
		T t = (T) session.merge(entity);
		session.flush();
		return t;
	}
	
	@Override
	public void saveOrUpdate(T entity) throws POCPersistenceException {
		Session session = sessionFactory.getCurrentSession();
		 session.saveOrUpdate(entity);
	}
	
    @Override
    public void executeQuery(String queryString, Map<String,Object> parameters){
    	final Session session = sessionFactory.getCurrentSession();
    	Query query = session.createSQLQuery(queryString);
    	for (Map.Entry<String, Object> parameterOption : parameters.entrySet()) {
			query.setParameter(parameterOption.getKey(), parameterOption.getValue());
		}
    	query.executeUpdate();
    }
}