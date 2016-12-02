package EjerciciosFinales;
/**
 * Created by fernando on 24/11/16.
 */
public class Filosofos {
    private static Tenedor[] tenedores ={
            new Tenedor("T1",0),
            new Tenedor("T2",1),
            new Tenedor("T3",2),
            new Tenedor("T4",3),
            new Tenedor("T5",4)
    };
    public static void main(String[] args) {
        for (int i = 0;i<tenedores.length-1; i++){
            Filosofo filosofo = new Filosofo("Filo"+i,tenedores[i],tenedores[i+1]);
            filosofo.start();
        }
        Filosofo filosofo = new Filosofo("Filo4", tenedores[4], tenedores[0]);
        filosofo.start();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Filosofo extends Thread{
    private String nombre;
    private Tenedor tenedor1;
    private Tenedor tenedor2;

    public  Filosofo(String nombre, Tenedor tenedor1, Tenedor tenedor2){
        this.nombre=nombre;
        this.tenedor1=tenedor1;
        this.tenedor2=tenedor2;
    }

    public void run(){
        tenedor1.soltar(nombre);
        tenedor2.soltar(nombre);
        tenedor1.comer(nombre);
        tenedor2.comer(nombre);
        System.out.println(nombre+" he cogido ambos tenedores y me pongo a comer");
        Espera.espera(5000);
        tenedor1.soltar(nombre);
        tenedor2.soltar(nombre);
    }
}

class Tenedor{
    private String nombre;
    private int num;
    private int coger; //Si es 0 si puede coger, si es 1 si no se puede coger
    public Tenedor(String nombre, int num){
        this.nombre = nombre;
        this.num = num;
        this.coger=1;}

    public void comer(String nombre){
        synchronized (this) {
            try {
                while (coger == 1) {
                    System.out.println(nombre + " No puedo comer con el tenedor "+num);
                    wait();
                }
                coger=0;
            } catch (InterruptedException e) {
                System.out.println(nombre+" He sido interrumpido");
            }
        }
        System.out.println(nombre+" Cojo el tenedor "+num);
        Espera.espera(5000);
    }

    public synchronized void soltar(String nombre){
        coger++;
        notify();
        System.out.println(nombre+" suelto el tenedor "+num);
    }
}

class Espera2 {
	public static void espera(long espera){
		try{
			Thread.sleep(espera);
		}catch (InterruptedException e) {
			System.err.println ("Thread coche interrumpido");
			System.exit(-1);
		}
	}
}
