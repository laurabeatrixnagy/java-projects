package view;
import model.BaseProduct;
import model.MenuItem;
import model.Order;
import model.Restaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Laura - Beatrix Nagy
 *
 * BaseUI - class for implementing the graphical user interface
 */
public class BaseUI extends javax.swing.JFrame{

    Restaurant restaurant;
    ArrayList<MenuItem> orderedItems = new ArrayList<>();

    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel pane1 = new JPanel();
    JPanel pane2 = new JPanel();
    JPanel pane3 = new JPanel();

    JPanel admin = new JPanel();
    JPanel admin2 = new JPanel();

    JPanel waiter = new JPanel();
    JPanel waiter2 = new JPanel();

    DefaultTableModel model1;
    DefaultTableModel model2;
    JTable table1 = new JTable();
    JTable table2 = new JTable();

    String[] header1 = {"Name","Price"};
    String[] header2 = {"OrderID","Date", "Table", "Ordered items"};
    String[][] tabledata;

    JButton addItem = new JButton("Create item");
    JButton removeItem = new JButton("Remove item");
    JButton editItem = new JButton("Edit item");
    JButton showItems = new JButton("Show all items");

    JButton createOrder = new JButton("Create order");
    JButton generateBill= new JButton("Generate bill");
    JButton showOrders = new JButton("Show all orders");
    JButton showMenu = new JButton("Show menu");
    JButton addItemtoOrder = new JButton("Add");

    JLabel name = new JLabel("Name");
    JLabel price = new JLabel("Price");

    JLabel orderID = new JLabel("OrderID");
    JLabel table = new JLabel("Table");
    JLabel menuLabel = new JLabel("Menu");

    JTextField namefield = new JTextField(20);
    JTextField pricefield =new JTextField(20);
    JTextField orderIDField =new JTextField(20);
    JTextField tablefield = new JTextField(20);

    JComboBox<MenuItem> menu;



    JFrame frame;

