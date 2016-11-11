package Tema2;

public class Main {
    public static void main(String[] args) {     
        VerificarCuenta vc = new VerificarCuenta();
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Luis.start();
        Manuel.start();
    }
}
class CuentaBanco {
    private int balance = 50;
    public CuentaBanco(){        
    }
    public int getBalance(){
        return balance;
    }
    public void retiroBancario(int retiro){
        balance = balance - retiro;
    }
}
class VerificarCuenta implements Runnable{
    private CuentaBanco cb = new CuentaBanco();
    private synchronized void HacerRetiro(int cantidad) throws InterruptedException{        
        if(cb.getBalance() >= cantidad){
            System.out.println(Thread.currentThread().getName() + " está realizando un retiro de: "
                        + cantidad + ".");
            Thread.sleep(1000);
            cb.retiroBancario(cantidad);
            System.out.println(Thread.currentThread().getName() + ": Retiro realizado.");
            System.out.println(Thread.currentThread().getName() + ": Los fondos son de: " + cb.getBalance());
        } else {
            System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro Sr."
                        + Thread.currentThread().getName());
            System.out.println("Su saldo actual es de "+cb.getBalance());
            Thread.sleep(1000);
        }       
    }
    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            try {
                this.HacerRetiro(10);
                if(cb.getBalance() < 0){
                    System.out.println("La cuenta está sobregirada.");
                }
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }
    }
}
