package PAQUETE;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoSleep extends Thread {
    
    @Override
    public void run() {
        int acumulador =0;
        int c=0,s1=0,s2=0,s3=0,s4=0;
        for (int i = 0; c == 0; i++) {

             s1 = (int) (Math.random() * 15)  * 1000;
             s2 = (int) (Math.random() * 15)  * 1000;
             s3 = (int) (Math.random() * 15)  * 1000;
             s4 = (int) (Math.random() * 15)  * 1000;

            if (s1 + s2 + s3 + s4 == 15000) {
                c = 1;
            }
        }

        try {

           System.out.println(getName()+" instrucción 1" + " " +s1 + " Acumulado : " +acumulador);
            sleep(s1);
            acumulador+=s1;
            System.out.println(getName()+" instrucción 2"+ " " +s2 + " Acumulado : " +acumulador);
            sleep(s2);
            acumulador+=s2;
            System.out.println(getName()+" instrucción 3"+ " " +s3 + " Acumulado : " +acumulador);
            sleep(s3);
            acumulador+=s3;
            System.out.println(getName()+" instrucción 4"+ " " +s4 + " Acumulado : " +acumulador);
            sleep(s4);
            acumulador+=s4;
            System.out.println(getName()+" instrucción 5" + " Acumulado : " +acumulador);
            

        } catch (InterruptedException ex) {
            Logger.getLogger(DemoSleep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        DemoSleep hilo = new DemoSleep();
        DemoSleep hilo2 = new DemoSleep();
        DemoSleep hilo3 = new DemoSleep();

        //hilo.impresiones();
        //hilo2.impresiones();
        //hilo3.impresiones();
        hilo.start();
        hilo2.start();
        hilo3.start();

    }
}
