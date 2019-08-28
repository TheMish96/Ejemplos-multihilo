
package Sync;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mirsha BB
 */
public class Usuario  extends Thread {
   private String nombre;
   private Cuenta cuenta;
   private Cuenta2 cuenta2;

    public Usuario(String nombre, Cuenta cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public Usuario(String nombre, Cuenta2 cuenta2) {
        this.nombre = nombre;
        this.cuenta2 = cuenta2;
    }
    

 

    @Override
    public void run() {
      
       
       
     
        
       
        
        
        
        

   int contador=0;
        while(contador!=5){
     
            int deposito = (int) (Math.random() * 4)*10;
             int sel = (int) (Math.random() * 1);
        switch(sel){
            case 0:
            {
                try {
                    cuenta2.Depositar(deposito,"user1");
               
                } catch (InterruptedException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
                
            case 1:
            {
                try {
                    cuenta2.Retirar(deposito,"user1");
                  
                } catch (InterruptedException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            
           
            
            default:
                System.out.println("opción no válida");
            break;
    
    }
        contador++;}
    
    
    
   
    }



}
