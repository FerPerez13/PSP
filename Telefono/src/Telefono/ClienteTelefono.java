package Telefono;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


public class ClienteTelefono {
	public static void main (String[] args) {
		try{
			System.out.println("Creando socket cliente");
            Socket clientSocket = new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress addr = new InetSocketAddress("192.168.26.41", 5555);
            clientSocket.connect(addr);

            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
			
            int pedir;
            do{
	            System.out.println("*******************\n"
	            		+ "Elija una opcion \n"
	            		+ "  1 Leer Agenda\n"
	            		+ "  2 Pedir Telefono\n"
	            		+ "  0 Salir\n"
	            		+ "********************\n");
	            Scanner scanner = new Scanner(System.in);
	            System.out.println("Dime que quieres hacer");
	            pedir = scanner.nextInt();
            
           
          switch (pedir) {
          		case 1:
        			BufferedReader bReader = new BufferedReader(new InputStreamReader(is));
        			System.out.println("Enviando peticion Agenda\n");
					os.write("1\r\n".getBytes());
	
					String mensaje;
					
					do{
						mensaje=bReader.readLine();
						if (mensaje.compareTo("-1")!=0) 
							System.out.println(mensaje);
						
					}while(mensaje.compareTo("-1")!=0);
					
					System.out.println("\nFin Lectura de Agenda");
					break;
          		case 2:
          			
    				System.out.println("Enviando peticion Telefono");
    				os.write("2\r\n".getBytes());
    				
    				System.out.println("Nombre de contacto");
    				String nombre =scanner.next();
    				
    				System.out.println("Numero del contacto");
    				String numero = scanner.next();
    				
    				os.write((nombre+"\t"+numero+"\r\n").getBytes());
          		case 0:
          			os.write("0\r\n".getBytes());
          			break;
          		default:
          			break;
          }
            }while(pedir!=0);
			clientSocket.close();
			System.out.println("Terminado");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}