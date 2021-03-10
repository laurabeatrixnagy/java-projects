package dataAccessObject;

import model.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laura Nagy
 *
 * ClientDAO -  extends the abstract DAO and specifies the model class used: Client
 */

public class ClientDAO extends DAO<Client>{

    protected String findAll() {
        return "SELECT * FROM `client`";
    }

    protected String findByID(int id){
        return "SELECT * FROM `client` WHERE clientID = " + id;
    }

    protected String findByName(String name) {
        return "SELECT * from `client` WHERE name = '" + name + "'";
    }

    protected String insert(Client client) {
        return "INSERT INTO `client` (name, email, address) VALUES ('" + client.getName() + "', '" +
                client.getEmail() + "', '" + client.getAddress() + "')";
    }

    protected String delete(String name) {
        return "DELETE FROM `client` WHERE name = '" + name + "'";
    }

    protected String update(Client client) {
        return "UPDATE `client` SET name = " + client.getName() +
                ", email = " + client.getEmail() +
                ", address = " + client.getAddress() +
                " WHERE clientID = " + client.getID();
    }
    protected Client getFromResultSet(ResultSet resultSet) throws SQLException{
        resultSet.next(); //first element
        Client client = new Client();

        client.setID(resultSet.getInt("clientID"));
        client.setName(resultSet.getString("name"));
        client.setEmail(resultSet.getString("email"));
        client.setAddress(resultSet.getString("address"));

        return client;
    }
    protected List<Client> getListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Client> clientList = new ArrayList<Client>();

        while (resultSet.next()) {
            Client client = new Client();
            client.setID(resultSet.getInt("clientID"));
            client.setName(resultSet.getString("name"));
            client.setEmail(resultSet.getString("email"));
            client.setAddress(resultSet.getString("address"));
            clientList.add(client);
        }
        return clientList;
    }
}
