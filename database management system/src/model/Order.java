package model;

/**
 * @author Laura Nagy
 *
 * Order - represents the order table
 */
public class Order extends GenericEntity {

    private int clientID;
    private int productID;
    private int quantity;

    public Order() {

    }
    public Order(int cID, int pID, int quantity) {
        this.clientID = cID;
        this.productID = pID;
        this.quantity = quantity;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
