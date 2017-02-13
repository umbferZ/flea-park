/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.place.dao
 * Type: NazioneDao
 * Last update: 13-feb-2017 7.07.17
 * 
 */
package com.fleaPark.model.place.dao;

import java.util.ArrayList;
import java.util.List;

import org.umbZfer.services.persistence.dao.EntityDao;
import org.umbZfer.services.persistence.dao.csv.EntityDaoCSV;
import org.umbZfer.services.persistence.dao.hibernate.EntityDaoHibernate;

import com.fleaPark.model.place.Nazione;

public interface NazioneDao extends EntityDao<Nazione, Integer> {

    public class NazioneDaoCSV extends EntityDaoCSV<Nazione, Integer> implements NazioneDao {

        public NazioneDaoCSV() {
            super("csv/table_nazione.csv");
        }

        @Override
        public List<Nazione> getAll() {
            List<Nazione> nazioni = new ArrayList<>();
            for (String[] row : getRows())
                nazioni.add(new Nazione(Integer.parseInt(row[0]), row[1]));
            return nazioni;
        }

    }

    public class NazioneDaoHibernate extends EntityDaoHibernate<Nazione, Integer> implements NazioneDao {
        @Override
        public void importDump() {
            org.hibernate.Session session = openSession();
            org.hibernate.Transaction t = session.beginTransaction();
            NazioneDaoCSV n = new NazioneDaoCSV();
            for (String[] str : n.getRows()) {
                String sql = "INSERT INTO Nazione VALUES (:id, :nome)";
                org.hibernate.SQLQuery q = session.createSQLQuery(sql);
                q.setParameter("id", Integer.parseInt(str[0]));
                q.setParameter("nome", str[1]);
                q.executeUpdate();
            }
            t.commit();
            closeSession();
        }

    }
}
