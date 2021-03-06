package Tema2;
class HiloEsperar2 extends Thread {
	public int time;
	public HiloEsperar2(int time){
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
public class HiloEjercicio4{
	public static void main(String args[]) {
		System.out.println("Empieza la ejecucion del padre");
		HiloEsperar2 hilo1 = new HiloEsperar2(3000);
		hilo1.setName("Hilo1");
		HiloEsperar2 hilo2 = new HiloEsperar2(5000);
		hilo2.setName("Hilo2");
		hilo1.start();
		hilo2.start();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException exception) {
			System.out.println("Interrumpido");
		}
		System.out.println("Acabo la ejecucion del padre");
	}
}