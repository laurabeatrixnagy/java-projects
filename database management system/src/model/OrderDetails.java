package model;
/**
 * @author Laura Nagy
 *
 * OrderDetails - represents the orderdetails table
 */
public class OrderDetails extends GenericEntity {

    private int detailsID;
    private int orderID;
    private String status;

    public OrderDetails() {

    }

    public OrderDetails(int dID, int oID, String status) {
        this.detailsID = dID;
        this.orderID = oID;
        this.status = status;
    }

    public int getDetailsID() {
        return detailsID;
    }

    public void setDetailsID(int detailsID) {
        this.detailsID = detailsID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
