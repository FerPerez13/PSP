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
	private static int socketOcupado = 0;
	
	private int enviar;
	
	public Servidor(Socket socket,int enviar) {
		sockets[socketOcupado] = socket;
		socketOcupado++;
		this.enviar=enviar;
	}
	
// --- Hay que crear un if en el que comprobamos el tipo de hilo es. Y habrá códigos diferentes para los hilos dependiendo del tipo de hilo. ---
//	public void run(){ 
//		try {
//
//			System.out.println("Arrancando el hilo");
//			ObjectInputStream objectInputStream = new ObjectInputStream(sockets[socketOcupado].getInputStream());
//			
//			
//			System.out.println("Esperando mensaje");
//
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
	public static void main(String args[]){
		
		System.out.println("Iniciando el servidor");
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			InetSocketAddress addr = new InetSocketAddress("192.168.26.16", 5555);
			serverSocket.bind(addr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Socket newSocket = serverSocket.accept();
			System.out.println("Conexion recibida");
			Servidor servidor = new Servidor(newSocket, 1);
			servidor.start();
;		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Terminado");
		
	}
	
}