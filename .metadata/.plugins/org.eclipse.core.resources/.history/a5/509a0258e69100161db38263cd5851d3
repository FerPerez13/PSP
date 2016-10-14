package tema1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio4 {
	public static void main(String[] args) throws Exception {	
	try{
		
		Process proceso = Runtime.getRuntime().exec(args);
		InputStream entrada = proceso.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
		
		String line;
		
		while ((line = br.readLine())!=null){
			System.out.println(line);
			proceso.destroy();
		}
		System.out.println("La aplicación se ha cerrado con éxito");
		
		} catch (Exception e){
			System.out.println("Error ocurrió ejecutando el	comando. Descripción: " + e.getMessage());
		}
	}
}
