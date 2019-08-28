/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sync;

/**
 *
 * @author MirshaBB
 */
public class TestUsuarioCuenta {

    public static void main(String[] args) {

        Cuenta2 c = new Cuenta2(200, 100, "Mirsha");

        Usuario u1 = new Usuario("user1", c);
        Usuario u2 = new Usuario("user2", c);

        u1.start();
        u2.start();

    }
}
