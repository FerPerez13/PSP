package Ejercicios1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.InetAddress;

public class ClienteSocketStream {
	public static void main(String[] args) {
		int cont = 0;
		while (cont < 5) {
			try {
				System.out.println("Creando socket cliente");
				Socket clientSocket = new Socket();
				
				System.out.println("Estableciendo la conexión");
				InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
				// InetSocketAddress addr = new InetSocketAddress(InetAddress.getByName("192.168.26.166",5555);
				clientSocket.connect(addr);
				
				InputStream is = clientSocket.getInputStream();
				OutputStream os = clientSocket.getOutputStream();
				
				System.out.println("Enviando mensaje");
				String mensaje = "El de la tarde es tonto del culete";
				os.write(mensaje.getBytes());
				System.out.println("Mensaje enviado");
				
				System.out.println("Cerrando el socket cliente");
				clientSocket.close();
				
				System.out.println("Terminado");
				
				cont++;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
