package dataAccessObject;

import model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laura Nagy
 *
 * ProductDAO - extends the abtract DAO and specifies the model class used: Product
 */

public class ProductDAO extends DAO<Product>{

    protected String findAll() {
        return "SELECT * FROM `product`";
    }

    protected String findByID(int id){
        return "SELECT * FROM `product` WHERE productID = " + id;
    }

    protected String findByName(String name) {
        return "SELECT * FROM `product` WHERE productname = '" + name + "'";
    }
    protected String insert(Product product) {
        return "INSERT INTO `product` (productName, quantity, price) VALUES ('" + product.getProductName() + "', '" +
                product.getQuantity() + "', '" + product.getPrice() + "')";
    }

    protected String delete(String name) {
        return "DELETE FROM `product` WHERE productname = '" + name + "'";
    }

    protected String update(Product product) {
        return "UPDATE `product` SET productname = '" + product.getProductName() +
                "', quantity = " + product.getQuantity() +
             //   ", price = " + product.getPrice() +
                " WHERE productID = " + product.getID();
    }

    protected Product getFromResultSet(ResultSet resultSet) throws SQLException {
        resultSet.next(); //first element
        Product product = new Product();

        product.setID(resultSet.getInt("productID"));
        product.setProductName(resultSet.getString("productname"));
        product.setQuantity(resultSet.getInt("quantity"));
        product.setPrice(resultSet.getFloat("price"));

        return product;
    }
    protected List<Product> getListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Product> productList = new ArrayList<Product>();

        while (resultSet.next()) {
            Product product = new Product();

            product.setID(resultSet.getInt("productID"));
            product.setProductName(resultSet.getString("productname"));
            product.setQuantity(resultSet.getInt("quantity"));
            product.setPrice(resultSet.getFloat("price"));
            productList.add(product);
        }
        return productList;
    }
}
