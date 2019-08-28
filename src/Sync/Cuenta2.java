/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sync;

/**
 *
 * @author Mirsha BB
 */
public class Cuenta2 {

    private int limite = 200, saldo, residuo = 0, MISH = 1, res;
    private String nombre;

    public synchronized String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cuenta2(int limite, int saldo, String nombre) {
        this.limite = limite;
        this.saldo = saldo;
        this.nombre = nombre;
    }

    public Cuenta2(int limite, int saldo) {
        this.limite = limite;
        this.saldo = saldo;
    }

    public synchronized int getLimite() {
        return limite;

    }

    public synchronized void setLimite(int limite) {
        this.limite = limite;
    }

    public synchronized int getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public synchronized String toString() {
        return "Cuenta{" + "limite=" + limite + ", saldo=" + saldo + ", nombre=" + nombre + '}';
    }

    public synchronized void Retirar(int monto, String nombre) throws InterruptedException {
        Cuenta2 cuenta = this;
       int contador=0;
   
        while (monto>0&&monto<saldo&&contador!=5) {

            System.out.println("+++++++++++++++++++usuario+++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++" + nombre + "+++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Saldo actual = " + getSaldo() + " saldo ah retirar:" + monto);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

            if (monto > saldo) {
                   cuenta.wait(2000);
                residuo = saldo - monto;
                res = monto - residuo;
                saldo -= res;
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("saldo final :" + toString());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("se genero un residuo de " + residuo + " solo se resto  " + res);
             contador++;
                notifyAll();
            }

            if (residuo > saldo) {
               
                saldo -= residuo;
                System.out.println("+++++++++++++++++++usuario+++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++++" + nombre + "+++++++++++++++++++++++++++");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Saldo actual = " + getSaldo() + " residuo a retirar:" + residuo);
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("saldo final :" + toString());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
             contador++;
            }
            saldo -= monto;
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("saldo final :" + toString());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        contador++;
        if(contador==5){
            System.out.println("El tiempo de espera ah terminado lo sentimos hehe");
        }
        }

    }

    public synchronized void Depositar(int monto, String nombre) throws InterruptedException {
        Cuenta2 cuenta = this;
        int error = saldo + monto,contador=0;

        while (monto>0&&saldo<limite&&contador!=5) {
   
            System.out.println("+++++++++++++++++++usuario+++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++" + nombre + "+++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Saldo actual = " + getSaldo() + " saldo ah depositar:" + monto);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            if (saldo > limite) {

                residuo = ((saldo + monto) - limite);
                res = monto - residuo;
                saldo += residuo;
                System.out.println("+++++++++++++residuo " + residuo + "saldo final" + saldo);
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("saldo final :" + toString());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

                saldo += res;
                System.out.println("+++++++++++++++++++usuario+++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++++" + nombre + "+++++++++++++++++++++++++++");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Saldo actual = " + getSaldo() + " saldo ah depositar:" + monto);
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

                System.out.println("+++++++++++++residuo quedante " + res + "saldo final" + saldo);
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("saldo final :" + toString());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                  contador++; 
                cuenta.notifyAll();

            } else {
                saldo += monto;
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("saldo final :" + toString());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                contador++;
            }
              contador++;
      if(contador==5){
            System.out.println("El tiempo de espera ah terminado lo sentimos hehe");
        }
           
        }
    }

}
