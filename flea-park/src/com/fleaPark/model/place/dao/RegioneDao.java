/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.place.dao
 * Type: RegioneDao
 * Last update: 13-feb-2017 7.07.17
 * 
 */
package com.fleaPark.model.place.dao;

import java.util.ArrayList;
import java.util.List;

import org.umbZfer.services.persistence.dao.EntityDao;
import org.umbZfer.services.persistence.dao.csv.EntityDaoCSV;
import org.umbZfer.services.persistence.dao.hibernate.EntityDaoHibernate;

import com.fleaPark.model.DaoFactory;
import com.fleaPark.model.place.Nazione;
import com.fleaPark.model.place.Regione;

public interface RegioneDao extends EntityDao<Regione, Integer> {

    public class RegioneDaoCSV extends EntityDaoCSV<Regione, Integer> implements RegioneDao {

        public RegioneDaoCSV() {
            super("csv/table_regione.csv");
        }

        @Override
        public List<Regione> getAll() {
            List<Regione> regioni = new ArrayList<>();
            for (String[] row : getRows()) {
                // FIXME: prevedere getById() da file CSV
                Nazione nazione = DaoFactory.getInstance().getNazioneDao().getById(Integer.parseInt(row[2]), false);
                regioni.add(new Regione(Integer.parseInt(row[0]), row[1], nazione));
            }
            return regioni;
        }

    }

    public class RegioneDaoHibernate extends EntityDaoHibernate<Regione, Integer> implements RegioneDao {

        @Override
        public void importDump() {
            org.hibernate.Session session = openSession();
            org.hibernate.Transaction t = session.beginTransaction();
            RegioneDaoCSV n = new RegioneDaoCSV();
            for (String[] str : n.getRows()) {
                String sql = "INSERT INTO Regione VALUES (:id, :nome, :nazione)";
                org.hibernate.SQLQuery q = session.createSQLQuery(sql);
                q.setParameter("id", Integer.parseInt(str[0]));
                q.setParameter("nome", str[1]);
                q.setParameter("nazione", Integer.parseInt(str[2]));
                q.executeUpdate();
            }
            t.commit();
            closeSession();
        }

    }

}
