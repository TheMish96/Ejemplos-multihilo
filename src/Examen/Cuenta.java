package Examen;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cuenta {

    private int saldo;
    private int Limite;
    private String nombre;
    private Lock cierrecuenta = new ReentrantLock();
    private Condition SaldoSuficiente;
    private Logs l = new Logs();

    public Cuenta(int saldo, int Limite, String nombre) {
        this.saldo = saldo;
        this.Limite = Limite;
        this.nombre = nombre;
        SaldoSuficiente = cierrecuenta.newCondition();
    }

    public void Depositar(int monto, String nombre) throws InterruptedException {
        cierrecuenta.lock();
        try {
            String Header = "********************************** Depósito de: " + nombre + "++++++++++++++++++++++++++++++";
            System.out.println(Header);

            int suma = 0;

            suma = getSaldo() + monto;
            while (suma >= 21) {
                SaldoSuficiente.await();
            }

            setSaldo(suma);
            System.out.println("monto a depositar: " + monto);

            System.out.println("el saldo final es: " + getSaldo());

            l.guardarCuenta("\n\n" + Header + "\nMonto a depositar: " + monto + "\nSaldo final: " + getSaldo(), nombre);

            SaldoSuficiente.signalAll();
        } finally {
            cierrecuenta.unlock();
        }
    }

    public void Retirar(int monto, String Nombre) throws InterruptedException {
        cierrecuenta.lock();
        try {
            String Header = "********************************** Retiro de: " + Nombre + "++++++++++++++++++++++++++++++";
            System.out.println(Header);

            System.out.println("Monto a retirar" + monto);

            int resta = 0;

            resta = getSaldo() - monto;
            while (resta < 0) {
                SaldoSuficiente.await();
            }

            setSaldo(resta);

            System.out.println("el saldo final es:" + getSaldo());

            l.guardarCuenta("\n\n" + Header + "\nMonto a retirar: " + monto + "\nSaldo final: " + getSaldo(), Nombre);

        } finally {
            SaldoSuficiente.signalAll();
            cierrecuenta.unlock();
        }
    }

    public synchronized void Consultar(String nombre) {
        String Header = "********************************** Consulta de: " + nombre + "++++++++++++++++++++++++++++++";
        System.out.println(Header);

        System.out.println(" la consulta del saldo  final es: " + getSaldo());
        l.guardarCuenta("\n\n" + Header + "\nSaldo final: " + getSaldo(), nombre);
    }

    public int getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getLimite() {
        return Limite;
    }

    public synchronized void setLimite(int Limite) {
        this.Limite = Limite;
    }

    public String getNombre() {
        return nombre;
    }

    public synchronized void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
