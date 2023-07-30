package com.i2iSystems.SpringClientServer.DataAccess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.i2iSystems.SpringClientServer.Entities.SubscriberEntity;

import jakarta.persistence.EntityManager;


@Service
public class HibernateSubscriberDal implements ISubscriberDal {
	
	private EntityManager entityManager;
	
	@Autowired
	public HibernateSubscriberDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<SubscriberEntity> getAll() {
		entityManager.getEntityManagerFactory().getCache().evictAll();
		
		Session session = entityManager.unwrap(Session.class);
		
		List<SubscriberEntity> subscribers= session.createQuery("From SubscriberEntity",SubscriberEntity.class).getResultList();
		
		return subscribers;
	}

	
	@Override
	@Transactional
	public void add(SubscriberEntity subscriber) {
			entityManager.persist(subscriber);
			 
		
		
	}
	

}
