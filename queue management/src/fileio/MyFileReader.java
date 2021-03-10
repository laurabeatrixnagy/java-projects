package fileio;

import model.InputData;

import java.io.*;

public class MyFileReader{

    public MyFileReader() {
    }

    public void setData(String path) throws IOException {
        FileReader file = new FileReader(path);
        BufferedReader br = new BufferedReader(file);

        String line;

        int[] intValues = new int[7];;
        int index = 0;
        while ((line = br.readLine()) != null) {

            String[] values = line.split(",");
            for (int i = 0; i < values.length; i++) {
                try {
                    intValues[index++] = Integer.parseInt(values[i]);
                } catch (NumberFormatException nfe) {
                    continue;
                }
            }
        }
        InputData.setClientNo(intValues[0]);
        InputData.setQueueNo(intValues[1]);
        InputData.setSimulationInterval(intValues[2]);
        InputData.setMinArrTime(intValues[3]);
        InputData.setMaxArrTime(intValues[4]);
        InputData.setMinServiceTime(intValues[5]);
        InputData.setMaxServiceTime(intValues[6]);
    }

}
