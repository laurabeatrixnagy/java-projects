package business;

import dataAccessObject.ProductDAO;

/**
 * @author Laura Nagy
 *
 * ProductController - class with a single constructor
 */

public class ProductController extends Controller {

    public ProductController() {
        super(new ProductDAO());
    }
}
