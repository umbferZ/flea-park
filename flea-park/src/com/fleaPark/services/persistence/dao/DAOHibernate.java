/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.services.persistence.dao
 * Type: DAOHibernate
 * Last update: 31-gen-2017 0.03.10
 * 
 */
package com.fleaPark.services.persistence.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * The Class DAOHibernate.
 */
@Deprecated
public class DAOHibernate {

    private AnnotationConfiguration config;
    private Class<?> cls;

    /**
     * Instantiates a new DAO hibernate.
     *
     * @param cls the cls
     */
    public DAOHibernate(Class<?> cls) {
        this.cls = cls;
        config = new AnnotationConfiguration();
        config.addAnnotatedClass(this.cls);
        config.configure("hibernate.cfg.xml");
        // new SchemaExport(config).create(true, true); // deprecata dalla nuova

    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(int id) {
        Session session = config.buildSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Object obj = session.get(cls, id);
            session.delete(obj);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }
    }

    /**
     * Insert.
     *
     * @param obj the obj
     */
    public void insert(Object obj) {
        Session session = config.buildSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(obj);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();

        } finally {
            // session.close();
        }
    }

    /**
     * Select.
     *
     * @return the list
     */
    @SuppressWarnings("unchecked")
    public List<Object> select() {
        Session session = config.buildSessionFactory().getCurrentSession();
        Transaction transaction = null;
        List<Object> result = null;
        try {
            transaction = session.beginTransaction();
            System.out.println(cls.getSimpleName());
            result = session.createQuery("FROM " + cls.getSimpleName()).list();
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();

        } finally {
            // session.close();
        }
        return result;
    }
}
