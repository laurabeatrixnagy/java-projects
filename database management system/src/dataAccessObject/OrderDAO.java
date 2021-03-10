package dataAccessObject;

import model.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laura Nagy
 *
 * OrderDAO - extends the abtract DAO and specifies the model class used: Order
 */
public class OrderDAO extends DAO<Order>{

    protected String findAll() {
        return "SELECT * FROM `order`";
    }

    protected String findByID(int id){
        return "SELECT * FROM `order` WHERE orderID = " + id;
    }

    protected String findByName(String name) {
        return "SELECT * FROM `order`";
    }

    protected String insert(Order order) {
        return "INSERT INTO `order` (clientID, productID, quantity) VALUES (" + order.getClientID() + ", " +
                order.getProductID() + ", " + order.getQuantity() + ")";
    }

    protected String delete(String name) {
        return null;
    }

    protected String update(Order order) {
        return null;
    }

    protected Order getFromResultSet(ResultSet resultSet) throws SQLException {
        resultSet.next(); //first element
        Order order = new Order();

        order.setID(resultSet.getInt("orderID"));
        order.setClientID(resultSet.getInt("clientID"));
        order.setProductID(resultSet.getInt("productID"));
        order.setQuantity(resultSet.getInt("quantity"));

        return order;
    }
    protected List<Order> getListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Order> orderList = new ArrayList<Order>();

        while (resultSet.next()) {
            Order order = new Order();

            order.setID(resultSet.getInt("orderID"));
            order.setClientID(resultSet.getInt("clientID"));
            order.setProductID(resultSet.getInt("productID"));
            order.setQuantity(resultSet.getInt("quantity"));
            orderList.add(order);
        }
        return orderList;
    }
}
