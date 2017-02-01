package Mensaje;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{
	
	private Socket[] sockets;
	private int socketOcupado = 0;
	
	public Servidor(Socket socket) {
		sockets[socketOcupado] = socket;
		socketOcupado++;
	}
	
	public void run(){
		
	}
	
	public static void main(String args[]){
		
		System.out.println("Iniciando el servidor");
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Socket newSocket = serverSocket.accept();
;		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}
	
}
