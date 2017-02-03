/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.object.dao
 * Type: ProdottoDao
 * Last update: 31-gen-2017 18.10.48
 * 
 */
package com.fleaPark.model.products.dao;

import java.util.ArrayList;
import java.util.List;

import com.fleaPark.model.people.Utente;
import com.fleaPark.model.products.Prezzo;
import com.fleaPark.model.products.Prodotto;
import com.fleaPark.services.persistence.dao.EntityDao;
import com.fleaPark.services.persistence.dao.EntityDaoHibernate;

public interface ProdottoDao extends EntityDao<Prodotto, Long> {
    public class ProdottoDaoHibernate extends EntityDaoHibernate<Prodotto, Long> implements ProdottoDao {

        @Override
        protected List<Class> dependingClasses() {
            List<Class> classes = new ArrayList<>();
            classes.add(Utente.class);
            return classes;
        }

    }

}
