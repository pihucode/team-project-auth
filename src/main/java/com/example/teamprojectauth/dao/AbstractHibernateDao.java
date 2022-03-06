package com.example.teamprojectauth.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDao<T extends Serializable> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    public List<T> getAll() {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(clazz);
        criteria.from(clazz);
        return session.createQuery(criteria).getResultList();
    }

    public T findById(int id) {
        return getCurrentSession().get(clazz, id);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void updateRecord(final T o){
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().update(o);
        transaction.commit();
    }
}
