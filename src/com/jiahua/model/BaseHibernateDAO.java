package com.jiahua.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */

public class BaseHibernateDAO {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public BaseHibernateDAO() {
        System.out.println("BaseHibernateDAO...");
    }

    public SessionFactory getSessionFactory() {
        System.out.println("getSessionFactory...");
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        System.out.println("setSessionFactory...");
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	
}