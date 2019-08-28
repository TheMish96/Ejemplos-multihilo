/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sync;

import javax.swing.JOptionPane;

/**
 *
 * @author mirsha BB
 */
public class Cuenta {

    private int limite = 200, saldo, residuo = 0, MISH = 1, res;
    private String nombre;

    public synchronized String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cuenta(int limite, int saldo, String nombre) {
        this.limite = limite;
        this.saldo = saldo;
        this.nombre = nombre;
    }

    public Cuenta(int limite, int saldo) {
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
        Cuenta cuenta = this;

        while (MISH != 0) {
            System.out.println("+++++++++++++++++++usuario+++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++" + nombre + "+++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Saldo actual = " + getSaldo() + " saldo ah retirar:" + monto);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

            if (monto > saldo) {
                residuo = saldo - monto;
                res = monto - residuo;
                saldo -= res;
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("saldo final :" + toString());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("se genero un residuo de " + residuo + " solo se resto  " + res);
            }

            

            if (residuo > saldo) {
                saldo -= residuo;
                System.out.println("+++++++++++++++++++usuario+++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++++" + nombre + "+++++++++++++++++++++++++++");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Saldo actual = " + getSaldo() + " residuo a retirar:" + residuo);
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                cuenta.wait();
                

                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("saldo final :" + toString());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                notify();
            }
             saldo-=monto;
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("saldo final :" + toString());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            if (residuo < saldo) {
                MISH = 0;
            }
        }
    }

    public synchronized void Depositar(int monto, String nombre) throws InterruptedException {
        Cuenta cuenta = this;
       
        while (saldo < limite) {

            System.out.println("+++++++++++++++++++usuario+++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++" + nombre + "+++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Saldo actual = " + getSaldo() + " saldo ah depositar:" + monto);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            if (saldo > limite) {
                cuenta.wait();
                residuo=((saldo+monto)-limite);
                res= monto-residuo;  
                saldo += residuo;
                System.out.println("+++++++++++++residuo "+residuo+"saldo final"+saldo);
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("saldo final :" + toString());
               System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
               
               
               saldo += res;
               System.out.println("+++++++++++++++++++usuario+++++++++++++++++++++++++++");
               System.out.println("+++++++++++++++++++" + nombre + "+++++++++++++++++++++++++++");
               System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
               System.out.println("Saldo actual = " + getSaldo() + " saldo ah depositar:" + monto);
               System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
               
                System.out.println("+++++++++++++residuo quedante "+res+"saldo final"+saldo);
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("saldo final :" + toString());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                
            }
            else{
                 saldo+=monto;
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("saldo final :" + toString());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
               
            }
            
            cuenta.notify();

         

        }

    }
}