    public BaseUI(Restaurant restaurant)
    {
        this.restaurant = restaurant;
        frame = new JFrame ("Restaurant Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 500);
        updateItems();
        updateOrders();
        admin.setLayout(new BoxLayout(admin, BoxLayout.PAGE_AXIS));
        admin.setBounds(0,0,600,600);
        admin.add(addItem);
        admin.add(removeItem);
        admin.add(editItem);
        admin.add(showItems);

        admin2.setLayout(new BoxLayout(admin2, BoxLayout.PAGE_AXIS));
        admin2.add(name);
        admin2.add(namefield);
        admin2.add(price);
        admin2.add(pricefield);

        pane1.setLayout(new FlowLayout(FlowLayout.LEADING));
        pane1.add(admin);
        pane1.add(admin2);
        table1.setBounds(0,50,200,700);
        pane1.add(new JScrollPane(table1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

        waiter.setLayout(new BoxLayout(waiter, BoxLayout.PAGE_AXIS));
        waiter2.setLayout(new BoxLayout(waiter2, BoxLayout.PAGE_AXIS));
        waiter.add(createOrder);
        waiter.add(generateBill);
        waiter.add(showOrders);
        waiter2.add(orderID);
        waiter2.add(orderIDField);
        waiter2.add(table);
        waiter2.add(tablefield);
        waiter2.add(menuLabel);
        waiter2.add(showMenu);
        menu = new JComboBox<MenuItem>();
        menu.setBounds(50, 250, 150, 50);
        waiter2.add(menu);
        waiter2.add(table2);
        waiter2.add(addItemtoOrder);

        pane2.add(waiter);
        pane2.add(waiter2);
        pane2.setLayout(new FlowLayout(FlowLayout.LEADING));
        table2.setBounds(0, 50, 600, 600);
        pane2.add(new JScrollPane(table2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

        tabbedPane.add(pane1);
        tabbedPane.add(pane2);
        tabbedPane.add(pane3);
        tabbedPane.setTitleAt(0, "Administrator");
        tabbedPane.setTitleAt(1, "Waiter");
        tabbedPane.setTitleAt(2, "Chef");
        frame.setContentPane(tabbedPane);
        frame.setVisible(true);

        addItem.addActionListener(evt -> {
            try {
                addItemActionPerformed(evt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        removeItem.addActionListener(evt -> {
            try {
                removeItemActionPerformed(evt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        editItem.addActionListener(evt -> {
            try {
                editItemActionPerformed(evt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        showItems.addActionListener(this::showItemsActionPerformed);

        createOrder.addActionListener(evt -> {
            try {
                createOrderActionPerformed(evt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        generateBill.addActionListener(this::generateBillActionPerformed);

        showOrders.addActionListener(this::showOrdersActionPerformed);

        addItemtoOrder.addActionListener(this::addItemToOrderActionPerformed);

        showMenu.addActionListener(this::setComboBox);


    }

    public void updateItems()
    {
        tabledata=new String[restaurant.menu.size()][2];
        model1=new DefaultTableModel(tabledata,header1);
        table1.setModel(model1);
    }

    public void updateOrders()
    {
        tabledata = new String[restaurant.orders.size()][4];
        model2=new DefaultTableModel(tabledata, header2);
        table2.setModel(model2);
    }


    private void addItemActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        String itemName = namefield.getText();
        String itemPrice = pricefield.getText();
        double price = Double.parseDouble(itemPrice);

        BaseProduct item = new BaseProduct(itemName, price);
        restaurant.addMenuItem(item);
    }

    private void removeItemActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if(table1.getSelectedRow() != -1) {
            // remove selected row from the model
            restaurant.deleteMenuItem(restaurant.findItemByName((String)table1.getValueAt(table1.getSelectedRow(),0)));

            model1.removeRow(table1.getSelectedRow());
        }
    }

    private void editItemActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        {
            restaurant.editMenuItem(restaurant.findItemByName(namefield.getText()), Double.parseDouble(pricefield.getText()));
        }
    }

    private void showItemsActionPerformed(java.awt.event.ActionEvent evt) {
        tabledata=new String[restaurant.menu.size()][2];
        for(int i=0; i<restaurant.menu.size(); i++)
        {
            tabledata[i][0]=restaurant.menu.get(i).getName();
            tabledata[i][1]=Double.toString(restaurant.menu.get(i).getPrice());
        }
        model1=new DefaultTableModel(tabledata,header1);
        table1.setModel(model1);
    }

    private void createOrderActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        int ordID = Integer.parseInt(orderIDField.getText());
        int tableID = Integer.parseInt(tablefield.getText());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Order newOrder = new Order(ordID, tableID);
        System.out.println(formatter.format(newOrder.getDate()));
        restaurant.createOrder(newOrder, orderedItems);


    }

    private void generateBillActionPerformed(java.awt.event.ActionEvent evt) {

        restaurant.generateBill(restaurant, restaurant.findOrderByID(Integer.parseInt(orderIDField.getText())));
    }

    private void showOrdersActionPerformed(java.awt.event.ActionEvent evt) {

        tabledata = new String[restaurant.orders.size()][4];
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for(int i = 0; i < restaurant.orders.size(); i++)
        {

            ArrayList<MenuItem> items = restaurant.getOrderInfoMap().get(restaurant.orders.get(i));
            tabledata[i][0] = Double.toString(restaurant.orders.get(i).getOrderID());
            tabledata[i][1] = formatter.format(restaurant.orders.get(i).getDate());
            tabledata[i][2] = Integer.toString(restaurant.orders.get(i).getTable());

            String itemString = new String("");
            for (MenuItem item : restaurant.getOrderInfoMap().get(restaurant.orders.get(i))) {
                itemString += item.getName() + ", ";
            }
            tabledata[i][3] = itemString;
        }

        model2=new DefaultTableModel(tabledata, header2);
        table2.setModel(model2);
    }

    private void addItemToOrderActionPerformed(java.awt.event.ActionEvent evt) {

         MenuItem item = (MenuItem) menu.getSelectedItem();
         orderedItems.add(item);
    }

    public void setComboBox(java.awt.event.ActionEvent evt) {
        menu.removeAllItems();
        ArrayList<MenuItem> list = restaurant.getMenu();

        for (MenuItem it : list) {
            menu.addItem(it);
        }
    }

}
