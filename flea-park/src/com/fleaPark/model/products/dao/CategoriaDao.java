package com.fleaPark.model.products.dao;

import java.util.ArrayList;
import java.util.List;

import com.fleaPark.model.products.Categoria;
import com.fleaPark.services.persistence.dao.EntityDao;
import com.fleaPark.services.persistence.dao.EntityDaoHibernate;
import com.mysql.fabric.xmlrpc.base.Array;

public interface CategoriaDao extends EntityDao<Categoria, Long> {
    public class CategoriaDaoHibernate extends EntityDaoHibernate<Categoria, Long> implements CategoriaDao {

        @Override
        protected List<Class> dependingClasses() {
            List<Class> classes = new ArrayList<>();
            classes.add(Categoria.class);
            return null;
        }

    }

}
