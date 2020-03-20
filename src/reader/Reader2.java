package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader2 {
    public static void main(String[] args) {

        String csvFile = "data/Policia2.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int i=0;
            ArrayList<String> distrito = new ArrayList<String>();
            ArrayList<String> estacion = new ArrayList<String>();
            ArrayList<String> direccion = new ArrayList<String>();
            
            while ((line = br.readLine()) != null) {
            	
                if(line.contains("DISTRITO")) {
                	line = br.readLine();
                	distrito.add(line);
//                	System.out.println(line);
                }else {
                	distrito.add(null);
                }
                
                if(line.contains("ESTACIÓN")) {
                	line = br.readLine();
                	estacion.add(line);
//                	System.out.println(line);
                }else {
                	estacion.add(null);
                }
                
                if(line.contains("DIRECCIÓN")) {
                	line = br.readLine();
                	direccion.add(line);
//                	System.out.println(line);
                }else {
                	direccion.add(null);
                }
                
                i++;
                                               
            }
            
            for (int l = 0; l < i; l++) {
            	System.out.println(distrito.get(l) + "|" + estacion.get(l) + "|" + direccion.get(l)); 
			}
//            System.out.println("============");
//            for (int l = 0; l < j; l++) {
//            	System.out.println(estacion.get(l)); 
//			}
//            System.out.println("============");
//            for (int l = 0; l < k; l++) {
//            	System.out.println(direccion.get(l)); 
//			}

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
