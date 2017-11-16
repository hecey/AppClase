/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresarordenesapp;

import java.util.Scanner;

/**
 *
 * @author prof_uide_e
 */
public class Menu {
    Orden orden= new Orden();
    Menu(String menuTipo, Orden orden) {
        this.orden = orden;
        crearMenu(menuTipo);
    }

    private void crearMenu(String menuTipo) {
        switch (menuTipo) {
            case "Producto":
                presentarMenuProductos();
                validarOpcionProductos(obtenerOpcion());
                break;
            default:
                System.out.println("Menu no existe");
                break;
        }
    }

    private static void presentarMenuProductos() {
        System.out.println("Menu Principal");
        System.out.println("1.- Ingresar Producto");
        System.out.println("2.- Ver Productos");
        System.out.println("3.- Eliminar Productos");
        System.out.println("4.- Modificar Productos");
        System.out.println("5.- Salir");
    }
    
    private static int obtenerOpcion() {
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }

    private void validarOpcionProductos(int opcion) {
        String menuTipo = "Producto";
        switch (opcion) {
            case 1:
                System.out.println("Ingresar Producto");
                orden.ingresarProducto();
                crearMenu(menuTipo);
                break;
            case 2:
                System.out.println("Ver Producto(s)");
                orden.verProducto();
                crearMenu(menuTipo);
                break;
            case 5:
                System.out.println("Terminado");
                break;
            default:
                System.out.println("Opcion no existe");
                crearMenu(menuTipo);
                break;
        }
    }

    
}