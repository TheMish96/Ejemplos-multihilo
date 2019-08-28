/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Investigacion;

/**
 *
 * @author Mirsha bebe
 * 
 */
public class Usuarios extends Thread {
    private String nombres;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "nombres=" + nombres + '}';
    }

    public Usuarios(String nombres) {
        this.nombres = nombres;
    }


    

 

    
    
}
