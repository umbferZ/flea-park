/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.services.persistence.dao
 * Type: EntityDaoHibernate
 * Last update: 3-feb-2017 23.55.06
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
import org.hibernate.exception.ConstraintViolationException;

import com.fleaPark.tools.debug.Message4Debug;

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
        Message4Debug.addTrace(this.getClass().getName() + ".contructor() for entity");
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        config = new AnnotationConfiguration();
        config.addAnnotatedClass(persistentClass);
        List<Class> classes = dependingClasses();
        if (classes != null)
            for (Class c : classes)
                config.addAnnotatedClass(c);
        config.configure("hibernate.cfg.xml");
        Message4Debug.addTrace(persistentClass.getName());
    }

    /**
     * Instantiates a new entity dao hibernate.
     *
     * @param classes the classes
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Deprecated
    public EntityDaoHibernate(List<Class> classes) {
        Message4Debug.addTrace(this.getClass().getName() + ".contructor() for entity");
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        config = new AnnotationConfiguration();
        config.addAnnotatedClass(persistentClass);
        if (classes != null)
            for (Class c : classes)
                config.addAnnotatedClass(c);
        config.configure("hibernate.cfg.xml");
        Message4Debug.addTrace(persistentClass.getName());
    }

    /**
     * Adds the annotated class.
     *
     * @param t the t
     */
    @Deprecated
    public void addAnnotatedClass(@SuppressWarnings("rawtypes") Class t) {
        Message4Debug.addTrace(this.getClass().getName() + ".addAnnotatedClass()");
        config.addAnnotatedClass(t);
    }

    /**
     * Clear.
     */
    public void clear() {
        Message4Debug.addTrace(this.getClass().getName() + ".clear()");
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
        Message4Debug.addTrace(this.getClass().getName() + ".makeTransient()");
        openSession().delete(entity);
        closeSession();
    }

    /**
     * Flush.
     */
    public void flush() {
        Message4Debug.addTrace(this.getClass().getName() + ".flush()");
        openSession().flush();
        closeSession();
    }

    /*
     * (non-Javadoc)
     * @see com.fleaPark.services.persistence.dao.EntityDao#getAll()
     */
    @Override
    public List<T> getAll() {
        Message4Debug.addTrace(this.getClass().getName() + ".findAll()");
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
        Message4Debug.addTrace(this.getClass().getName() + ".findByExample()");
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
        Message4Debug.addTrace(this.getClass().getName() + ".findById()");
        T entity;
        if (lock)
            entity = (T) openSession().load(getPersistentClass(), id, LockMode.UPGRADE);
        else
            entity = (T) openSession().load(getPersistentClass(), id);
        closeSession();
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
        Message4Debug.addTrace(this.getClass().getName() + ".getPersistentClass()");
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
        Message4Debug.addTrace(this.getClass().getName() + ".insert()");
        Session s = openSession();
        Transaction transaction = null;
        try {
            transaction = s.beginTransaction();
            s.save(entity);
            s.flush();
            transaction.commit();
        } catch (ConstraintViolationException e) {
            Message4Debug.addTrace("EntityDaoHibernate.insert(T entity):");
            Message4Debug.addTrace(e.getMessage());
            // e.printStackTrace();
        } catch (HibernateException e) {
            Message4Debug.log(e.getMessage());
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (s != null)
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
        Message4Debug.addTrace(this.getClass().getName() + ".setConfig()");
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
        Message4Debug.addTrace(this.getClass().getName() + ".setSession()");
        this.session = s;
    }

    /**
     * Close session.
     */
    protected void closeSession() {
        Message4Debug.addTrace(this.getClass().getName() + ".closeSession()");
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
        Message4Debug.addTrace(this.getClass().getName() + ".findByCriteria()");
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
        Message4Debug.addTrace(this.getClass().getName() + ".openSession()");
        // Session s = config.buildSessionFactory().getCurrentSession();
        // if (config.buildSessionFactory().isClosed()) {
        return config.buildSessionFactory().openSession();
        // } else {
        // return config.buildSessionFactory().getCurrentSession();
        // }
    }
}
