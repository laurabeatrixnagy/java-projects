package control;

import fileio.MyFileReader;
import fileio.MyFileWriter;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

    /*    MyFileReader fr = new MyFileReader();
        fr.setData(args[0]);
        MyFileWriter fw = new MyFileWriter(args[1]);

        Simulator simulator = new Simulator(fw);
*/

        Adder adder = (x, y, z) -> x + y + z;
        Shape2D shape = new Circle();
        System.out.println(shape.whoAreYou());
    }
}
