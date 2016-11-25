package PruebaFernandoPerezAndres;

/************************************************************/	
/*			Ejercicio	Ejercicio3 							*/	
/*			Autor:	Fernando	Perez Andres 		 		*/	
/*			Fecha:	25 Noviembre 2016 					    */	
/************************************************************/	

public class Parking {	
	public static void main(String[] args) {
		Barrera entrada = new Barrera(5,3);
		for (int i = 0; i < 10; i++){
			Coche coche = new Coche("Coche " + i, entrada);
			coche.start();
			if(i<5){
				Moto moto = new Moto("Moto "+i, entrada);
				moto.start();
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
		barrera.entrarCoche(nombre);
		System.out.println(nombre +" he aparcado y me espero.");
		// El coche aparca, se espera y luego sale del parking
		Espera.espera(5000);
		barrera.salirCoche(nombre);
	}
}

class Moto extends Thread{
	private String nombre;
	private Barrera barrera;
	
	public Moto(String nombre, Barrera barrera){
		this.nombre=nombre;
		this.barrera=barrera;
	}
	
	public void run(){
		barrera.entrarMoto(nombre);
		System.out.println(nombre+" he aparcado y me espero");
		Espera.espera(5000);
		barrera.salirMoto(nombre);
	}
}

class Barrera {
	private int huecosCoche;
	private int huecosMoto;
	public  Barrera (int huecosCoche, int huecosMoto){
		this.huecosCoche = huecosCoche;
		this.huecosMoto = huecosMoto;
	}
	
	public void entrarCoche(String nombre){
		
		synchronized (this) {
			try {
				while (huecosCoche < 1 ) {
					System.out.println(nombre +" no puedo entrar.");
					wait();
				}
				huecosCoche--;
			} catch (InterruptedException e) {
				System.out.println(nombre + " interrumpido");
			}
			
		}
		System.out.println(nombre +" entrando. Plazas: "+ huecosCoche);
		Espera.espera(5000);
	}
	public void entrarMoto(String nombre){
		synchronized (this) {
			try {
				while (huecosMoto < 1 ) {
					System.out.println(nombre +" no puedo entrar.");
					wait();
				}
				huecosMoto--;
			} catch (InterruptedException e) {
				System.out.println(nombre + " interrumpido");
			}
			
		}
		System.out.println(nombre +" entrando. Plazas: "+ huecosMoto);
		Espera.espera(5000);
	}
	public synchronized void salirCoche(String nombre){
		huecosCoche++;
		notifyAll();
		System.out.println(nombre +" saliendo. Plazas: "+ huecosCoche);
	}
	
	public synchronized void salirMoto(String nombre){
		huecosMoto++;
		notifyAll();
		System.out.println(nombre +" saliendo. Plazas: "+ huecosMoto);
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