package fileio;

import model.MenuItem;
import model.Order;
import model.Restaurant;
/**
 * @author Laura - Beatrix Nagy
 *
 *BillGenerator - generates bill and calculates total price for orders
 */
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BillGenerator {

    public static void generateBill(Restaurant restaurant, Order order) throws IOException {
        java.io.FileWriter fw = new java.io.FileWriter(new File("bill_" + order.hashCode() + ".txt"));
        Date date = new Date();
        fw.append("Receipt\n");
        fw.append("-----------------\n");

        for (MenuItem item : restaurant.getOrderInfoMap().get(order)) {
            fw.append(item.getName());
            fw.append(String.valueOf(item.getPrice()) + "\n");
        }

        fw.append("Total price: ");
        fw.append(new StringBuilder(String.valueOf(restaurant.orderPrice(order))).toString() + "\n");
        fw.append(new SimpleDateFormat("yyyy-mm-dd").format(date));
        fw.close();
    }
}
