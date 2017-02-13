/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products.dao
 * Type: CategoriaDao
 * Last update: 13-feb-2017 7.07.17
 * 
 */
package com.fleaPark.model.products.dao;

import java.util.List;

import org.umbZfer.services.persistence.dao.EntityDao;
import org.umbZfer.services.persistence.dao.csv.EntityDaoCSV;
import org.umbZfer.services.persistence.dao.hibernate.EntityDaoHibernate;

import com.fleaPark.model.products.Categoria;

public interface CategoriaDao extends EntityDao<Categoria, Integer> {
    public class CategoriaDaoCSV extends EntityDaoCSV<Categoria, Integer> implements CategoriaDao {

        public CategoriaDaoCSV() {
            super("csv/table_categoria.csv");
        }

        @Override
        public List<Categoria> getAll() {
            // TODO Auto-generated method stub
            return null;
        }

    }

    public class CategoriaDaoHibernate extends EntityDaoHibernate<Categoria, Integer> implements CategoriaDao {

        @Override
        public void importDump() {
            org.hibernate.Session session = openSession();
            org.hibernate.Transaction t = session.beginTransaction();
            CategoriaDaoCSV n = new CategoriaDaoCSV();
            for (String[] str : n.getRows()) {
                String sql = "INSERT INTO Categoria  VALUES (:id, :nome, :parent)";
                org.hibernate.SQLQuery q = session.createSQLQuery(sql);
                q.setParameter("id", Integer.parseInt(str[0]));
                q.setParameter("nome", str[1]);
                if (str[2].length() != 0)
                    q.setParameter("parent", Integer.parseInt(str[2]));
                else
                    q.setParameter("parent", null);
                q.executeUpdate();
            }
            t.commit();
            closeSession();
        }

    }

}
