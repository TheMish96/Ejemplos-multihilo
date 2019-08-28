package Ejecutores;

import intro.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;



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
    

    
    
    
    
    
    
   public static void main(String[] args) {
        try {
            MiHilo hilo1 = new MiHilo();
            MiHilo hilo2 = new MiHilo();
            MiHilo hilo3 = new MiHilo();
            MiHilo hilo4 = new MiHilo();
            MiHilo hilo5 = new MiHilo();
            
            
            Executor executor = Executors.newScheduledThreadPool(1);
            ThreadPoolExecutor pool = (ThreadPoolExecutor)executor;
            
            System.out.println("Largest executions: "
                    + pool.getLargestPoolSize());
            System.out.println("Maximum allowed threads: "
                    + pool.getMaximumPoolSize());
            System.out.println("Current threads in pool: "
                    + pool.getPoolSize());
            System.out.println("Currently executing threads: "
                    + pool.getActiveCount());
            System.out.println("Total number of threads(ever scheduled): "
                    + pool.getTaskCount());
            
            executor.execute(hilo1 );
            executor.execute(hilo2 );
            executor.execute(hilo3 );
            executor.execute(hilo4 );
            executor.execute(hilo5 );
            
            
            Thread.sleep(1000 );
            System.out.println("Core threads: " + pool.getCorePoolSize());
            System.out.println("Largest executions: "
                    + pool.getLargestPoolSize());
            System.out.println("Maximum allowed threads: "
                    + pool.getMaximumPoolSize());
            System.out.println("Current threads in pool: "
                    + pool.getPoolSize());
            System.out.println("Currently executing threads: "
                    + pool.getActiveCount());
            System.out.println("Total number of threads(ever scheduled): "
                    + pool.getTaskCount());
            
            pool.shutdown();
            
            
            
            System.out.println("");
        } catch (InterruptedException ex) {
            Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
       
   }
}
