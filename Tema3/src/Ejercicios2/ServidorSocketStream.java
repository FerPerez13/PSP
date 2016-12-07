package Ejercicios2;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class ServidorSocketStream {
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress address = new InetSocketAddress("192.168.28.186",5555);
			serverSocket.bind(address);
			
			Socket socket = serverSocket.accept();
			
			OutputStream os = socket.getOutputStream();
			
			FileReader fileReader = new FileReader("vetusta.txt");
			
			int car;
			byte[] msj = new byte[50];
			car = fileReader.read();
			while(car != -1){
				
				os.write(car);
			}
			fileReader.close();
			
			socket.close();
			
			//TODO: No se que falta, falta completar
			
		} catch (Exception e) {
			System.err.println("Se ha perdido la conexión");
		}
	}
}
