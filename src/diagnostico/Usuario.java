
package diagnostico;
public class Usuario extends Thread {
    private String nombre;
    private Cuenta  c;
    
    public Usuario(String nombre, Cuenta c) {
        this.nombre = nombre;
        this.c = c;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Cuenta getC() {
        return c;
    }

    public void setC(Cuenta c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", c=" + c + '}';
    }

    @Override
    public void run(){
        int sel;
        int monto; 
        
        for(int i=0;i<3;i++){
            sel = (int) (Math.random() * 3)+1;
            monto = (int) (Math.random() * 200);
           
        switch(sel){
            case 1:     
                c.depositarCuenta(monto,getNombre());
                
            break;
                
            case 2:
                c.retirar(monto,getNombre());
            break;
            
            case 3:
                c.mostrar(getNombre());
            break;
            
            default:
                System.out.println("opción no válida");
            break;
            
            }
        
    }
    }
    
    
}
