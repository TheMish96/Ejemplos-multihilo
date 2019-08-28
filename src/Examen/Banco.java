package Examen;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banco {

    Cuenta cuentas[];
    Banco bancos[];
    private Lock cierrebanco= new ReentrantLock();
    private Condition SaldoSuficiente;
    private Logs l = new Logs();

    public Banco(Cuenta[] cuentas) {
        this.cuentas = cuentas;
        this.bancos = bancos;
        SaldoSuficiente=cierrebanco.newCondition();
    }



    public  void Trasnferir(Cuenta origen, int destino, int monto) throws InterruptedException {
        cierrebanco.lock();
        try {
            //principio txt
            String header = "\n*************************"+cuentas[destino].getNombre()+"***********"; 
           String salto=("\n") ;
            String inicio = "la cuenta: "+cuentas[destino].getNombre()+" recibira:   "+monto;
              
           
          
            System.out.println(inicio);
            int cuenta = origen.getSaldo();
            
            int cuenta2 = cuentas[destino].getSaldo();
           
            //mid
            String actual = "\nSaldo actual: "+cuentas[destino].getSaldo();
            System.out.println(actual);
            
            while (cuenta <monto ) {
               SaldoSuficiente.await();
             
            }
          
            origen.setSaldo(cuenta -= monto);
            cuentas[destino].setSaldo(cuenta2 += monto);
            //end
         
            String fin = "\n saldo  de la cuenta  "+origen.getNombre()+" :  final despues de  trasnferir:"
                    +cuentas[destino].getSaldo()+"\n";
            System.out.println(fin);
            
            l.guardarTransferencia(header+salto+inicio+salto+actual+salto+fin,origen.getNombre());      
            SaldoSuficiente.signalAll();
        } finally {
            cierrebanco.unlock();
        }
    }

    public synchronized void transferirOtro(Cuenta destino1,Cuenta destino2, int posicion1,int posicion2, int monto) {
        cierrebanco.lock();
        try {
            
            String header = "**************la transferencia se genera del  usuario "+destino1.getNombre()+
                    " hacia el usuario "+destino2+"***********\n";
            
            String inicio = "la cuenta: "+cuentas[posicion1].getNombre()+
                    " transferira el monto de   :   $"+monto +" hacia la cuenta "+cuentas[posicion2].getNombre()+"\n";
            
            
            System.out.println(header);
            
            System.out.println(inicio);
            
            int cuenta = destino1.getSaldo();
            int cuenta2 = destino2.getSaldo();
            
            
            while (cuenta <monto ) {
                try {
                    SaldoSuficiente.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
                }
             
            }
            
            String m = "\nSaldo actual del usuario que va a realizar la transferencia  $"+cuenta+"\n"+
                    "saldo actual del usuario recibira la transferencia $"+cuenta2;
            
            System.out.println(m);
            
          
            
            System.out.println("despues de esperar");
            destino1.setSaldo(cuenta -= monto);
            cuentas[posicion2].setSaldo(cuenta2 += monto);
            
            String f = "\nSaldo  de la cuenta origen"+cuentas[posicion1].getSaldo()+
                    " final despues de  trasnferir:"+cuentas[posicion1].getSaldo()+"\n\n"+
                    "saldo de la cuenta "+destino1.getSaldo()+
                    " al recibir la transferencia:"+cuentas[posicion2].getSaldo();
            
            System.out.println(f);
            
            l.guardarTransferencia(header+inicio+m+f, destino1.getNombre()+" a "+destino2.getNombre());
            
            
            SaldoSuficiente.signalAll();
        } finally {
            cierrebanco.unlock();
        }
        
        
        

    }

    public synchronized Cuenta[] getCuentas() {
        return cuentas;
    }

    public synchronized void setCuentas(Cuenta[] cuentas, int monto) {

        this.cuentas = cuentas;
    }

    public synchronized Banco[] getBancos() {
        return bancos;
    }

    public synchronized void setBancos(Banco[] bancos) {
        this.bancos = bancos;
    }

}
