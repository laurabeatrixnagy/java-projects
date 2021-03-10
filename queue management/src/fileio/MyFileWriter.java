package fileio;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFileWriter {

    PrintWriter pw;

    public MyFileWriter(String path) throws IOException {
        pw = new PrintWriter(path, "UTF-8");

    }

    public synchronized void write(String str) {
        System.out.println(str);
        pw.write(str + "\n");
    }

    public void close(){
        pw.close();
    }
}
