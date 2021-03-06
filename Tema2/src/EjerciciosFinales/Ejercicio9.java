package EjerciciosFinales;

import java.util.Scanner;

class Hilo extends Thread {
	public static int vocales=0;
	static String frase;	
	public void run() {
		//Comprobamos el nombre del hilo para saber que ejecutar
		if(currentThread().getName().compareTo("HiloA")==0)
			this.contA(frase);
		if(currentThread().getName().compareTo("HiloE")==0)
			this.contE(frase);
		if(currentThread().getName().compareTo("HiloI")==0)
			this.contI(frase);
		if(currentThread().getName().compareTo("HiloO")==0)
			this.contO(frase);
		if(currentThread().getName().compareTo("HiloU")==0)
			this.contU(frase);
	}
	//Todos los métodos para contar las diferentes vocales
	public synchronized void contA(String frase){
		for (int i=0; i<frase.length(); i++){
			if(frase.charAt(i)=='a' || frase.charAt(i)=='A'){
				vocales++;
			}
		}
	}
	public synchronized void contE(String frase){
		for (int i=0; i<frase.length(); i++){
			if(frase.charAt(i)=='e'|| frase.charAt(i)=='E'){
				vocales++;
			}
		}
	}
	public synchronized void contI(String frase){
		for (int i=0; i<frase.length(); i++){
			if(frase.charAt(i)=='i'|| frase.charAt(i)=='I'){
				vocales++;
			}
		}
	}
	public synchronized void contO(String frase){
		for (int i=0; i<frase.length(); i++){
			if(frase.charAt(i)=='o'|| frase.charAt(i)=='O'){
				vocales++;
			}
		}
	}
	public synchronized void contU(String frase){
		for (int i=0; i<frase.length(); i++){
			if(frase.charAt(i)=='u'|| frase.charAt(i)=='U'){
				vocales++;
			}
		}
	}
}

public class Ejercicio9 {	
	public static void main(String[] args) {
		Hilo hiloA = new Hilo();
		hiloA.setName("HiloA");
		Hilo hiloE = new Hilo();
		hiloE.setName("HiloE");
		Hilo hiloI = new Hilo();
		hiloI.setName("HiloI");
		Hilo hiloO = new Hilo();
		hiloO.setName("HiloO");
		Hilo hiloU = new Hilo();
		hiloU.setName("HiloU");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Dime la frase a analizar: ");
		Hilo.frase = scanner.nextLine();
		
		hiloA.start();
		hiloE.start();
		hiloI.start();
		hiloO.start();
		hiloU.start();
		//Hay que esperar a que terminen todos los hilos con los join()
		try{
			hiloA.join();
			hiloE.join();
			hiloI.join();
			hiloO.join();
			hiloU.join();
		}catch (Exception e) {
			System.err.println("Ya no hay más hilos que esperar");
		}
		System.out.println("Hay "+Hilo.vocales+" vocales en la frase que me has pasado.");
	}
}

