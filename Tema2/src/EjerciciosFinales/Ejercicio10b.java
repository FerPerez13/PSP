package EjerciciosFinales;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio10b extends Thread {
	private static FileWriter fichero = null;
	private static BufferedWriter bw = null;

	public Ejercicio10b (String nombre) {
		this.setName(nombre);
	}
	
	public void run() {
		if(this.getName().compareTo("titulo")==0)
			this.titulo();
		else if(this.getName().compareTo("estrofa1")==0)
			this.estrofa1();
		else
			this.estrofa2();
	}
	
	public static void titulo() {
		String texto = "Vetusta Morla - La deriva\r\n";
		System.out.println(Thread.currentThread().getName() +" Procedo a escribir en el fichero.");
		try {
			synchronized (fichero) {
				for (int i=0; i<texto.length(); i++) {
					bw.write(texto.charAt(i));	
				}
	            try {
	            	Thread.currentThread().sleep(50);
	            } catch (InterruptedException e) {
					// TODO: handle exception
				}
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public static void estrofa1() {
		String texto = "\r\nHe tenido tiempo de desdoblarme\r\nY ver mi rostro en otras vidas\r\nYa tir� la piedra al centro del estanque\r\n";
		System.out.println(Thread.currentThread().getName() +" Procedo a escribir en el fichero.");
		try {
			synchronized (fichero) {
				for (int i=0; i<texto.length(); i++) {
					bw.write(texto.charAt(i));	
				}
	            try {
	            	Thread.currentThread().sleep(50);
	            } catch (InterruptedException e) {
					// TODO: handle exception
				}
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public static void estrofa2() {	
		String texto = "\r\nHe enterrado cuentos y calendario\r\nYa cambi� el bal�n por gasolina\r\nHe prendido el bosque al incendiar la orilla\r\n";
		System.out.println(Thread.currentThread().getName() +" Procedo a escribir en el fichero.");
		try {
			synchronized (fichero) {
				for (int i=0; i<texto.length(); i++) {
					bw.write(texto.charAt(i));	
				}
	            try {
	            	Thread.currentThread().sleep(50);
	            } catch (InterruptedException e) {
					// TODO: handle exception
				}
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
	}
	
	public static void main(String[] args) {
		try {
			fichero = new FileWriter("vetusta.txt");
            bw = new BufferedWriter(fichero);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Ejercicio10b titulo = new Ejercicio10b("titulo");
		Ejercicio10b estrofa1 = new Ejercicio10b("estrofa1");
		Ejercicio10b estrofa2 = new Ejercicio10b("estrofa2");
		titulo.start();
		try{
			titulo.join();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		estrofa1.start();
		estrofa2.start();
		try{
			estrofa1.join();
			estrofa2.join();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			bw.close();
		} catch (IOException e) {

		}		
	}
}