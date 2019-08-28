/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puntos;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author MIRSHA
 */
public class Atomicos {
    
    private AtomicInteger c = new AtomicInteger(10);
    public void incremento(){
        c.incrementAndGet();
        System.out.println(c);
       
    }
    public void decremento(){
        
        c.decrementAndGet();
    }
    
    public int value(){
        
        return c.get();
    }
    
    public synchronized void incrementar() throws InterruptedException{
      
      c.incrementAndGet();
        System.out.println("c es igual ah: "+c);
      wait(3000);
        notify();
        System.out.println("el Proceso ah sido liberado");
    }
}
