/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: org.umbZfer.services.persistence.dao.hibernate
 * Type: EntityDaoHibernate
 * Last update: 13-feb-2017 4.41.54
 * 
 */
package org.umbZfer.services.persistence.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.umbZfer.services.persistence.dao.EntityDao;

/**
 * The Class EntityDaoHibernate.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public abstract class EntityDaoHibernate<T, ID extends Serializable> implements EntityDao<T, ID> {

    private Class<T> persistentClass;
    private Session session;

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

    public void createQuery(String sql) {
        Session s = openSession();
        Transaction tx = s.beginTransaction();
        s.createQuery(sql).executeUpdate();
        tx.commit();
        closeSession();
    }

    /*
     * (non-Javadoc)
     * @see
     * org.umbZfer.services.persistence.dao.EntityDao#delete(java.lang.Object)
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
     * @see org.umbZfer.services.persistence.dao.EntityDao#getAll()
     */
    @Override
    public List<T> getAll() {
        return findByCriteria();

    }

    /*
     * (non-Javadoc)
     * @see
     * org.umbZfer.services.persistence.dao.EntityDao#getByExample(java.lang.
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
        closeSession();
        return crit.list();
    }

    /*
     * (non-Javadoc)
     * @see org.umbZfer.services.persistence.dao.EntityDao#getById(java.io.
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

    @Override
    public void importDump() {

    }

    /*
     * (non-Javadoc)
     * @see
     * org.umbZfer.services.persistence.dao.EntityDao#insert(java.lang.Object)
     */
    @Override
    public T insert(T entity) {
        Session s = openSession();
        Transaction transaction = null;
        try {
            transaction = s.beginTransaction();
            s.saveOrUpdate(entity);
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
        HibernateUtil.closeSession();
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
        List<T> l = crit.list();
        closeSession();
        return l;
    }

    /**
     * Open session.
     *
     * @return the session
     */
    protected Session openSession() {
        return HibernateUtil.getSession();

    }

}
