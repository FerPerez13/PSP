package Ejercicios1;

import java.util.Scanner;


public class Fibonacci {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("¿Cuantos valores quieres de la sucesión de Fibonacci?: ");
		int num = scanner.nextInt();
		if (num<2) {
			System.err.println("La sucesión de Fibonacci se genera a partir de dos números, por lo que pedir menos de 2 números no es productivo.");
			System.err.println("Por esta misma razón, voy a mostrarte solo 2 elementos de la sucesión");
			num=2;
		}
		RunnableClass rc = new RunnableClass(num);
		Thread hilo1 = new Thread(rc);
		hilo1.start();
	}
}
class RunnableClass implements Runnable{
	public int num;
	public RunnableClass(int num){
		this.num=num;
	}
	public RunnableClass() {
		System.out.println("Yo");
	}
	public void run(){
		int fib1 = 0;
		int fib2 = 1;
		System.out.print(fib1 + " " + fib2+ " ");
		for (int i=0;i<num-2;i++){
			int fib3 = fib1+fib2;
			System.out.print(fib3 + " ");
			fib1=fib2;
			fib2=fib3;
		}	
	}
}