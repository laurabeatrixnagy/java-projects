package model;

import java.time.Instant;
import java.util.Date;
/**
 * @author Laura - Beatrix Nagy
 *
 * Order - class representing an order
 */
public class Order {

    private int orderID;
    private Date date;
    private int table;

    public Order(int orderID, int table) {
        this.orderID = orderID;
        this.date = Date.from(Instant.now());
        this.table = table;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getTable() {
        return table;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int hashCode() {
        int hashCode = 3;
        return hashCode*5 + orderID*7 + table*11;
    }
}
