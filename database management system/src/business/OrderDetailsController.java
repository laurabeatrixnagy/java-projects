package business;

import dataAccessObject.OrderDetailsDAO;

/**
 * @author Laura Nagy
 *
 * OrderDetailsController - class with a single constructor
 */

public class OrderDetailsController extends Controller {

    public OrderDetailsController() {
        super(new OrderDetailsDAO());
    }
}
