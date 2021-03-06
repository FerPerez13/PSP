package tema1;
import java.io.*;
import java.util.Arrays;

public class EjercicioAleatorio {
	
	public static void main(String[] args){
		try{
			
			Process hijo = new ProcessBuilder("./aleatorios").start();
			
			InputStream is = hijo.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			PrintStream ps = new PrintStream(hijo.getOutputStream());
			
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			
			String line;
			while((line=br2.readLine()).compareTo("fin")!=0){ //(Guardamos en line lo leido por teclado) lo comparamos con fin y si es diferente de 0 lo pasamos a la linea de abajo
				ps.println(line);
				ps.flush(); //Limpiamos el bufer
				
				//Con esto leemos las lineas directamente
				if((line=br.readLine()) != null ) {
					System.out.println(line);
				}
			}
			
			//Esto es si leemos todas las lineas, las guardamos en el buffer y despues lo leemos 
			// while((line=br.readLine()) != null ) {
			// 	System.out.println(line);
			// }
			
			System.out.println("Salida del proceso " + Arrays.toString(args) + " : " ) ;
						
		}catch(Exception e){
			System.out.println("Error ocurrió ejecutando el	comando. Descripción: " + e.getMessage());
			
		}
	}

}
