/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products.dao
 * Type: CategoriaDao
 * Last update: 10-feb-2017 18.13.15
 * 
 */
package com.fleaPark.model.products.dao;

import com.fleaPark.model.products.Categoria;
import com.fleaPark.services.persistence.dao.EntityDao;
import com.fleaPark.services.persistence.dao.EntityDaoHibernate;

public interface CategoriaDao extends EntityDao<Categoria, Integer> {
    public class CategoriaDaoHibernate extends EntityDaoHibernate<Categoria, Integer> implements CategoriaDao {


    }

}
