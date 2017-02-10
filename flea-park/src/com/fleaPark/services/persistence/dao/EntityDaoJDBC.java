/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.services.persistence.dao
 * Type: EntityDaoJDBC
 * Last update: 10-feb-2017 12.15.04
 * 
 */
package com.fleaPark.services.persistence.dao;

import java.io.Serializable;
import java.util.List;

public abstract class EntityDaoJDBC<T, ID extends Serializable> implements EntityDao<T, Serializable> {

    @Override
    public void delete(T entity) {

    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public List<T> getByExample(T exampleInstance, String[] excludeProperty) {
        return null;
    }

    @Override
    public T getById(Serializable id, boolean lock) {
        return null;
    }

    @Override
    public T insert(T entity) {
        return null;
    }

}
