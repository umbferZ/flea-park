/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products.dao
 * Type: ProdottoDao
 * Last update: 13-feb-2017 7.07.17
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
            List<Prodotto> list = query.list();
            closeSession();
            return list;
        }

        @Override
        public List<Prodotto> getProdottoNonVendutoLikeParolaChiave(String parolachiave) {
            // TODO: Trovare modo per interrogazione multipla (JOIN?)
            String[] words = parolachiave.split(" ");
            String q = " p.nome LIKE :" + words[0] + " OR p.descrizione LIKE :" + words[0];

            for (String w : words)
                q += " OR p.nome LIKE :" + w + " OR p.descrizione LIKE :" + w;

            // String sql = "from Prodotto p where p.nome like :parolaChiave";
            String sql = "FROM Prodotto p WHERE " + q + " AND acquirente_id IS NULL";
            Query query = super.openSession().createQuery(sql);
            for (String w : words)
                query.setParameter(w, "%" + w + "%");
            List<Prodotto> list = query.list();
            closeSession();
            return list;
        }

    }

}
