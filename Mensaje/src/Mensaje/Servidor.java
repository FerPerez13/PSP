package Mensaje;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{
	
	private static Socket[] sockets;
	private static String[] usuarios;
	private static Mensaje[] mensajes;
	private static int socketOcupado = 0;
	
	private int enviar;
	
	//Object Monitor = new Object();
	
	
	public Servidor(Socket socket,int enviar) {
		sockets[socketOcupado] = socket;
		socketOcupado++;
		this.enviar=enviar;
	}
	
// --- Hay que crear un if en el que comprobamos el tipo de hilo es. Y habrá códigos diferentes para los hilos dependiendo del tipo de hilo. ---
	public void run(){ 
		
		
		if (enviar==1) {
			//Se envian mensajes por aqui
			synchronized (sockets[socketOcupado]) {
				Mensaje mensaje = mensajes[socketOcupado];
			}
			//Swittch Case con los códigos de mensaje
			
		} else {
			//Se reciben mensajes
			System.out.println("Esperando mensaje");
			Mensaje mensaje;
			try {
				ObjectInputStream objectInputStream = new ObjectInputStream(sockets[socketOcupado].getInputStream());
				mensaje = (Mensaje)objectInputStream.readObject();
				synchronized (sockets[socketOcupado]) {
					mensajes[socketOcupado]=mensaje;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}  catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			//Switch Case con los códigos de mensaje
		}
		
		try {

			System.out.println("Arrancando el hilo");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public static void main(String args[]){
		
		System.out.println("Iniciando el servidor");
		System.out.println("Esperando conexiones...");
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			InetSocketAddress addr = new InetSocketAddress("192.168.26.54", 5555);
			serverSocket.bind(addr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Socket newSocket = serverSocket.accept();
			System.out.println("Conexion recibida");
			Servidor servidorE = new Servidor(newSocket, 1);
			Servidor servidorR = new Servidor(newSocket, 0);
			servidorE.start();
			servidorR.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Terminado");
		
	}
	
}
