
package diagnostico;

public class Diagnostico {
static Cuenta c = new Cuenta();
    
    public static void main(String[] args) {
        String nombres[] = {"JUAN","MARIA","JOSE","OSCAR","LUIS"};
       
        int sel = (int) (Math.random() * 3)+1;
        int nom = (int) (Math.random() * nombres.length);
        int deposito = (int) (Math.random() * 200);
        
        
        int i=0;
        
        System.out.println("selección: "+sel);
        System.out.println("cliente numero: "+nom);
        System.out.println("deposito: "+deposito);
        //System.out.println("retiro: "+deposito);
        
        /*while(i<=4){
            System.out.println("cliente: "+ nombres[nom]);
        switch(sel){
            case 1:
                c.depositarCuenta(deposito);
            break;
                
            case 2:
                c.retirar(deposito);
            break;
            
            case 3:
                c.mostrar();
            break;
            
            default:
                System.out.println("opción no válida");
            break;
            
            }
        i++;
    }
        */
            
        
        
        
        
        
    }
    
}
