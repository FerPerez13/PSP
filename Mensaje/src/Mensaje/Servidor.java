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
	private Socket socket;
	
	//Object Monitor = new Object();
	
	public Servidor(Socket socket,int enviar) {
		this.socket=socket;
		this.enviar=enviar;
		socketOcupado++;
		
	}
	
// --- Hay que crear un if en el que comprobamos el tipo de hilo es. Y habrá códigos diferentes para los hilos dependiendo del tipo de hilo. ---
	public void run(){ 
		
		//Sacamos la posicion del socket para acceder siempre a él
		int pos = 0;
		int codigo = 0;
		for (int i = 0; i < sockets.length; i++) {
			if (sockets[i]==this.socket)
				pos = i;
		}
		
		if (enviar==1) {
			//Se envian mensajes por aqui
			synchronized (sockets[pos]) {
				Mensaje mensaje = mensajes[pos];
			}
			codigo=mensajes[pos].getCodigo();
			//Switch Case con los códigos de mensaje
			switch (codigo) {
			case 2:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				break;
			}
			
		} else {
			//Se reciben mensajes
			System.out.println("Esperando mensaje");
			Mensaje mensaje;
			try {
				ObjectInputStream objectInputStream = new ObjectInputStream(sockets[socketOcupado].getInputStream());
				mensaje = (Mensaje)objectInputStream.readObject();
				codigo = mensaje.getCodigo();
				
				synchronized (usuarios) {
					usuarios[pos]=mensaje.getUsuario();
				}
				
				synchronized (this.socket) {
					mensajes[pos]=mensaje;
				}
				
				//Switch Case con los códigos de mensaje
				switch (codigo) {
				case 1:
					break;
				case 3:
					break;
				default:
					break;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}  catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
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
			InetSocketAddress addr = new InetSocketAddress("192.168.26.41", 5555);
			serverSocket.bind(addr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			while(socketOcupado<5){
				Socket newSocket = serverSocket.accept();
				System.out.println("Conexion recibida");
				Servidor servidorE = new Servidor(newSocket, 1);
				Servidor servidorR = new Servidor(newSocket, 0);
				
				for (int i = 0; i < sockets.length; i++) {
					if(sockets[i]==null)
						sockets[i]=newSocket;			
				}
				
				servidorE.start();
				servidorR.start();
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Terminado");
		
	}
	
}
