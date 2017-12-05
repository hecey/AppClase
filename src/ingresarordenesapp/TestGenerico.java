/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresarordenesapp;

/**
 *
 * @author prof_uide_e
 */
public class TestGenerico {

    public static void main(String[] args) {

        metodoGenrico("Hola");
        metodoGenrico(1);
        metodoGenrico(1.5);

    }

    private static <T> void metodoGenrico(T valor) {

        System.out.println("Valor:" + valor);

    }
}
