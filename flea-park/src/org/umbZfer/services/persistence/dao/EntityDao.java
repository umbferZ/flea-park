/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: org.umbZfer.services.persistence.dao
 * Type: EntityDao
 * Last update: 13-feb-2017 7.07.17
 * 
 */
package org.umbZfer.services.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 * The Interface EntityDao.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public interface EntityDao<T, ID extends Serializable> extends ChangeDB {

    /**
     * Delete.
     *
     * @param entity the entity
     */
    public void delete(T entity);

    /**
     * Gets the all.
     *
     * @return the all
     */
    public List<T> getAll();

    /**
     * Gets the by example.
     *
     * @param exampleInstance the example instance
     * @param excludeProperty the exclude property
     * @return the by example
     */
    public List<T> getByExample(T exampleInstance, String[] excludeProperty);

    /**
     * Gets the by id.
     *
     * @param id the id
     * @param lock the lock
     * @return the by id
     */
    public T getById(ID id, boolean lock);

    /**
     * Insert.
     *
     * @param entity the entity
     * @return the t
     */
    public T insert(T entity);
}