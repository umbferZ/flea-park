/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: org.umbZfer.services.persistence.dao.hibernate
 * Type: HibernateUtil
 * Last update: 13-feb-2017 7.07.17
 * 
 */
package org.umbZfer.services.persistence.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

/**
 * The Class HibernateUtil.
 */
public class HibernateUtil {
    private static final SessionFactory concreteSessionFactory;

    static {
        try {

            concreteSessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Close session.
     */
    public static void closeSession() {
        concreteSessionFactory.getCurrentSession().close();
    }

    /**
     * Gets the session.
     *
     * @return the session
     * @throws HibernateException the hibernate exception
     */
    public static Session getSession() throws HibernateException {
        return concreteSessionFactory.openSession();
    }

}