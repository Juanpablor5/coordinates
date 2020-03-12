package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "data/listapolicia.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        String format = "%-7s %-14s %s\n";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int i=1;
            System.out.println("\t coordenadaX \t coordenadaY");
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] coord = line.split(cvsSplitBy);
                
                System.out.printf(format, "e"+i,coord[2],coord[3]);
                
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
