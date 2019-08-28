/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecutores;

import Examen.Cuenta;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MIRSHA
 */
public class Test extends Thread {

    public static void main(final String[] arguments) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(3000);
    }

    static class Producer implements Runnable {

        private BlockingQueue queue;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String premium[] = {"Premium1", "Premium2", "Premium3", "Premium4", "Premium5"};
            String Frecuente[] = {"frecuente1", "frecuente2", "frecuente3", "frecuente4", "frecuente5"};
            String SinC[] = {"SinC1", "Sinc2", "Sinc3", "Sinc4", "Sinc5"};
      
           
            int contador = 0;
            try {
               do {
                    contador++;

                    if (contador <=2) {
                        queue.put(premium[contador-1]);
                    }
                    if (contador == 3) {
                        queue.put(Frecuente[0]);
                    }
                    if (contador > 3 && contador <= 5) {
                        queue.put(premium[contador - 2]);
                    }
                    if (contador == 6) {

                        queue.put(Frecuente[contador - 5]);
                    }
                    if (contador == 7) {
                        queue.put(SinC[0]);

                    }
                    if(contador==8){
                        queue.put(premium[contador-4]);
                    }
                    if(contador>8&&contador<=10){
                        queue.put(Frecuente[contador-7]);
                        
                    }
                    if(contador==10){
                        queue.put(SinC[contador-9]);
                    }
                    if(contador==11){
                        queue.put(Frecuente[contador-7]);
                    }
                    if(contador>11){
                        queue.put(SinC[contador-10]);
                    }
                }while(contador!=15);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {

        private BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestQueue.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
                
                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
                System.out.println("temino de ser atendido : " + queue.take());
              

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
