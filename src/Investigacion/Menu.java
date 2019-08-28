/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Investigacion;

import com.oracle.jrockit.jfr.Producer;
import static java.lang.Thread.sleep;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MIRSHA
 */
public class Menu {

    public static void main(final String[] arguments) throws InterruptedException {

       BlockingQueue<Usuarios> queue = new ArrayBlockingQueue<Usuarios>(15);
       

        Producer producer = new Producer(queue);
        
        Consumer consumer = new Consumer(queue);
       

        new Thread(producer).start();
        new Thread (consumer).start(); 

        Thread.sleep(1000);

    }

    static class Producer implements Runnable {

        private BlockingQueue<Usuarios> queue;
        
        public Producer(BlockingQueue<Usuarios> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                String nombres_mamones[] = {"usuario1", "usuario2", "usuario3", "usuario4", "usuario5", "usuario6", "usuario7", "usuario8", "usuario9", "usuario10"};
                
                Random random = new Random();
                int contador = 0;
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Fifo \n 2.Lifo \n 3.Prioridad \n4.Por tiempo \ningrese un numero"));
                
                
                switch (opcion) {
                    case 1:
                        
                        do{
                            try {
                                int aleatorio2 = 1 + random.nextInt(5) * 1000;
                                int aleatorio = 5 + random.nextInt(5) * 1000;
                                sleep(aleatorio);
                                System.out.println("Esta en la fila " + nombres_mamones[contador]);
                                Usuarios usuario = new Usuarios(nombres_mamones[contador]);
                                queue.put(usuario);
                                System.out.println("Ingreso  " + usuario + "  duro en espera  " + aleatorio2 / 1000 + "  segundos");
                                contador++;
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }while(contador!=10);
                        break;
                        
                        
                        
                        
                    case 2:
                        String Lifo[] =new String [10];
                        int contador1=0,contador2=0;
                        contador1=9;
                        do{
                            try {
                                int aleatorio = 5 + random.nextInt(5) * 1000;
                                int aleatorio2 = 1 + random.nextInt(5) * 1000;
                                sleep(aleatorio);
                                System.out.println("Esta en la fila " + nombres_mamones[contador2]);
                                Lifo[contador2]=nombres_mamones[contador1];
                                Usuarios usuario2 = new Usuarios(Lifo[contador2]);
                                queue.put(usuario2);
                                System.out.println("Ingreso  " + nombres_mamones[contador2] + "  duro en espera  " + aleatorio2 / 1000 + "  segundos");
                                contador2++;
                                contador1--;
                                contador++;
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            }}while(contador!=10);
                        break;
                        
                        
                    case 3:
                        Comparator<Usuario_2> prioridad = Comparator.comparing(Usuario_2::getPrioridad);
                        PriorityBlockingQueue <Usuario_2> queue2 = new PriorityBlockingQueue<>(10,prioridad);
                        int cont=0;  
                        
                        
                        do{
                        int aleatorio = 5 + random.nextInt(5) * 1000;    
                        int prioridads = 1 + random.nextInt(5);    
                        sleep(aleatorio);
                        
                        System.out.println("Entra en fila "+nombres_mamones[cont]+"  con la prioridad de "+prioridads);
                        queue2.add(new Usuario_2(prioridads,nombres_mamones[cont]));
                        cont++;
                        contador++;
                        }while(contador!=10);
                        do{
                            System.out.println("");
                        System.out.println("se removio ah "+queue2.take());
                        
                        }while(queue.size()==0);
                        
                        break;
                        
                        
                    case 4:
                        
                        
                        Comparator<Usuario_2> tiempo = Comparator.comparing(Usuario_2::getPrioridad);
                        PriorityBlockingQueue <Usuario_2> tiempo1 = new PriorityBlockingQueue<>(10,tiempo);
                        int conta=0;  
                        
                        
                        do{
                        int aleatorio = 5 + random.nextInt(5) * 1000;    
                        int Tiempo = 1 + random.nextInt(5);    
                        sleep(aleatorio);
                        
                        System.out.println("Entra en fila "+nombres_mamones[conta]+"tiempo de espera  "+Tiempo);
                        tiempo1.add(new Usuario_2(Tiempo,nombres_mamones[conta]));
                        conta++;
                        contador++;
                        }while(contador!=10);
                        do{
                            System.out.println("");
                        System.out.println("se removio ah "+tiempo1.take());
                        
                        }while(queue.size()==0);
                        
                        
                        
                        
                        
                        
                        
                        break;
                        
                        
                        default:
                            System.out.println("Opcion invalida");
                            break;
                    
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
           

            
       }}
    

    static class Consumer implements Runnable {

        private BlockingQueue<Usuarios> queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            
            try {
                
                sleep(30000);
                try {
                    if(queue.size()>9){
                        System.out.println("");
                        System.out.println("Removed: " + queue.take());
                        System.out.println("Removed: " + queue.take());
                        System.out.println("Removed: " + queue.take());
                        System.out.println("Removed: " + queue.take());
                        System.out.println("Removed: " + queue.take());
                        System.out.println("Removed: " + queue.take());
                        System.out.println("Removed: " + queue.take());
                        System.out.println("Removed: " + queue.take());
                        System.out.println("Removed: " + queue.take());
                        System.out.println("Removed: " + queue.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }} catch (InterruptedException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }}

        }

    }


