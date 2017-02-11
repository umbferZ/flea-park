/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products.dao
 * Type: ProdottoDao
 * Last update: 10-feb-2017 18.13.15
 * 
 */
package com.fleaPark.model.products.dao;

import java.util.List;

import org.hibernate.Query;

import com.fleaPark.model.people.Utente;
import com.fleaPark.model.products.Prodotto;
import com.fleaPark.services.persistence.dao.EntityDao;
import com.fleaPark.services.persistence.dao.EntityDaoHibernate;

public interface ProdottoDao extends EntityDao<Prodotto, Integer> {
    public List<Prodotto> getProdottoByIdUtente(Utente utente);

    public List<Prodotto> getProdottoLikeParolaChiave(String parolachiave);

    public class ProdottoDaoHibernate extends EntityDaoHibernate<Prodotto, Integer> implements ProdottoDao {

        @Override
        public List<Prodotto> getProdottoByIdUtente(Utente utente) {
            String q = "from Prodotto p where venditore=:idUtente";
            Query query = super.openSession().createQuery(q);
            query.setParameter("idUtente", utente);
            List<Prodotto> list = query.list();
            closeSession();
            return list;
        }

        @Override
        public List<Prodotto> getProdottoLikeParolaChiave(String parolachiave) {
            // TODO: Trovare modo per interrogazione multipla (JOIN?)
            String[] words = parolachiave.split(" ");
            String q = " p.nome like :" + words[0] + " OR p.descrizione like :" + words[0];

            for (String w : words)
                q += " OR p.nome like :" + w + " OR p.descrizione like :" + w;

            // String sql = "from Prodotto p where p.nome like :parolaChiave";
            String sql = "from Prodotto p where " + q;
            Query query = super.openSession().createQuery(sql);
            for (String w : words)
                query.setParameter(w, "%" + w + "%");
            List<Prodotto> list = query.list();
            closeSession();
            return list;
        }

 

    }

}
