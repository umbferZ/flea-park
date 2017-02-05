/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products.dao
 * Type: ProdottoDao
 * Last update: 3-feb-2017 23.55.06
 * 
 */
package com.fleaPark.model.products.dao;

import java.util.ArrayList;
import java.util.List;

import com.fleaPark.model.people.Utente;
import com.fleaPark.model.products.Categoria;
import com.fleaPark.model.products.Prodotto;
import com.fleaPark.services.persistence.dao.EntityDao;
import com.fleaPark.services.persistence.dao.EntityDaoHibernate;

public interface ProdottoDao extends EntityDao<Prodotto, Integer> {
    public class ProdottoDaoHibernate extends EntityDaoHibernate<Prodotto, Integer> implements ProdottoDao {

        @SuppressWarnings("rawtypes")
        @Override
        protected List<Class> dependingClasses() {
            List<Class> classes = new ArrayList<>();
            classes.add(Utente.class);
            classes.add(Categoria.class);
            return classes;
        }

    }

}
