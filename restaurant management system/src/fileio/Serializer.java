package fileio;

import model.Restaurant;

import java.io.*;

/**
 * @author Laura - Beatrix Nagy
 *
 * Serializer - Restaurant objects will be loaded/saved from/to a file
 * using Serialization
 */
public class Serializer {

    public static void serialize(Restaurant restaurant) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("restaurant.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(restaurant);
        out.close();
        fileOut.close();
    }

    public static Restaurant deserialize() throws IOException {

        Restaurant restaurant = null;
        try {
            FileInputStream fileIn = new FileInputStream("restaurant.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            restaurant = (Restaurant) in.readObject();
            in.close();
            fileIn.close();
            return restaurant;
        } catch (IOException | ClassNotFoundException i) {
            restaurant = new Restaurant();
            serialize(restaurant);
            return restaurant;
        }
    }

}
