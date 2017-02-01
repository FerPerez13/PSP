package tema4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class HoraClientHilo {
	public static void main(String[]args){
		try{
			System.out.println("Creando socket cliente");
            Socket clientSocket = new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress addr = new InetSocketAddress("192.168.26.109", 5555);
            clientSocket.connect(addr);

            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
            System.out.println("Enviando peticion");
            os.write("hora". getBytes());
                            
            BufferedReader entradaEstandar = new BufferedReader
            		(new InputStreamReader(is));
            System.out.println("Mensaje Recibido");
            String mensaje;
            mensaje = entradaEstandar.readLine();
            
            System.out.println ("El resultado es: "+ mensaje);
            
            System.out.println("Cerrando el socket cliente");
            clientSocket.close();
            System.out.println("Terminado");
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
