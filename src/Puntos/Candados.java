/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puntos;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Alumno
 */
public class Candados {
    
    private int contador =0;
    private  Lock lock = new ReentrantLock();
    private Condition con =lock.newCondition();
    private void incrementador(){
        for(int i =0 ; i<100;i++){
            contador++;
        }
    }
    public void PrimerhiloThread()throws InterruptedException
    {
       lock.lock();
        System.out.println("para liberar proceso dar click.....");
        con.await();
       
        try{
        incrementador();
        }
        finally{
            lock.unlock();
        }
    }
    
    
    public void SegundThread()throws InterruptedException
    {
        
         lock.lock();
        new Scanner (System.in).nextLine();
        con.signal();
       
        try{
        incrementador();
        }
        finally{
            lock.unlock();
        }
    }
    
    public void FinalThread()throws InterruptedException
    {
        System.out.println("el resultado final es :"+contador);
        
        
    }    
    
    
    
    
}
