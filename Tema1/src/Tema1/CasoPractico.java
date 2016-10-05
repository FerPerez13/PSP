package Tema1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class CasoPractico {

	public static void main(String[] args) throws IOException, InterruptedException {
		try{
			//String comando1 = "cmd /c dir c:";
			//String comando2 = "cmd /c find \"w\"";
			String comando1 = "ls -la | grep p";
			String comando2 = "grep p";
			
			Process hijo1 = Runtime.getRuntime().exec(comando1);            
 
            InputStream isHijo1 = hijo1.getInputStream();
			BufferedReader br = new BufferedReader (new InputStreamReader(isHijo1));

			String line;
			
       						
            Process hijo2 = Runtime.getRuntime().exec(comando2);
            OutputStream osHijo2 = hijo2.getOutputStream();
            PrintStream ps = new PrintStream(osHijo2);
            BufferedReader br2 = new BufferedReader (new InputStreamReader(hijo2.getInputStream()));
            
            while ((line = br.readLine()) != null) {
            	ps.println(line);
            	ps.flush();
            }

            while ((line = br2.readLine()) != null) {
            	System.out.println(line);
            }            
		} catch (IOException e) {
			System.out.println("Error ocurrió ejecutando el	comando. Descripción: " + e.getMessage());
		}
	}

}
