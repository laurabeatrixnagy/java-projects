package presentation;

import business.Controller;
import model.GenericEntity;

/**
 * @author Laura Nagy
 *
 * Output - generic class for executing operations on a table
 * @param <T>
 */
public class Output<T extends GenericEntity> {

    Controller<T> controller;

    public Output(Controller<T> controller) {
        this.controller = controller;
    }

    public void addEntity(T t) {
        controller.insert(t);
    }

    public void updateEntity(T t) {
        controller.update(t);
    }
    public void deleteEntity(String name) {
        controller.delete(name);
    }
}
