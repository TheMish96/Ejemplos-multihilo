/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlanTest;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mirsha bebe
 * 
 */
public class Usuarios extends Thread {
    private String nombre;
    private String privilegio;
    private int condicion;
    Random random = new Random();
    private int tiempo = random.nextInt(2)*1000;
    @Override
   public void run(){
       
       
       
    
        try {
             System.out.println("removio: " + getNombre() + "en el tiempo de " + tiempo / 1000 + "" + " segundos ");
            
           
            sleep(tiempo);
        
  
        } catch (InterruptedException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
   }

    public synchronized Random getRandom() {
        return random;
    }

    public synchronized void setRandom(Random random) {
        this.random = random;
    }

    public synchronized int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
   
    public  Usuarios (String nombre) {
        this.nombre = nombre;
        
    }

    public synchronized String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public synchronized String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    public int  getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }

    @Override
    public synchronized String toString() {
        return   "nombre=" + nombre ;
    }
    
    
}
