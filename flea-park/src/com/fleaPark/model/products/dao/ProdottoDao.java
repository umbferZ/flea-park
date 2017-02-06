/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products.dao
 * Type: ProdottoDao
 * Last update: 6-feb-2017 1.34.21
 * 
 */
package com.fleaPark.model.products.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.fleaPark.model.people.Utente;
import com.fleaPark.model.products.Categoria;
import com.fleaPark.model.products.Prodotto;
import com.fleaPark.services.persistence.dao.EntityDao;
import com.fleaPark.services.persistence.dao.EntityDaoHibernate;

public interface ProdottoDao extends EntityDao<Prodotto, Integer> {
    public List<Prodotto> getProdottoLikeParolaChiave(String parolachiave);

    public class ProdottoDaoHibernate extends EntityDaoHibernate<Prodotto, Integer> implements ProdottoDao {

        @Override
        public List<Prodotto> getProdottoLikeParolaChiave(String parolachiave) {
            String sql = " from Prodotto p where p.nome like :parolaChiave";
            Query query = super.openSession().createQuery(sql);
            query.setParameter("parolaChiave", "%" + parolachiave + "%");
            List<Prodotto> list = query.list();
            closeSession();
            return list;
        }

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
