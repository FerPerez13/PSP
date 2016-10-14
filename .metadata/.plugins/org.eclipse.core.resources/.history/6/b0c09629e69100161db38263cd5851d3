package tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio {
	public static void main(String[] args) throws Exception {
						
		try {
			String comando="ifconfig";
			
			Process proceso = Runtime.getRuntime().exec(comando);
			InputStream entrada = proceso.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
		
		String line;
		
		while ((line = br.readLine()) != null){
			System.out.println(line);
		}
			
		} catch (Exception e) {
			System.out.println("Error ocurrió ejecutando el	comando. Descripción: " + e.getMessage());
		}
	}
}
