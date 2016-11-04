package Tema2;
class HiloEsperar extends Thread {
	public void run() {
		System.out.println("Soy el "+ Thread.currentThread().getName() +" empezando.");
		try {
			System.out.println("Voy a esperar 10 segundos");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() +" interrumpido.");
			return;
		}
		System.out.println(Thread.currentThread().getName() +" acabado.");
	}		
}
public class HiloEspera{
	public static void main(String args[]) {
		HiloEsperar hiloEsperar = new HiloEsperar();
		hiloEsperar.start();
		hiloEsperar.setName("Hilo1");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException exception) {
			System.out.println("Interrumpido");
		}
		System.out.println("Acabo la ejecucion - main");
		
		
	}
}