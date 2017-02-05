/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products.dao
 * Type: CategoriaDao
 * Last update: 3-feb-2017 23.55.05
 * 
 */
package com.fleaPark.model.products.dao;

import java.util.ArrayList;
import java.util.List;

import com.fleaPark.model.products.Categoria;
import com.fleaPark.services.persistence.dao.EntityDao;
import com.fleaPark.services.persistence.dao.EntityDaoHibernate;

public interface CategoriaDao extends EntityDao<Categoria, Integer> {
    public class CategoriaDaoHibernate extends EntityDaoHibernate<Categoria, Integer> implements CategoriaDao {

        @Override
        protected List<Class> dependingClasses() {
            List<Class> classes = new ArrayList<>();
            classes.add(Categoria.class);
            return null;
        }

    }

}
