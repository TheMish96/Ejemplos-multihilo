package diagnostico;
public class Cuenta {
    public  int saldo;
    
    public  void depositarCuenta(int x, String nombre){
       saldo +=x;
        System.out.println(nombre +" depositó: "+x+" saldo actual: "+saldo);
    }
    
    public void retirar(int x, String nombre){
        saldo -=x;
        System.out.println(nombre +" retiró: "+x+" saldo actual: "+saldo);
    }
    
    public void mostrar(String nombre){
        System.out.println(nombre+" consultó saldo: "+saldo);
        
    }

    @Override
    public String toString() {
        return "Cuenta{" + "saldo=" + saldo + '}';
    }
    
    
}
