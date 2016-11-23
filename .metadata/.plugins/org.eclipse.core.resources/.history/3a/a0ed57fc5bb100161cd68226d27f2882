package unidad2;

public class Parking {	
	public static void main(String[] args) {
		Barrera entrada = new Barrera(3);
		for (int i = 0; i < 10; i++){
			Coche coche = new Coche("Coche " + i, entrada);
			coche.start();
			
			long tEspera = (long) (Math.random()*7+1)*1000;
			try {
				Thread.sleep(tEspera);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}	
}

class Coche extends Thread{
	private String nombre;
	private Barrera barrera;
	
	public Coche (String nombre, Barrera barrera){
		this.nombre = nombre;
		this.barrera = barrera;
	}
	
	public void run(){

		barrera.entrar(nombre);
		System.out.println(nombre +" he aparcado y me espero.");
		// El coche aparca, se espera y luego sale del parking
		Espera.espera(5000);

		barrera.salir(nombre);
	}
}

class Barrera {
	private int huecos;
	public  Barrera (int huecos){
		this.huecos = huecos;
	}
	
	public void entrar(String nombre){
		synchronized (this) {
			try {
				while (huecos < 1 ) {
					System.out.println(nombre +" no puedo entrar.");
					wait();
				}
				huecos--;
			} catch (InterruptedException e) {
				System.out.println(nombre + " interrumpido");
			}
			
		}
		System.out.println(nombre +" entrando. Plazas: "+ huecos);
		Espera.espera(5000);
	}
	public synchronized void salir(String nombre){
		huecos++;
		notifyAll();
		System.out.println(nombre +" saliendo. Plazas: "+ huecos);
	}
}

class Espera {
	public static void espera(long espera){
		try{
			Thread.sleep(espera);
		}catch (InterruptedException e) {
			System.err.println ("Thread coche interrumpido");
			System.exit(-1);
		}
	}
}