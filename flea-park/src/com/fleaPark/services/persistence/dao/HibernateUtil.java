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

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/**
 * The Class HibernateUtil.
 */
public class HibernateUtil {
    private static final SessionFactory concreteSessionFactory;
    static {
        try {

            concreteSessionFactory = ConfigUtil.getInstance().getConfig().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return concreteSessionFactory.openSession();
    }

    // public static void main(String... args) {
    // Session session = getSession();
    // session.beginTransaction();
    // User user = (User) session.get(User.class, new Integer(1));
    // System.out.println(user.getName());
    // session.close();
    // }
}