package com.busecnky.repository;

import java.util.List;

import org.hibernate.Session;

import com.busecnky.utils.HibernateUtils;



public interface ICrud<T> {

	void save(T t);
	
	void update(T t);
	
	void delete(long id);
	
	List<T> findAll();
	
	T findById(long id);
	
	
	default Session dataBaseConnectionHibernate() {
		
		return HibernateUtils.getSessionFactory().openSession();
	}
	
}
