package model;

import java.util.ArrayList;
/**
 * @author Laura - Beatrix Nagy
 *
 * CompositeProduct - class represening a composite product
 */
public class CompositeProduct extends MenuItem{

    private ArrayList<MenuItem> ingredients;

    public CompositeProduct(String name) {
        super(name);
        this.ingredients = new ArrayList<MenuItem>();
    }

    @Override
    public double getPrice() {
        double price = 0.0;

        for (MenuItem item : this.ingredients) {
            price += item.getPrice();
        }

        return price;
    }
}
