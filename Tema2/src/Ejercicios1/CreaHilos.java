package Ejercicios1;

import java.util.Scanner;

public class CreaHilos {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.print("¿Cuantos hilos quieres crear: ");
		int num = scanner.nextInt();
		
		RunnableClass runnableClass = new RunnableClass();
		
		Thread hilo1 = new Thread(runnableClass);
		
		hilo1.setName("Hilo1");
		hilo1.start();
		
		//for(int i=0; i<num; i++){
			
			
		//}
	}
}
