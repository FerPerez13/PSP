package Tema2;
class HiloEsperar5 extends Thread {
	public int time;
	public HiloEsperar5(int time){
		this.time=time;
	}
	public void run() {
		System.out.println("Soy el "+ Thread.currentThread().getName() +" empezando.");
		try {
			System.out.println("Voy a esperar "+time+" ms");
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() +" interrumpido.");
			return;
		}
		System.out.println(Thread.currentThread().getName() +" acabado.");
	}		
}
public class HiloEjercicio5{
	public static void main(String args[]) {
		System.out.println("Empieza la ejecucion del padre");
		HiloEsperar5 hilo1 = new HiloEsperar5(3000);
		hilo1.setName("Hilo1");
		HiloEsperar5 hilo2 = new HiloEsperar5(5000);
		hilo2.setName("Hilo2");
		hilo1.start();
		hilo2.start();
		try {
			hilo1.join();
			hilo2.join(1000);
		} catch (InterruptedException exception) {
			System.out.println("Interrumpido");
		}
		System.out.println("Acabo la ejecucion del padre");
	}
}