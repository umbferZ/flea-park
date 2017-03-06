/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products.dao
 * Type: ProdottoDao
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.model.products.dao;

import java.util.List;

import org.hibernate.Query;
import org.umbZfer.services.persistence.dao.EntityDao;
import org.umbZfer.services.persistence.dao.hibernate.EntityDaoHibernate;

import com.fleaPark.model.people.Utente;
import com.fleaPark.model.products.Prodotto;

public interface ProdottoDao extends EntityDao<Prodotto, Integer> {
    
    public List<Prodotto> getProdottoByIdUtente(Utente utente);

    public List<Prodotto> getProdottoNonVendutoLikeParolaChiave(String parolachiave);

    public class ProdottoDaoHibernate extends EntityDaoHibernate<Prodotto, Integer> implements ProdottoDao {

        @Override
        public List<Prodotto> getProdottoByIdUtente(Utente utente) {
            String q = "FROM Prodotto p WHERE venditore=:idUtente";
            Query query = super.openSession().createQuery(q);
            query.setParameter("idUtente", utente);
            @SuppressWarnings("unchecked") List<Prodotto> list = query.list();
            closeSession();
            return list;
        }

        @Override
        public List<Prodotto> getProdottoNonVendutoLikeParolaChiave(String parolachiave) {
            // TODO: Trovare modo per interrogazione multipla (JOIN?)
            String sql = "FROM Prodotto p WHERE p.acquirente is NULL AND p.nome LIKE :parolaChiave OR p.descrizione LIKE :parolaChiave";
            Query query = super.openSession().createQuery(sql);
            query.setParameter("parolaChiave", "%" + parolachiave + "%");
            @SuppressWarnings("unchecked") List<Prodotto> list = query.list();
            closeSession();
            return list;
        }

    }

}
