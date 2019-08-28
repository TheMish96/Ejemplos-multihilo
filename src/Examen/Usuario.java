
package Examen;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Usuario  extends Thread {
      private  Cuenta cuenta;
       private Banco banco;
       private String  nombre;
       Random numeroAleatorios;
       int numero;
       
       
       

    public Usuario(Cuenta cuenta, Banco banco,String nombre) {
        super();
        this.cuenta = cuenta;
        this.banco = banco;
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }
  
       
       
       
       
    @Override
    public void run() {
        int i=0,monto,cuentadestino=0,banco=0,banco_a=0;
        numeroAleatorios= new Random();
       
        while(i<6){
              try{
                  numero=1+numeroAleatorios.nextInt(2)+3;
               
  
              switch(numero){
                case 1:
                   monto=numeroAleatorios.nextInt(10);
                   Thread.sleep((int)(Math.random()*1000));
                   cuenta.Depositar(monto,nombre);
            

                  
                    
               
            
                    break;
                case 2: 
                    monto=numeroAleatorios.nextInt(10);
                   Thread.sleep((int)(Math.random()*1000));
                    cuenta.Retirar(monto,nombre);
            
                  
            
            
                    break;
                case 3: 
                    Thread.sleep((int)(Math.random()*1000));
                    cuenta.Consultar(nombre);
            
              
                    
              
            
                    break;
                case 4: 
                    Thread.sleep((int) (Math.random()*1000));
                    cuentadestino=numeroAleatorios.nextInt(5);
                    monto=numeroAleatorios.nextInt(7)+3;
                    
                   this.banco.Trasnferir(cuenta,cuentadestino , monto);
                     
            

            
                    break;
                case 5: 
                    Thread.sleep((int) (Math.random()*1000));
                    cuentadestino=numeroAleatorios.nextInt(5);
                    monto=numeroAleatorios.nextInt(7)+3;
                    banco_a=numeroAleatorios.nextInt(1);
                    this.banco.transferirOtro(cuenta, cuenta, banco_a, banco_a, monto);
                    
                    break;
                default:
                    System.out.println(" dato erroneo");
                    break;
            }
               
            
            i++;
             } catch (InterruptedException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        
    }
   
      
       
}
