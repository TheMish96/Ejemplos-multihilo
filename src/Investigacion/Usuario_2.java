/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Investigacion;

/**
 *
 * @author MIRSHA
 */
public class Usuario_2  implements Comparable<Usuario_2>{

    
  private int prioridad;
  private String nombre;

    public Usuario_2(int prioridad, String nombre) {
        this.prioridad = prioridad;
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Usuario_2 o) {
       
    return prioridad;
    }

    @Override
    public String toString() {
        return "Usuario_2{" + "prioridad=" + prioridad + ", nombre=" + nombre + '}';
    }
    
    
    
}


    
    
    
    
    
  
    

