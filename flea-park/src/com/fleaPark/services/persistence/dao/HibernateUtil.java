/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.services.persistence.dao
 * Type: HibernateUtil
 * Last update: 10-feb-2017 18.13.15
 * 
 */
package com.fleaPark.services.persistence.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * The Class HibernateUtil.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Gets the session factory.
     *
     * @return the session factory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
