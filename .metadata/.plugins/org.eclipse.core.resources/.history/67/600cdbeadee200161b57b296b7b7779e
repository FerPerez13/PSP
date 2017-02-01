package tema4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HoraServerHilo extends Thread {
	private Socket clientSocket;

    public HoraServerHilo (Socket socket) {
        clientSocket = socket;
    }
    public void run () {
        try {
            System.out.println("Arrancando hilo");

            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();

            System.out.println("Esperando mensaje");

            byte[] buffer = new byte[4];
            is.read(buffer);
            String peticion = new String(buffer);
            System.out.println("Peticion Recibida");
            byte [] respuesta = "".getBytes();
            if (peticion.equals("hora")) {
				System.out.println("Enviando respuesta");
				Date d = new Date(System.currentTimeMillis());
				respuesta = (d.toString().substring(11,23)+d.toString().substring(24)).getBytes();
				
				System.out.println("Mensaje enviado");
				
			} else if (peticion.equals("fech")) {
				System.out.println("Enviando respuesta");
				Date d = new Date(System.currentTimeMillis());
				respuesta = d.toString().substring(0,11).getBytes();
			
				System.out.println("Mensaje enviado");
				
			} else {
				System.out.println("Mensaje recibido no reconocido");
			}
            os.write(respuesta);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hilo terminado");
    }
    
    public static void main (String[] args) {
        System.out.println("Creando socket servidor");
        ServerSocket serverSocket = null;
    
        try {
            serverSocket = new ServerSocket();
            System.out.println ("Realizando el bind");
            InetSocketAddress addr = new InetSocketAddress("192.168.26.16", 5555);
            serverSocket.bind(addr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Aceptando conexiones");

        while (serverSocket != null) {
            try {
                Socket newSocket = serverSocket.accept();
                System.out.println("Conexi�n recibida");
                HoraServerHilo hilo = new HoraServerHilo(newSocket);
                hilo.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Terminado");
    }
}