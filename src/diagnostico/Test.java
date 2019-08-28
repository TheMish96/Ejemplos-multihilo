
package diagnostico;

public class Test {
    public static void main(String[] args){
        Cuenta c = new Cuenta();
        Usuario user1 = new Usuario("luis",c);
        Usuario user2 = new Usuario("pedro",c);
        Usuario user3 = new Usuario("mirsha",c);
        
        user1.start();
        user2.start();
        user3.start();
    }
}
