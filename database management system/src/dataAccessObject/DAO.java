package dataAccessObject;

import dataAccessLayer.ConnectionFactory;
import model.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


/**
 * @author Laura Nagy
 *
 * DAO -  generic class that defines the common operations for accessing a table
 */
public abstract class DAO<T extends GenericEntity>{

    private static final Logger LOGGER = Logger.getLogger(DAO.class.getName());
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    protected abstract String findAll();
    protected abstract String findByID(int id);
    protected abstract String findByName(String name);
    protected abstract String insert(T t);
    protected abstract String delete(String name);
    protected abstract String update(T entity);
    protected abstract List<T> getListFromResultSet(ResultSet resultSet) throws SQLException;
    protected abstract T getFromResultSet(ResultSet resultSet) throws SQLException;

    private void createConnection() {
        connection = ConnectionFactory.getConnection();

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occurred while trying to get a statement");
            e.printStackTrace();
        }
    }

    private void getResultSet(String sql) {
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occurred while trying to execute an SQL statement");
            e.printStackTrace();
        }
    }

    public final List<T> findAllEntries() {
        createConnection();
        String sql = findAll();
        getResultSet(sql);

        List<T> resultList = null;
        try {
            resultList = getListFromResultSet(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occurred while trying to execute Select all");
            e.printStackTrace();
        }

        close();

        return resultList;
    }

    public T findEntryByID(int id) throws SQLException {
        createConnection();
        String sql = findByID(id);
        getResultSet(sql);

        T result = getFromResultSet(resultSet);
        close();

        return result;
    }

    public int findEntryByName(String name) throws SQLException {
        createConnection();
        String sql = findByName(name);
        getResultSet(sql);

        T result = getFromResultSet(resultSet);
        close();

        return result.getID();
    }

    public void insertEntry(T t) {
        createConnection();
        String sql = insert(t);

        try {
            statement.execute(sql);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occurred while trying to execute Insert");
            e.printStackTrace();
        }

        close();
    }

    public void deleteEntry(String name) {
        createConnection();
        String sql = delete(name);

        try {
            statement.execute(sql);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occurred while trying to execute Delete");
            e.printStackTrace();
        }

        close();
    }

    public void updateEntry(T t) {
        createConnection();
        String sql = update(t);

        try {
            statement.execute(sql);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occurred while trying to execute Update");
            e.printStackTrace();
        }

        close();
    }

    private void close() {
        ConnectionFactory.close(resultSet);
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
    }
}
