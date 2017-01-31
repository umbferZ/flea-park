package com.fleaPark.model.people.dao;

import java.util.List;

import org.hibernate.Query;

import com.fleaPark.model.people.User;
import com.fleaPark.services.persistence.dao.EntityDao;
import com.fleaPark.services.persistence.dao.EntityDaoHibernate;
import com.fleaPark.tools.debug.Message4Debug;


public interface UserDAO extends EntityDao<User, Long> {
    public class UserDAOHibernate extends EntityDaoHibernate<User, Long> implements UserDAO {
        @SuppressWarnings("unchecked")
        @Override
        public User getUserByEmailAndPassword(String email, String password) throws Exception {
            Message4Debug.addTrace(this.getClass().getName() + ".getByEmailAndPassword()");
            String sql = " from User u where u.email=:email and u.password=:password";
            Query query = super.openSession().createQuery(sql);
            query.setParameter("email", email);
            query.setParameter("password", password);
            List<User> list = query.list();
            closeSession();
            if (list.size() == 1)
                return list.get(0);
            throw new Exception("corrispondenza non trovata");
        }

        @SuppressWarnings("rawtypes")
        @Override
        protected List<Class> dependingClasses() {
            // TODO Auto-generated method stub
            return null;
        }

    }

    public User getUserByEmailAndPassword(String email, String password) throws Exception;

}
