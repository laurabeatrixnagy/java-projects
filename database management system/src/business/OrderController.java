package business;

import dataAccessObject.OrderDAO;

/**
 * @author Laura Nagy
 *
 * OrderController - class with a single constructor
 */

public class OrderController extends Controller {

    public OrderController() {
        super(new OrderDAO());
    }
}
