package Tema2;
class HiloEsperar3 extends Thread {
	public int time;
	public HiloEsperar3(int time){
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
public class HiloDaemonEjercicio6{
	public static void main(String args[]) {
		System.out.println("Empieza la ejecucion del padre");
		HiloEsperar3 hilo1 = new HiloEsperar3(3000);
		hilo1.setName("Hilo1");
		HiloEsperar3 hilo2 = new HiloEsperar3(5000);
		hilo2.setName("Hilo2");
		HiloEsperar3 hilo3 = new HiloEsperar3(20000);
		hilo3.setName("HiloDaemon");
		hilo3.setDaemon(true);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException exception) {
			System.out.println("Interrumpido");
		}
		System.out.println("Acabo la ejecucion del padre");
	}
}