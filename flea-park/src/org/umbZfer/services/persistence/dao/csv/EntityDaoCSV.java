/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: org.umbZfer.services.persistence.dao.csv
 * Type: EntityDaoCSV
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package org.umbZfer.services.persistence.dao.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.umbZfer.debug.Message4Debug;
import org.umbZfer.services.persistence.dao.EntityDao;

import com.opencsv.CSVReader;

public abstract class EntityDaoCSV<T, ID extends Serializable> implements EntityDao<T, ID> {
    private List<String[]> rows;

    public EntityDaoCSV(String fileName) {
        rows = new ArrayList<>();
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(fileName), ',');
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null)
                rows.add(nextLine);
        } catch (FileNotFoundException e) {
            Message4Debug.log(e.getMessage());
            e.printStackTrace();

        } catch (IOException e) {
            Message4Debug.log(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                Message4Debug.log(e.getMessage());
                e.printStackTrace();
            }
        }

    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public abstract List<T> getAll();

    @Override
    public List<T> getByExample(T exampleInstance, String[] excludeProperty) {
        return null;
    }

    @Override
    public T getById(ID id, boolean lock) {
        return null;
    }

    public List<String[]> getRows() {
        return rows;
    }

    @Override
    public void importDump() {

    }

    @Override
    public T insert(T entity) {
        return null;
    }

    public void setRows(List<String[]> rows) {
        this.rows = rows;
    }

}
