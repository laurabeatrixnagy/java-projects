package presentation;

import business.ClientController;
import business.OrderController;
import business.ProductController;
import model.Client;
import model.Order;
import model.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Laura Nagy
 *
 * Command - class for parsing the commands from the input file and executing them
 */
public class Command {

    private int nrCommands = 0;
    private String[][] commands = new String[100][];
    private ReportGenerator generator = new ReportGenerator();

    public int getNrCommands() {
        return nrCommands;
    }

    public void setNrCommands(int nrCommands) {
        this.nrCommands = nrCommands;
    }

    public String[][] getCommands() {
        return this.commands;
    }

    public String[] getCommandAtIndex(int i) {
        return this.commands[i];
    }

    public String getCommandPart(int i, int j) {
        return this.commands[i][j];
    }

    public void parse(String[] args) throws IOException, SQLException {

        FileReader file = new FileReader(args[0]);
        @SuppressWarnings("resource")
        BufferedReader br = new BufferedReader(file);
        String line = null;

        int index = 0;
        while ((line = br.readLine()) != null) {

            nrCommands++;
            String[] values = line.split("(,|:)");
            commands[index] = new String[values.length];

            for (int i = 0; i < values.length; i++) {
                   commands[index][i] = values[i];
            }

            if (commands[index][0].contains("client")) {
                clientCommand(commands[index]);
            }

            if (commands[index][0].contains("product")) {
                productCommand(commands[index]);
            }

            if (commands[index][0].contains("rder")) {
                orderCommand(commands[index]);
            }
            index++;
        }
    }

    public void clientCommand(String[] command) {
       Output clientOut = new Output(new ClientController());

        if (command[0].equals("Insert client")) {
            Client client = new Client(command[1].substring(1), command[1].substring(1) + "@email.com", command[2].substring(1));
            clientOut.addEntity(client);
        }

        if (command[0].equals("Delete client")) {
            clientOut.deleteEntity(command[1].substring(1));
        }

        if (command[0].equals("Report client")) {
            generator.generateClientReport();
        }
    }

    public void productCommand(String[] command) throws SQLException {
        ProductController productController = new ProductController();
        Output productOut = new Output(productController);

        if (command[0].equals("Insert product")) {
            Product product = new Product(0, command[1].substring(1), Integer.parseInt(command[2].substring(1)), Float.parseFloat(command[3].substring(1)));
            productOut.addEntity(product);
        }

        if (command[0].equals("Delete product")) {
            productOut.deleteEntity(command[1].substring(1));
        }

        if (command[0].equals("Report product")) {
            generator.generateProductReport();
        }
    }

    public void orderCommand(String[] command) throws SQLException {
        OrderController controller = new OrderController();
        Output orderOut = new Output(controller);

        ClientController clientController = new ClientController();
        ProductController productController = new ProductController();
        Output productOut = new Output(productController);

        if (command[0].equals("Order")) {
            int clientID = clientController.getIDByName(command[1].substring(1));
            int productID = productController.getIDByName(command[2].substring(1));

            Order newOrder = new Order(clientID, productID, Integer.parseInt(command[3].substring(1)));
            Product auxProduct = (Product) productController.getEntityByID(productID);
            Client auxClient = clientController.getEntityByID(clientID);

            int newQuantity = auxProduct.getQuantity() - Integer.parseInt(command[3].substring(1));

            orderOut.addEntity(newOrder);
            if (newQuantity >0) {
                Product newProd = new Product(auxProduct.getID(), auxProduct.getProductName(), newQuantity, auxProduct.getPrice());
                productOut.updateEntity(newProd);

                //generate bill
                generator.generateBill(auxClient.getName(), auxProduct.getPrice() * Integer.parseInt(command[3].substring(1)));
            }
            else {
                //out of stock
                generator.generateUnderStock(auxClient.getName());
            }
        }

        if (command[0].equals("Report order")) {
            generator.generateOrderReport();
        }
    }

}
