/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresarordenesapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author prof_uide_e
 */
public class Orden {

    private String ordenID;
    //private Producto[] producto;
    ArrayList<Producto> producto = new ArrayList();
    private double total;
    private String fecha;
    private boolean enviado;

    public Orden() {
       // producto = new Producto[10];
//        for (int i = 0; i <= producto.length - 1; i++) {
//            producto[i] = new Producto();
//        }
    }

    public Orden(String ordenID, double total, String fecha, boolean enviado) {
        this.ordenID = ordenID;
        this.total = total;
        this.fecha = fecha;
        this.enviado = enviado;
    }

    public String getOrdenID() {
        return ordenID;
    }

    public void setOrdenID(String OrdenID) {
        this.ordenID = OrdenID;
    }

    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ArrayList<Producto> Producto) {
        this.producto = Producto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double Total) {
        this.total = Total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String Fecha) {
        this.fecha = Fecha;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean Enviado) {
        this.enviado = Enviado;
    }

    @Override
    public String toString() {
        return "Orden{" + "OrdenID=" + ordenID + ", Producto=" + producto + ", Total=" + total + ", Fecha=" + fecha + ", Enviado=" + enviado + '}';
    }

    public void ingresarProducto() {
        Scanner entrada = new Scanner(System.in);

        //recorrer:
        //for (int i = 0; i <= producto.length - 1; i++) {
            //System.out.println("Debug-VerProductos: " + i);

           // if (producto[i].getProductoID().equals("")) {
                Producto p= new Producto();
                System.out.println("Ingresar ID:");
                p.setProductoID(entrada.next());
                System.out.println("Ingresar Nombre:");
                p.setNombre(entrada.next());
                System.out.println("Ingresar Descripcion:");
                p.setDescripcion(entrada.next());
                System.out.println("Ingresar Precio:");
                p.setPrecio(entrada.nextDouble());
                System.out.println("Ingresar Cantidad:");
                p.setCantidad(entrada.nextInt());
                producto.add(p);
         //       break recorrer;
         //   }
       // }

    }

    public void ingresarProducto(Producto p) {

        System.out.println("Ingresar ID:");
        p.setProductoID(validarEntrada(
                obtenerPorTeclado(String.class), p.getProductoID()));

        System.out.println("Ingresar Nombre:");
        p.setNombre(validarEntrada(obtenerPorTeclado(String.class), p.getNombre()));

        System.out.println("Ingresar Descripcion:");
        p.setDescripcion(validarEntrada(obtenerPorTeclado(String.class), p.getDescripcion()));

        System.out.println("Ingresar Precio:");
        p.setPrecio(
                validarEntrada(obtenerPorTeclado(Double.class), p.getPrecio()));

        System.out.println("Ingresar Cantidad:");
        p.setCantidad(
                validarEntrada(obtenerPorTeclado(Integer.class), p.getCantidad()));
    }

    public void verProducto() {
        //for (int i = 0; i <= producto.length - 1; i++) {
            //System.out.println("Debug-VerProductos: " + i);
           // if (!producto[i].getProductoID().equals("")) {
           
        Iterator<Producto> iterator = producto.iterator();
        while (iterator.hasNext()) {
                Producto p = iterator.next();
                p= iterator.next();
                System.out.println("ID: " + p.getProductoID());
                System.out.println("Nombre: " + p.getNombre());
                System.out.println("Descripcion: " + p.getDescripcion());
                System.out.println("Precio: " + p.getPrecio());
                System.out.println("Cantidad: " + p.getCantidad());
        }
                
            //}
        //}
    }

    public void eliminarProducto(String productoId) {
        boolean productoExiste = false;
        //recorrer:
        //for (int i = 0; i <= producto.length - 1; i++) {
        Iterator<Producto> iterator = producto.iterator();
        while (iterator.hasNext()) {
                Producto p = iterator.next();
                if (p.getProductoID().equals(productoId)) {
                    productoExiste = true;
                    //Elimina producto de la Lista
                    producto.remove(p);
                }
        }
//            if (producto[i].getProductoID().equals(productoId)) {
//                
//                producto[i].setProductoID("");
//                producto[i].setCantidad(0);
//                producto[i].setDescripcion("");
//                producto[i].setNombre("");
//                producto[i].setPrecio(0.00);
//                break recorrer;
//            }
       // }
        if (productoExiste == true) {
            System.out.println("Producto Eliminado: " + productoId);
        } else {
            System.out.println("Producto no existe: " + productoId);
        }
    }

    void modificarProducto(String productoId) {
        boolean productoExiste = false;
        Iterator<Producto> iterator = producto.iterator();
        while (iterator.hasNext()) {
                Producto p = iterator.next();
                if (p.getProductoID().equals(productoId)) {
                    productoExiste = true;
                    //Modifica producto de la Lista
                     ingresarProducto(p);
                }
        }

//recorrer:
//        for (int i = 0; i <= producto.length - 1; i++) {
//            if (producto[i].getProductoID().equals(productoId)) {
//                productoExiste = true;
//                //Codigo para modificar el producto
//                ingresarProducto(i);
//                break recorrer;
//            }
//        }
        //Evaluo si existe el producto con la variable productoExiste
        if (productoExiste == true) {
            System.out.println("Producto Modificado: " + productoId);
        } else {
            System.out.println("Producto no existe: " + productoId);
        }
    }

    //Remove
    public static String obtenerStringPorTeclado() {
        Scanner entrada = new Scanner(System.in);
        return entrada.next();

    }

    private <T extends Object> T validarEntrada(T entradaPorTeclado, T entradaExistente) {
        if (entradaPorTeclado instanceof String) {
            if (((String) entradaPorTeclado).isEmpty()) {
                return entradaExistente;
            }
        }
        if (entradaPorTeclado instanceof Integer) {
            if ((Integer) entradaPorTeclado == 0) {
                return entradaExistente;
            }
        }

        if (entradaPorTeclado instanceof Double) {
            if ((Double) entradaPorTeclado == 0.0) {
                return entradaExistente;
            }
        }

        return entradaPorTeclado;

    }

    public <T> T obtenerPorTeclado(Class<T> clazz) {
        Scanner entrada = new Scanner(System.in);
        try {
            if (clazz == Integer.class) {  return clazz.cast(entrada.nextInt());
            }
            if (clazz == Double.class) {   return clazz.cast(entrada.nextDouble());
            }
            if (clazz == String.class) {  return clazz.cast(entrada.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Intenta de nuevo....");
            obtenerPorTeclado(clazz);
        }
        return null;
    }

    //
//        try {
//            if (c == Integer.class) {
//                return c.cast(entrada.nextInt());
//            }
//            if (c == String.class) // the next cast to String is safe
//            {
//                return c.cast(entrada.next());
//            }
//            if (c == Double.class) // the next cast to Double is safe
//            {
//                return c.cast(entrada.nextDouble());
//            }
//        } catch (Exception e) {
//            System.out.println("Intenta de nuevo....");
//        }
//        return obtenerPorTeclado(c);
//    }
//        private static <T> T validarEntrada(T entradaPorTeclado, T entradaExistente) {
//
//        // String valor = "" + entradaPorTeclado;
//        if (entradaPorTeclado instanceof String) {
//            if (((String) entradaPorTeclado).isEmpty()) {
//                return entradaExistente;
//            }
//
//        }
//        if (entradaPorTeclado instanceof Integer) {
//            if (((Integer) entradaPorTeclado).equals(0)) {
//                return entradaExistente;
//            }
//
//        }
//
//        return entradaPorTeclado;
}
