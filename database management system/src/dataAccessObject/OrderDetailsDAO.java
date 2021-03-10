package dataAccessObject;

import model.OrderDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Laura Nagy
 *
 * OrderDetailsDAO - extends the abtract DAO and specifies the model class used: OrderDetails
 */
public class OrderDetailsDAO extends DAO<OrderDetails>{

    protected String findAll() {
        return "SELECT * FROM `orderdetails`";
    }

    protected String findByID(int id){
        return "SELECT * FROM `orderdetails` WHERE detailsID = " + id;
    }

    protected String findByName(String name) {
        return "SELECT * FROM `orderdetails`";
    }
    protected String insert(OrderDetails detail) {
        return "INSERT INTO `orderdetails` (orderID, status) VALUES ('" + detail.getOrderID() + "', '" +
                detail.getStatus() + "')";
    }

    protected String delete(String name) {
        return null;
    }

    protected String update(OrderDetails detail) {
        return null;
    }

    protected OrderDetails getFromResultSet(ResultSet resultSet) throws SQLException {
        resultSet.next(); //first element
        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setDetailsID(resultSet.getInt("detailsID"));
        orderDetails.setOrderID(resultSet.getInt("orderID"));
        orderDetails.setStatus(resultSet.getString("status"));

        return orderDetails;
    }
    protected List<OrderDetails> getListFromResultSet(ResultSet resultSet) throws SQLException {
        List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();

        while (resultSet.next()) {
            OrderDetails orderDetails = new OrderDetails();

            orderDetails.setDetailsID(resultSet.getInt("detailsID"));
            orderDetails.setOrderID(resultSet.getInt("orderID"));
            orderDetails.setStatus(resultSet.getString("status"));
            orderDetailsList.add(orderDetails);
        }
        return orderDetailsList;
    }
}
