package business;

import dataAccessObject.DAO;
import model.GenericEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Laura Nagy
 *
 * Controller - abstract class
 * @param <T>
 */

public abstract class Controller<T extends GenericEntity> {

    private DAO<T> dao;

    public Controller() {
    }

    public Controller(DAO<T> dao) {
        this.dao = dao;
    }

    public List<T> getAllAsList() {
        List<T> list = dao.findAllEntries();
        return list;
    }

    public void insert(T t) {
        dao.insertEntry(t);
    }

    public void delete(String name) {
        dao.deleteEntry(name);
    }

    public void update(T t) {
        dao.updateEntry(t);
    }

    public T getEntityByID(int id) throws SQLException {
        return dao.findEntryByID(id);
    }

    public int getIDByName(String name) throws SQLException {
        return dao.findEntryByName(name);
    }
}
