package Tema2;

class Prioridad extends Thread {
	public void run() {
		System.out.println("Soy el " + Thread.currentThread().getName() + " empezando.");
		for (int i = 0; i < 10; i++)
			System.out.println("Soy el " + Thread.currentThread().getName() + " iteración " + i);
		System.out.println("Soy el " + Thread.currentThread().getName() + " acabando.");
	}
}

public class HilosPrioridad {
	public static void main(String[] args) {
		Prioridad thread1 = new Prioridad();
		thread1.setName("Hilo 1");
		thread1.setPriority(Thread.MIN_PRIORITY);
		Prioridad thread2 = new Prioridad();
		thread2.setName("Hilo 2");
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread1.start();
		thread2.start();
	}
}