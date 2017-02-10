package Telefono;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTelefono extends Thread{
	
	private Socket clientSocket;
	
	public ServidorTelefono(Socket socket){
		clientSocket = socket;
	}
	
	
	public void run() {
		try {
			System.out.println("Arrancando Hilo");
			
			InputStream iStream = clientSocket.getInputStream();
			OutputStream oStream = clientSocket.getOutputStream();
			File archivo = new File("telefonos.txt");
			FileReader fReader = new FileReader(archivo);
			FileWriter fWriter = new FileWriter(archivo);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
			BufferedReader bufReader = new BufferedReader(fReader);
			
			String mensaje = bReader.readLine();
			
			//TODO: Hay que conseguir que el hilo no se cierre.porque no me coje el mensaje. 
			//Cojo el Cliente de Moreno para ver que pasa y lo tengo que utilizar en casa con los 2 pc's
			
			if(mensaje.compareToIgnoreCase("agenda")==0){
				//TODO: Enviar todo lo que haya en el TXT al cliente
				System.out.println("Enviando agenda");
				String lineaAgenda;
				while ((lineaAgenda=bufReader.readLine())!=null) {
					oStream.write(lineaAgenda.getBytes());
					oStream.flush();
					oStream.close();
				}
				
			}else{
				//TODO: Guardar lo que nos llegue en el fichero TXT
				System.out.println("Leyendo para guardar nuevo agenda");
				String mensaje2 = bReader.readLine();
				bWriter.write(mensaje);
				
			}
			
			bReader.close();
			bWriter.close();
			bufReader.close();
			
		} catch (Exception e) {
			
		}
	}
	
	public static void main(String args[]) throws IOException{
		
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
		
		System.out.println("Aceptando conexiones");
		
		while(serverSocket!=null){
			try {
				Socket newSocket = serverSocket.accept();
				System.out.println("Conexión recibida");
				
				ServidorTelefono hilo = new ServidorTelefono(newSocket);
				hilo.start();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("Terminado");
	}

}
