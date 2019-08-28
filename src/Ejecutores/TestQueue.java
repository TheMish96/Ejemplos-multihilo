
package Ejecutores;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mirsha
 */
public class TestQueue {

   public static void main(final String[] arguments) throws InterruptedException {
      BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

      Producer producer = new Producer(queue);
      Consumer consumer = new Consumer(queue);
      Consumer consumer2 =new Consumer(queue);

      new Thread(producer).start();
      new Thread(consumer).start();

      Thread.sleep(4000);
   }  


   static class Producer implements Runnable {
      private BlockingQueue<Integer> queue;

      public Producer(BlockingQueue queue) {
         this.queue = queue;
      }

      @Override
      public void run() {
         Random random = new Random();

         try {
          
            
            for(int i=0; i<6;i++){
            
            int result = random.nextInt(100);
            Thread.sleep(1000);
            queue.put(result);
            System.out.println("Added: " + result);
            }
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
              Thread.sleep(6000);
          } catch (InterruptedException ex) {
              Logger.getLogger(TestQueue.class.getName()).log(Level.SEVERE, null, ex);
          }
         try {
            System.out.println("Removed: " + queue.take());
            System.out.println("Removed: " + queue.take());
            System.out.println("Removed: " + queue.take());
            System.out.println("Removed: " + queue.take());
            System.out.println("Removed: " + queue.take());
            System.out.println("Removed: " + queue.take());
            
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}    

