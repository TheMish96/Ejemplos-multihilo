package intro;



public class MiHilo extends Thread {

    public void impresiones(){
        System.out.println("instrucción 1");
        System.out.println("instrucción 2");
        System.out.println("instrucción 3");
        System.out.println("instrucción 4");
        System.out.println("instrucción 5");
    }
    
    @Override
    public void run() {
        System.out.println(getName()+" instrucción 1");
        System.out.println(getName()+"instrucción 2");
        System.out.println(getName()+"instrucción 3");
        System.out.println(getName()+"instrucción 4");
        System.out.println(getName()+"instrucción 5");
    }
    
    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
   public static void main(String[] args) {
       MiHilo hilo = new MiHilo();
       MiHilo hilo2 = new MiHilo();
       MiHilo hilo3 = new MiHilo();
       
       //hilo.impresiones();
       //hilo2.impresiones();
       //hilo3.impresiones();
       
       System.out.println("");
       
       hilo.start();
       hilo2.start();
       hilo3.start();
       
   }
}
