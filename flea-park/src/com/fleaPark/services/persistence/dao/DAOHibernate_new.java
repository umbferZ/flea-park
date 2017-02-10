/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.services.persistence.dao
 * Type: DAOHibernate_new
 * Last update: 10-feb-2017 12.15.04
 * 
 */
package com.fleaPark.services.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.fleaPark.tools.debug.Message4Debug;

/**
 * The Class DAOHibernate_new.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
@Deprecated
public class DAOHibernate_new<T, ID extends Serializable> implements EntityDao<T, ID> {

    private Class<T> cls;
    private AnnotationConfiguration config;

    /**
     * Instantiates a new DAO hibernate new.
     */
    @SuppressWarnings("unchecked")
    public DAOHibernate_new() {
        this.cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
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

    /*
     * (non-Javadoc)
     * @see
     * com.javacanze.service.persistence.dao.EntityDAO#delete(java.lang.Object)
     */
    @Override
    public void delete(T entity) {

    }

    /*
     * (non-Javadoc)
     * @see com.javacanze.service.persistence.dao.EntityDAO#findAll()
     */
    @Override
    public List<T> getAll() {
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.javacanze.service.persistence.dao.EntityDAO#findByExample(java.lang.
     * Object, java.lang.String[])
     */
    @Override
    public List<T> getByExample(T exampleInstance, String[] excludeProperty) {
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.javacanze.service.persistence.dao.EntityDAO#findById(java.io.
     * Serializable, boolean)
     */
    @Override
    public T getById(ID id, boolean lock) {
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.javacanze.service.persistence.dao.EntityDAO#insert(java.lang.Object)
     */
    @Override
    public T insert(T entity) {
        Message4Debug.addTrace(this.getClass().getName() + ".insert()");
        Session session = openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            closeSession();
        }
        return entity;
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

    /**
     * Close session.
     */
    protected void closeSession() {
        Message4Debug.addTrace(this.getClass().getName() + ".closeSession()");
        config.buildSessionFactory().getCurrentSession().close();
    }

    /**
     * Open session.
     *
     * @return the session
     */
    protected Session openSession() {
        Message4Debug.addTrace(this.getClass().getName() + ".openSession()");
        Session s = config.buildSessionFactory().openSession();
        return s;
    }
}
