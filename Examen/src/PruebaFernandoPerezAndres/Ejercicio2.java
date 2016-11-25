package PruebaFernandoPerezAndres;

/************************************************************/	
/*			Ejercicio	Ejercicio2 							*/	
/*			Autor:	Fernando	Perez Andres 		 		*/	
/*			Fecha:	25 Noviembre 2016 					    */	
/************************************************************/	

public class Ejercicio2 {

	static Hi hilo1 = new Hi();
	static Hi2 hilo2 = new Hi2();
	
	public static void main(String[] args){
		
		hilo1.start();
		hilo2.start();
		try {
			hilo1.join();
			hilo2.join();
		} catch (Exception e) {
			
		}
	
		System.out.println("Dejaos de gilipolleces");
	}

}

class Hi extends Thread{
	private String frase1 = "A mí me rebota y a ti te explota";
	public void run(){
		for(int i=0; i<5; i++){
			System.out.println(frase1);
			Ejercicio2.hilo2.interrupt();
			try {
				Ejercicio2.hilo2.join();	
			} catch (Exception e) {
				
			}
		}
	}
}

class Hi2 extends Thread{
	private String frase2 = "Y tu mas";
		public void run(){
			for(int i=0; i<5; i++){
				try {
					Ejercicio2.hilo1.join();	
				} catch (Exception e) {
					
				}
				System.out.println(frase2);
				Ejercicio2.hilo1.interrupt();
			}
	}
}

