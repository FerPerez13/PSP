package PruebaFernandoPerezAndres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.PublicKey;

/************************************************************/	
/*			Ejercicio	Ejercicio1 							*/	
/*			Autor:	Fernando	Perez Andres 		 		*/	
/*			Fecha:	25 Noviembre 2016 					    */	
/************************************************************/	

public class Ejercicio1 {
	
	public static H1 hijo1 = new H1();
	public static H2 hijo2 = new H2();
		
	public static void main(String[] args){			
		hijo1.start();
		hijo2.start();
	}
	
}

class H1 extends Thread{
	private String comando1 = "gedit";
	public void run(){
		try {
			Process hijo1 = Runtime.getRuntime().exec(comando1);
			InputStream isHijo1 = hijo1.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(isHijo1));
			
			String line;

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class H2 extends Thread{
	private String comando2 = "firefox";
	public void run(){
		try {
			Process hijo2 = Runtime.getRuntime().exec(comando2);
			OutputStream osHijo2 = hijo2.getOutputStream();
			PrintStream ps = new PrintStream(osHijo2);
			BufferedReader br2 = new BufferedReader(new InputStreamReader(hijo2.getInputStream()));
			
			String line;

			while ((line = br2.readLine()) != null) {
	        	System.out.println(line);
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
}
