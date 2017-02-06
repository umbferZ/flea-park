/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.people.dao
 * Type: UtenteDao
 * Last update: 6-feb-2017 1.34.21
 * 
 */
package com.fleaPark.model.people.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.fleaPark.model.people.Utente;
import com.fleaPark.model.products.Prodotto;
import com.fleaPark.services.persistence.dao.EntityDao;
import com.fleaPark.services.persistence.dao.EntityDaoHibernate;
import com.fleaPark.tools.debug.Message4Debug;

public interface UtenteDao extends EntityDao<Utente, Integer> {
    public Utente getUtenteByEmailAndPassword(String email, String password) throws Exception;

    public class UtenteDaoHibernate extends EntityDaoHibernate<Utente, Integer> implements UtenteDao {
        @SuppressWarnings("unchecked")
        @Override
        public Utente getUtenteByEmailAndPassword(String email, String password) throws Exception {
            Message4Debug.addTrace(this.getClass().getName() + ".getByEmailAndPassword()");
            String sql = " from Utente u where u.email=:email and u.password=:password";
            Query query = super.openSession().createQuery(sql);
            query.setParameter("email", email);
            query.setParameter("password", password);
            List<Utente> list = query.list();
            closeSession();
            if (list.size() == 1)
                return list.get(0);
            throw new Exception("corrispondenza non trovata");
        }

        @SuppressWarnings("rawtypes")
        @Override
        protected List<Class> dependingClasses() {
            List<Class> classes = new ArrayList<>();
            classes.add(Prodotto.class);
            return null;
        }

    }

}
