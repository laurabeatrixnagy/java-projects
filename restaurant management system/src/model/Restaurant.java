package model;

import fileio.BillGenerator;
import fileio.Serializer;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Laura - Beatrix Nagy
 *
 * Restaurant - serializable class that represents the restaurant
 */
public class Restaurant implements Serializable, IRestaurantProcessing {

    private static final long serialVersionUID = 1L;

    public ArrayList<MenuItem> menu;
    public ArrayList<Order> orders;

    private Map<Order, ArrayList<MenuItem>> orderInfoMap;

    public Restaurant() {
        menu = new ArrayList<MenuItem>();
        orderInfoMap = new HashMap<Order, ArrayList<MenuItem>>();
        orders = new ArrayList<Order>();
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<MenuItem> menu) {
        this.menu = menu;
    }

    public Map<Order, ArrayList<MenuItem>> getOrderInfoMap() {
        return orderInfoMap;
    }

    public void addMenuItem(MenuItem item) throws IOException {

        assert item != null;
        this.menu.add(item);
        Serializer.serialize(this);
    }

    public void deleteMenuItem(MenuItem item) throws IOException {

        assert item != null;
        this.menu.remove(item);
        Serializer.serialize(this);
    }

    public void editMenuItem(MenuItem item, double price) throws IOException {

        assert item != null;
        assert price > 0.0;

        ArrayList<MenuItem> items = this.menu;
        for (int i = 0; i < menu.size(); i++) {
            if (item.equals(menu.get(i)))
                menu.get(i).setPrice(price);
        }
        Serializer.serialize(this);
    }

    public void createOrder(Order order, ArrayList<MenuItem> items) throws IOException {
        assert order != null;
        assert items != null;

        orderInfoMap.put(order, items);
        orders.add(order);

    }

    public double orderPrice(Order order) {

        assert order != null && this.orders.contains(order) == true;

        double price = 0.0;
        ArrayList<MenuItem> items = orderInfoMap.get(order);

        for (MenuItem item : items) {
            price += item.getPrice();
        }

        return price;
    }

    public MenuItem findItemByName(String name)
    {
        ArrayList<MenuItem> items = this.menu;

        for (MenuItem item : items) {
            if (item.getName().compareTo(name) == 0)
                return item;
        }
        return null;
    }

    public Order findOrderByID(int id) {

        for (Order ord : orders) {
            if (ord.getOrderID() == id)
                return ord;
        }
        return null;
    }

    public void generateBill(Restaurant restaurant, Order order) {

        assert restaurant.orderInfoMap.get(order) != null;

        try {
            BillGenerator.generateBill(this, order);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
