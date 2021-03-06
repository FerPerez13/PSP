package Ejercicios1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class ServidorSocketStream {
	public static void main(String[] args) {

		try {
			System.out.println("Creando socket servidor");
			ServerSocket serverSocket = new ServerSocket();
			System.out.println("Realizando el bind");
			InetSocketAddress addr = new InetSocketAddress("192.168.26.186", 5555);
			serverSocket.bind(addr);
			
			int cont = 0;
			while (cont<5){
				
				System.out.println("Aceptando conexiones");
				Socket newSocket = serverSocket.accept();
				System.out.println("Conexión recibida");
				new HiloServidor(newSocket).start();
				
				cont++;
			}
			
			System.out.println("Cerrando el socket servidor");
			serverSocket.close();
			System.out.println("Terminado");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class HiloServidor extends Thread{
	
	Socket socket;
	
	public HiloServidor(Socket socket) {
		this.socket=socket;
	}
			
	public void run(){
		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			byte[] mensaje = new byte[50];
			is.read(mensaje);
			System.out.println("Mensaje recibido:" + new String(mensaje));
			System.out.println("Cerrando el nuevo socket");
			socket.close();
			System.out.println("Cerrando el socket servidor");
			socket.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}