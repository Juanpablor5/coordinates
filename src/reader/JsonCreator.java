package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonCreator {

	public static void main(String[] args) {
		String rutaEti = "data/etiquetas.csv";
		String[] eti = new String[82];
		
		String csvFile = "data/cat.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		try {
			int c=0;					
			br = new BufferedReader(new FileReader(rutaEti));
			while ((line = br.readLine()) != null) {
				String[] separado = line.split(cvsSplitBy);
				eti[c] = separado[1];				
				c++;
			}
			br.close();
			
			c=0;
			br = new BufferedReader(new FileReader(csvFile));
			String cadena = "";
			cadena += "{\"categorías\": [";
			while ((line = br.readLine()) != null) {				
				String[] separado = line.split(cvsSplitBy);
				String[] etiquetas =  separado[1].split(",");
				cadena += "{\"id\":"+ separado[0] +",";
				cadena += "\"categoría\":\""+ separado[2] +"\",";
				cadena += "\"etiquetas\":[";
				for (int i = 0; i < etiquetas.length; i++) {					
					cadena += "{";					
					cadena += "\"id\":"+Integer.parseInt(etiquetas[i])+",";					
					cadena += "\"nombre\":\""+ eti[Integer.parseInt(etiquetas[i])-1] +"\"";					
					cadena += "}";					
					if (i != etiquetas.length-1)
						cadena += ",";
				}
				cadena += "]}";				
				if (c != 270)
					cadena += ",";
				c++;
			}
			cadena += "]}";
			System.out.println(cadena);

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
