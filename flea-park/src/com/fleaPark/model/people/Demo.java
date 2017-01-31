package com.fleaPark.model.people;

import org.hibernate.Session;

import com.fleaPark.services.persistence.dao.HibernateUtil;

public class Demo {
    public static void main(String[] args) {
        User user = new User();
        user.setFirstName("Umberto");
        user.setLastName("Ferracci");
        user.setEmail("umberto.ferracci@gmail.com");
        user.setPassword("fleaPark");

        Session sessionOne = HibernateUtil.getSessionFactory().openSession();
        sessionOne.beginTransaction();

        // Save employee
        sessionOne.save(user);
        sessionOne.getTransaction().commit();

    }
}
