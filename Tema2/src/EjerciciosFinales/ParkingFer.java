package EjerciciosFinales;

import java.io.FileWriter;

public class ParkingFer {
	
	static int sitiosLibres=8;
	
	public static void main(String[] args){
		System.out.println("Bienvenido al Parking: Aparca cómo puedas");
		BarreraF barrera = new BarreraF(sitiosLibres);
		
		for(int i=0; i<sitiosLibres;i++){
			String nombre = "Coche"+i;
			CocheF coche = new CocheF(nombre, barrera);
			coche.start();
			coche.esperar(5000);
		}
	}
}

class BarreraF{
	
	private static int plazas;
	
	public BarreraF(int plazas){
		this.plazas=plazas;
	}
	
	public synchronized void permisoEntrar(){
		String coche = Thread.currentThread().getName();
		try {
			while(plazas<1){
				//TODO: Terminar
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void permisoSalir(){
		
	}
}

class CocheF extends Thread{
	
	private BarreraF barrera;
	
	public void run(){
		//TODO Entrar
	}
	public CocheF(String nombre, BarreraF barrera) {
		this.setName(nombre);		
		this.barrera=barrera;
	}
	
	public static void esperar(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			System.err.println("Tiene que esperar, esta completo");
			System.exit(-1);
		}
	}
}

//class EsperarCoche { 
//public static void esperarCoche(long milis) {
//	try {
//		Thread.sleep(milis);
//	} catch (InterruptedException e) {
//		System.err.println("Tiene que esperar, esta completo");
//		System.exit(-1);
//	}
//}
//}