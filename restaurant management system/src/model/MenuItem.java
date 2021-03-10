package model;

import java.io.Serializable;
/**
 * @author Laura - Beatrix Nagy
 *
 * MenuItem - serializable class that represents a menu
 */
public class MenuItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private double price;

    public MenuItem(String name) {
        this.name = name;
    }

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean equals(Object obj) {
        MenuItem item = (MenuItem)obj;
        return this.name.contentEquals(item.name);
    }

    @Override
    public String toString(){
        return this.getName();
    }
}
