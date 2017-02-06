/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.services.persistence.dao
 * Type: EntityDaoJDBC
 * Last update: 6-feb-2017 1.34.20
 * 
 */
package com.fleaPark.services.persistence.dao;

import java.io.Serializable;
import java.util.List;

public abstract class EntityDaoJDBC<T, ID extends Serializable> implements EntityDao<T, Serializable> {

    @Override
    public void delete(T entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<T> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> getByExample(T exampleInstance, String[] excludeProperty) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T getById(Serializable id, boolean lock) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T insert(T entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
