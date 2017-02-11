/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.services.persistence.dao
 * Type: EntityDaoHibernate
 * Last update: 10-feb-2017 18.13.15
 * 
 */
package com.fleaPark.services.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

import com.fleaPark.tools.debug.Message4Debug;

/**
 * The Class EntityDaoHibernate.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public abstract class EntityDaoHibernate<T, ID extends Serializable> implements EntityDao<T, ID> {

    private Class<T> persistentClass;

    private Session session;

    private static long countOpenSession = 0;
    private static long countCloseSession = 0;

    /**
     * Instantiates a new entity dao hibernate.
     */

    @SuppressWarnings("unchecked")
    public EntityDaoHibernate() {
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * Clear.
     */
    public void clear() {
        openSession().clear();
        closeSession();
    }

    /*
     * (non-Javadoc)
     * @see
     * com.fleaPark.services.persistence.dao.EntityDao#delete(java.lang.Object)
     */
    @Override
    public void delete(T entity) {
        openSession().delete(entity);
        closeSession();
    }

    /**
     * Flush.
     */
    public void flush() {
        openSession().flush();
        closeSession();
    }

    /*
     * (non-Javadoc)
     * @see com.fleaPark.services.persistence.dao.EntityDao#getAll()
     */
    @Override
    public List<T> getAll() {
        return findByCriteria();

    }

    /*
     * (non-Javadoc)
     * @see
     * com.fleaPark.services.persistence.dao.EntityDao#getByExample(java.lang.
     * Object, java.lang.String[])
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> getByExample(T exampleInstance, String[] excludeProperty) {
        Criteria crit = openSession().createCriteria(getPersistentClass());
        Example example = Example.create(exampleInstance);
        if (excludeProperty != null)
            for (String exclude : excludeProperty)
                example.excludeProperty(exclude);
        crit.add(example);
        return crit.list();
    }

    /*
     * (non-Javadoc)
     * @see com.fleaPark.services.persistence.dao.EntityDao#getById(java.io.
     * Serializable, boolean)
     */
    @Override
    @SuppressWarnings("unchecked")
    public T getById(ID id, boolean lock) {
        T entity;
        Session s = openSession();
        if (lock)
            // entity = (T) s.load(getPersistentClass(), id, LockMode.UPGRADE);
            entity = (T) s.get(getPersistentClass(), id);
        else
            // entity = (T) s.load(getPersistentClass(), id);
            entity = (T) s.get(getPersistentClass(), id);
        closeSession();
        return entity;
    }



    /**
     * Gets the persistent class.
     *
     * @return the persistent class
     */
    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    /**
     * Gets the session.
     *
     * @return the session
     */
    public Session getSession() {
        return session;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.fleaPark.services.persistence.dao.EntityDao#insert(java.lang.Object)
     */
    @Override
    public T insert(T entity) {
        Session s = openSession();
        Transaction transaction = null;
        try {
            transaction = s.beginTransaction();
            s.persist(entity);
            s.flush();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            closeSession();
        }
        return entity;
    }



    /**
     * Sets the persistent class.
     *
     * @param persistentClass the new persistent class
     */
    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }



    /**
     * Close session.
     */
    protected void closeSession() {
        countCloseSession++;
        Message4Debug.log("session number " + countCloseSession + " closed");
        // config.buildSessionFactory().getCurrentSession().close();
        HibernateUtil.getSession().close();
    }

    /**
     * Find by criteria.
     *
     * @param criterion the criterion
     * @return the list
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = openSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion)
            crit.add(c);
        closeSession();
        return crit.list();
    }

    /**
     * Open session.
     *
     * @return the session
     */
    protected Session openSession() {
        countOpenSession++;
        Message4Debug.log("Opening session number " + countOpenSession);
        return HibernateUtil.getSession();

    }

}
