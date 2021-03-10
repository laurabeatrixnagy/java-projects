package controller;

import fileio.Serializer;
import model.Restaurant;
import view.BaseUI;
/**
 * @author Laura - Beatrix Nagy
 *
 * Controller - contains the main function
 */
import java.io.IOException;

public class Controller {

    public static void main(String[] args) throws IOException {

        Restaurant restaurant = new Restaurant();
        Serializer.deserialize();
        BaseUI view=new BaseUI(restaurant);
    }
}
