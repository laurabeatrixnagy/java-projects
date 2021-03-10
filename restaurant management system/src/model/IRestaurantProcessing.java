package model;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Laura Nagy
 *
 * IRestaurantProcessing - interface containing the main operations that can be
 * executed by the waiter/administrator
 */
public interface IRestaurantProcessing {

    void addMenuItem(MenuItem item) throws IOException;

    void deleteMenuItem(MenuItem item) throws IOException;

    void editMenuItem(MenuItem item, double price) throws IOException;

    void createOrder(Order order, ArrayList<MenuItem> items) throws IOException;

    double orderPrice(Order order);

    void generateBill(Restaurant res, Order order);
}
