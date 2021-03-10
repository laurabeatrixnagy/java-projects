package business;

import dataAccessObject.ClientDAO;
import model.Client;

/**
 * @author Laura Nagy
 *
 * CleintController - class with a single constructor
 */

public class ClientController extends Controller<Client> {

    public ClientController() {
        super(new ClientDAO());
    }
}
