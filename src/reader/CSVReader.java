package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "data/cat.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        ArrayList<String> lista = new ArrayList<String>();
        ArrayList<String> catOrg = new ArrayList<String>();
        ArrayList<String> cat = new ArrayList<String>();
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int c=0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] separado = line.split(cvsSplitBy);
                lista.add(separado[1]);
                
                cat.add(separado[2]);
                
                String[] catSep = lista.get(c).split(",");
                
                Integer[] categorias = new Integer[catSep.length];
                for (int i = 0; i < catSep.length; i++) {
                	categorias[i]=Integer.parseInt(catSep[i]);
				}
                
                TreeSet<Integer> tree = new TreeSet<Integer>();                
                for(int i = 0; i< categorias.length; i++) {
                    tree.add(categorias[i]);
                }                
                categorias = new Integer[tree.size()];                
                tree.toArray(categorias);
                String cadena = "";
                for (int i = 0; i < categorias.length; i++) {           	
                	cadena += categorias[i];
                	if (i!=categorias.length-1) cadena += ",";
				}
                catOrg.add(cadena);
                c++;
            }
            for (int i = 0; i < catOrg.size(); i++) {
				System.out.println((i+1)+";"+catOrg.get(i)+";"+cat.get(i));
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
