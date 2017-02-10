package Telefono;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
            
            System.out.println("Elija una opcion \n"
            		+ "1 Leer Agenda"
            		+ "2 Pedir Telefono");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Dime que quieres hacer");
            int pedir = scanner.nextInt();
            
          switch (pedir) {
          		case 1:
				System.out.println("Enviando peticion Agenda");
				os.write("Agenda".getBytes());
				os.close();

				BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(is));
				System.out.println("Mensaje Recibido");
				String mensaje;
				while((mensaje=entradaEstandar.readLine())!=null)
						{
						System.out.println(mensaje);
						}
				
				System.out.println("Cerrando el socket cliente");
				clientSocket.close();
				System.out.println("Terminado");

			break;
          		case 2:
    				System.out.println("Enviando peticion Telefono");
    				os.write("2".getBytes());
    				os.close();
    				
    				BufferedWriter entradatelefono = new BufferedWriter(new OutputStreamWriter(os));
    				System.out.println("Nombre de contacto");
    				String nombre =scanner.nextLine();
    				System.out.println("Numero del contacto");
    				String numero = scanner.nextLine();
    				

    				
    				System.out.println("Cerrando el socket cliente");
    				clientSocket.close();
    				System.out.println("Terminado");
          		case 0:
          			break;
		default:
			break;
		}
				
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
