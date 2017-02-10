/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.services.persistence.dao
 * Type: EntityDaoHibernate
 * Last update: 10-feb-2017 12.15.04
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

/**
 * The Class EntityDaoHibernate.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public abstract class EntityDaoHibernate<T, ID extends Serializable> implements EntityDao<T, ID> {

    private AnnotationConfiguration config;
    private Class<T> persistentClass;

    private Session session; // FIXME remove this attribute

    /**
     * Instantiates a new entity dao hibernate.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public EntityDaoHibernate() {
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        config = new AnnotationConfiguration();
        config.addAnnotatedClass(persistentClass);
        List<Class> classes = dependingClasses();
        if (classes != null)
            for (Class c : classes)
                config.addAnnotatedClass(c);
        config.configure("hibernate.cfg.xml");
    }

    // /**
    // * Instantiates a new entity dao hibernate.
    // *
    // * @param classes the classes
    // */
    // @SuppressWarnings({ "unchecked", "rawtypes" })
    // @Deprecated
    // public EntityDaoHibernate(List<Class> classes) {
    // Message4Debug.addTrace(this.getClass().getName() + ".contructor() for
    // entity");
    // persistentClass = (Class<T>) ((ParameterizedType)
    // getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    // config = new AnnotationConfiguration();
    // config.addAnnotatedClass(persistentClass);
    // if (classes != null)
    // for (Class c : classes)
    // config.addAnnotatedClass(c);
    // config.configure("hibernate.cfg.xml");
    // Message4Debug.addTrace(persistentClass.getName());
    // }

    // /**
    // * Adds the annotated class.
    // *
    // * @param t the t
    // */
    // @Deprecated
    // public void addAnnotatedClass(@SuppressWarnings("rawtypes") Class t) {
    // Message4Debug.addTrace(this.getClass().getName() +
    // ".addAnnotatedClass()");
    // config.addAnnotatedClass(t);
    // }

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
        Session s = config.buildSessionFactory().openSession();
        if (lock)
            entity = (T) s.load(getPersistentClass(), id, LockMode.UPGRADE);
        else
            entity = (T) s.load(getPersistentClass(), id);
        config.buildSessionFactory().getCurrentSession().close();
        return entity;
    }

    /**
     * Gets the config.
     *
     * @return the config
     */
    public AnnotationConfiguration getConfig() {
        return config;
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
            s.close();
        }
        return entity;
    }

    /**
     * Sets the config.
     *
     * @param config the new config
     */
    public void setConfig(AnnotationConfiguration config) {
        this.config = config;

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
     * Sets the session.
     *
     * @param s the new session
     */
    public void setSession(Session s) {
        this.session = s;
    }

    /**
     * Close session.
     */
    protected void closeSession() {
        // FIXME trovare soluzione per le troppe connessioni
        config.buildSessionFactory().getCurrentSession().close();
    }

    /**
     * Depending classes.
     *
     * @return the list
     */
    @SuppressWarnings("rawtypes")
    protected abstract List<Class> dependingClasses();

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
        // FIXME : trovare soluzione per le troppe connessioni
        // Session s = config.buildSessionFactory().getCurrentSession();
        // if (config.buildSessionFactory().isClosed()) {
        return config.buildSessionFactory().openSession();
        // } else {
        // return config.buildSessionFactory().getCurrentSession();
        // }
    }

}
