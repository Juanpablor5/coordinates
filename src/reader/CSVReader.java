package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "data/cat.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        ArrayList<String> lista = new ArrayList<String>();
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int c=0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] separado = line.split(cvsSplitBy);
                lista.add(separado[1]);
                
                String[] catSep = lista.get(c).split(",");
                for (int i = 0; i < catSep.length; i++) {                	
					System.out.println(catSep[i]);
				}
                c++;
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
