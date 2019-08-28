/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puntos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class MainCandados {
    
    
    
   public static void main(String[] args) throws InterruptedException {
    
       
       final Candados runner = new Candados ();
Thread t1,t2;
       t1 = new Thread(new Runnable(){
           
           public void run(){
               
               try{
                   runner.PrimerhiloThread();
               } catch (InterruptedException ex) {
                   Logger.getLogger(MainCandados.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
       });
        
        t2 = new Thread(new Runnable(){
           
           public void run(){
               
               try{
                   runner.SegundThread();
               } catch (InterruptedException ex) {
                   Logger.getLogger(MainCandados.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
       });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        runner.FinalThread();
    
    
}
}