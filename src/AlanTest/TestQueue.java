/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlanTest;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class TestQueue {

    public static void main(final String[] arguments) throws InterruptedException {
        BlockingQueue<Usuarios> queue1 = new ArrayBlockingQueue<Usuarios>(15);
        BlockingQueue<Usuarios> queue2 = new ArrayBlockingQueue<Usuarios>(15);
        BlockingQueue<Usuarios> queue3 = new ArrayBlockingQueue<Usuarios>(15);

        Producer producer = new Producer(queue1, queue2, queue3);
        Consumer consumer = new Consumer(queue1, queue2, queue3);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }

    static class Producer implements Runnable {

        private BlockingQueue<Usuarios> queue1;
        private BlockingQueue<Usuarios> queue2;
        private BlockingQueue<Usuarios> queue3;

        public Producer(BlockingQueue<Usuarios> queue1, BlockingQueue<Usuarios> queue2, BlockingQueue<Usuarios> queue3) {
            this.queue1 = queue1;
            this.queue2 = queue2;
            this.queue3 = queue3;
        }

        @Override
        public void run() {
            Random random = new Random();
            int aleatorio;
            try {

//            Thread.sleep(1000);
//            queue.put(result);
//            System.out.println("Added: " + result);
                for (int i = 0; i < 20; i++) {
                    aleatorio = 1 + random.nextInt(3);
                    switch (aleatorio) {
                        case 1:

                            Usuarios nuevo = new Usuarios("Premiun");
                            System.out.println("iniciando " + nuevo.getNombre());
                            queue1.put(nuevo);

                            //System.out.println("Added: " + nuevo.toString());++++++++++++++++++++++++++++++++++++++++
                            break;
                        case 2:

                            Usuarios nuevo2 = new Usuarios("Frecuente");
                            System.out.println("iniciando " + nuevo2.getNombre());
                            queue2.put(nuevo2);

                            //System.out.println("Added: " +nuevo2.toString());
                            break;
                        case 3:

                            Usuarios nuevo3 = new Usuarios("Sin cuenta");
                            System.out.println("iniciando " + nuevo3.getNombre());
                            queue3.put(nuevo3);

                            //System.out.println("Added: " + nuevo3.toString());
                            break;

                    }

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {

        private BlockingQueue<Usuarios> queue1;
        private BlockingQueue<Usuarios> queue2;
        private BlockingQueue<Usuarios> queue3;
        int cont1 = 0, cont2 = 0, cont3 = 0;

        public Consumer(BlockingQueue<Usuarios> queue1, BlockingQueue<Usuarios> queue2, BlockingQueue<Usuarios> queue3) {
            this.queue1 = queue1;
            this.queue2 = queue2;
            this.queue3 = queue3;
        }

        @Override
        public void run() {

            try {
                Executor executor = Executors.newScheduledThreadPool(1);
                ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
                boolean mish = false;
                Random n = new Random();
                int n1;
                int cont1 = 0, cont2 = 0, cont3 = 0;
                Thread.sleep(10000);
                System.out.println("\n");

                while (queue1.size() > 0 || queue2.size() > 0 || queue3.size() > 0) {

                    if (mish == false) {
                        System.out.println("La fila de Premium contiene ah " + queue1.size() + " usuarios en espera");
                        System.out.println("La fila de frecuente contiene ah " + queue2.size() + " usuarios en espera");
                        System.out.println("La fila de sin cuenta contiene ah " + queue3.size() + " usuarios en espera");
                        System.out.println("");
                        System.out.println("");
                        mish = true;
                    }

                    if (queue1.size() > 0) {
                           executor.execute(queue1.take());
                        if (queue1.size() == 1) {
                            executor.execute(queue1.take());
                            n1 = n.nextInt(10) + 1 * 1000;
                            Thread.sleep(n1);
                            System.out.println("quedan en fila: Premium " + queue1.size());
                        } else {
                            while (cont1 < 2) {
                                executor.execute(queue2.take());
                                n1 = n.nextInt(10) + 1 * 1000;
                                Thread.sleep(n1);
                                System.out.println("quedan en fila: Frecuente" + queue2.size());
                              
                                if (queue1.size() == 1) {
                                    break;
                                }
                                cont1++;
                            }
                            n1 = n.nextInt(10) + 1 * 1000;
                            Thread.sleep(n1);
                            executor.execute(queue2.take());
                            System.out.println("quedan en fila: Frecuente " + queue1.size());
                            cont1 = 0;
                        }
                    }

                    if (queue1.isEmpty() == true && queue2.size() > 0) {
                        if (queue2.size() == 1) {
                            n1 = n.nextInt(10) + 1 * 1000;
                            Thread.sleep(n1);
                            
                            executor.execute(queue2.take());
                            System.out.println("quedan en fila: Frecuente" + queue2.size());
                            
                        } else {
                            while (cont2 < 2) {
                                n1 = n.nextInt(10) + 1 * 1000;
                                Thread.sleep(n1);

                               executor.execute(queue2.take()); 
                               System.out.println("quedan en fila: Frecuente" + queue2.size());
                                if (queue2.size() == 1) {
                                    break;
                                }
                                cont2++;
                            }
                            n1 = n.nextInt(10) + 1 * 1000;
                            Thread.sleep(n1);
                            executor.execute(queue3.take()); 
                             System.out.println("quedan en fila: Sin cuenta" + queue3.size());
                           
                        }
                    }

                    if (queue2.isEmpty() == true) {
                        for (int i = 0; i < queue3.size(); i++) {
                            n1 = n.nextInt(10) + 1 * 1000;
                            Thread.sleep(n1);
                             executor.execute(queue3.take()); 
                             System.out.println("quedan en fila: Sin cuenta" + queue3.size());
                        }
                    }

                }

            } catch (InterruptedException ex) {
                Logger.getLogger(TestQueue.class.getName()).log(Level.SEVERE, null, ex);
            }

            // System.out.println("Removed: " + queue.take()+ ""+queue.toString());
            // System.out.println("Removed: " + queue.take()+ ""+queue.toString());
        }
    }
}
