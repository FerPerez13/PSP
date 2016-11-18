package EjerciciosFinales;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio10 extends Thread {
	private static FileWriter fichero = null;
	// No es necesario el BufferedWriter
	//private static BufferedWriter bw = null;

	public Ejercicio10 (String nombre) {
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
	
	//public synchronized static void titulo() {
	public static void titulo() {
		String texto = "Vetusta Morla - La deriva\r\n";
		
		try {
			for (int i=0; i<texto.length(); i++) {
				fichero.write(texto.charAt(i));
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
	
		//public synchronized static void estrofa1() {
		public static void estrofa1() {
		String texto = "\r\nHe tenido tiempo de desdoblarme\r\nY ver mi rostro en otras vidas\r\nYa tiré la piedra al centro del estanque\r\n";
		
		try {
			for (int i=0; i<texto.length(); i++) {
				fichero.write(texto.charAt(i));
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
	
		//public synchronized static void estrofa2() {	
		public static void estrofa2() {	
		String texto = "\r\nHe enterrado cuentos y calendario\r\nYa cambié el balón por gasolina\r\nHe prendido el bosque al incendiar la orilla\r\n";
		
		try {
			for (int i=0; i<texto.length(); i++) {
	            fichero.write(texto.charAt(i));
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
           // bw = new BufferedWriter(fichero);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Ejercicio10 titulo = new Ejercicio10("titulo");
		Ejercicio10 estrofa1 = new Ejercicio10("estrofa1");
		Ejercicio10 estrofa2 = new Ejercicio10("estrofa2");
		titulo.start();
		estrofa1.start();
		estrofa2.start();
		
		try{
			estrofa1.join();
			estrofa2.join();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			fichero.close();
		} catch (IOException e) {

		}		
	}
}