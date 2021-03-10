package model;

/**
 * @author Laura Nagy
 *
 * Product - represents the product table
 */
public class Product extends GenericEntity {

    private String productName;
    private int quantity;
    private float price;

    public Product() {
        this.productName = null;
        this.quantity = 0;
        this.price = 0;
    }

    public Product(int productID, String product, int quantity, float price) {
        this.id = productID;
        this.productName = product;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
