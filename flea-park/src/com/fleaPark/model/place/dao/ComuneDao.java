/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.place.dao
 * Type: ComuneDao
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.model.place.dao;

import java.util.ArrayList;
import java.util.List;

import org.umbZfer.services.persistence.dao.EntityDao;
import org.umbZfer.services.persistence.dao.csv.EntityDaoCSV;
import org.umbZfer.services.persistence.dao.hibernate.EntityDaoHibernate;

import com.fleaPark.model.DaoFactory;
import com.fleaPark.model.place.Comune;
import com.fleaPark.model.place.Provincia;

public interface ComuneDao extends EntityDao<Comune, Integer> {
    public class ComuneDaoCSV extends EntityDaoCSV<Comune, Integer> implements ComuneDao {

        public ComuneDaoCSV() {
            super("csv/table_comune.csv");
        }

        @Override
        public List<Comune> getAll() {
            List<Comune> comuni = new ArrayList<>();
            for (String[] r : getRows()) {
                Provincia provincia = DaoFactory.getInstance().getProvinciaDao().getById(Integer.parseInt(r[2]), false);
                comuni.add(new Comune(Integer.parseInt(r[0]), r[1], provincia));
            }
            return comuni;
        }

    }

    public class ComuneDaoHibernate extends EntityDaoHibernate<Comune, Integer> implements ComuneDao {
        @Override
        public void importDump() {
            org.hibernate.Session session = openSession();
            org.hibernate.Transaction t = session.beginTransaction();
            ComuneDaoCSV n = new ComuneDaoCSV();
            for (String[] str : n.getRows()) {
                String sql = "INSERT INTO Comune (id, nome, provincia_id) VALUES (:id, :nome, :provincia)";
                org.hibernate.SQLQuery q = session.createSQLQuery(sql);
                q.setParameter("id", Integer.parseInt(str[0]));
                q.setParameter("nome", str[1]);
                q.setParameter("provincia", Integer.parseInt(str[2]));
                q.executeUpdate();
            }
            t.commit();
            closeSession();
        }

    }

}
