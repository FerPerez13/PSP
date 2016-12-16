package Ejercicios4;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio6 {
	
	//TODO: VARIABLES DE CLASE PARA EL MENSAJE Y CONDICION

	public static void main(String[] args) {
		
		HiloServer6 hiloServer6 = new HiloServer6();
		hiloServer6.start();
		
		HiloCliente6 hiloCliente6 = new HiloCliente6();
		hiloCliente6.start();
	}

}

class HiloServer6 extends Thread {

	public void run() {

		try {
			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress address = new InetSocketAddress("192.168.26.186", 60000);
			serverSocket.bind(address);

			Socket socket = serverSocket.accept();

			// TODO: COSAS QUE HACER AQUI
			
			System.out.println("Conexión recibida");

			while (true) { // Bucle infinito para el aceptar cosas
			}

			// serverSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class HiloCliente6 extends Thread {

	public void run() {

		
			Socket clientSocket;// = new Socket();
			InetSocketAddress address = new InetSocketAddress("192.168.26.166", 60000);
		do {			
			clientSocket = new Socket();
			try {
				clientSocket.connect(address);
				
				
				
			}catch (Exception e) {
				try {
					System.err.println("Intentando reconectar");
					Thread.sleep(3000);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		} while (!clientSocket.isConnected());
		System.out.println("Conectado");
		while (true) { // Bucle infinito para el aceptar cosas

		}

	}

}
