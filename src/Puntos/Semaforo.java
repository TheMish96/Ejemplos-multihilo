/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puntos;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MIRSHA
 */
public class Semaforo implements Runnable {


private int contador=0;        

Semaphore semaforo= new Semaphore(2);



 private void incrementador(){
        for(int i =0 ; i<100;i++){
            contador++;
            if(contador==100){
            System.out.println("El contador final es :"+contador);
                System.out.println("Espera...");
        }}


        
        
 }
 


    @Override
    public void run() {

    try {
        semaforo.acquire();
        incrementador();
        Thread.sleep(5000);
        System.out.println("se libera el proceso");
        semaforo.release();
        
        
    } catch (InterruptedException ex) {
        Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
    }
 
 
 
 
    }}




    
    
    
            
         


