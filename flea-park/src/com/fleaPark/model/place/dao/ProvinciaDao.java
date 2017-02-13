/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.place.dao
 * Type: ProvinciaDao
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
import com.fleaPark.model.place.Provincia;
import com.fleaPark.model.place.Regione;

public interface ProvinciaDao extends EntityDao<Provincia, Integer> {
    public class ProvinciaDaoCSV extends EntityDaoCSV<Provincia, Integer> implements ProvinciaDao {

        public ProvinciaDaoCSV() {
            super("csv/table_provincia.csv");
        }

        @Override
        public List<Provincia> getAll() {
            List<Provincia> province = new ArrayList<>();
            for (String[] r : getRows()) {
                // FIXME: prevedere getById() da file CSV
                Regione regione = DaoFactory.getInstance().getRegioneDao().getById(Integer.parseInt(r[2]), false);
                province.add(new Provincia(Integer.parseInt(r[0]), r[1], regione));
            }
            return province;
        }

    }

    public class ProvinciaDaoHibernate extends EntityDaoHibernate<Provincia, Integer> implements ProvinciaDao {
        @Override
        public void importDump() {
            org.hibernate.Session session = openSession();
            org.hibernate.Transaction t = session.beginTransaction();
            ProvinciaDaoCSV n = new ProvinciaDaoCSV();
            for (String[] str : n.getRows()) {
                String sql = "INSERT INTO Provincia VALUES (:id, :nome, :regione)";
                org.hibernate.SQLQuery q = session.createSQLQuery(sql);
                q.setParameter("id", Integer.parseInt(str[0]));
                q.setParameter("nome", str[1]);
                q.setParameter("regione", Integer.parseInt(str[2]));
                q.executeUpdate();
            }
            t.commit();
            closeSession();
        }
    }

}
