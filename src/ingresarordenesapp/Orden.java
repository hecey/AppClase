/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresarordenesapp;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author prof_uide_e
 */
public class Orden {
    private String ordenID;
    private Producto[] producto;
    private double total;
    private String fecha;
    private boolean enviado;
 
    public Orden() {
        producto = new Producto[10];
        for (int i = 0; i <= producto.length - 1; i++) {
            producto[i] = new Producto();
        }
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

    public Producto[] getProducto() {
        return producto;
    }

    public void setProducto(Producto[] Producto) {
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

        recorrer:
        for (int i = 0; i <= producto.length - 1; i++) {
            //System.out.println("-" + producto[i].getProductoID());
            if (producto[i].getProductoID().equals("")) {
                System.out.println("Ingresar ID");
                producto[i].setProductoID(entrada.next());
                
                
                
                
                break recorrer;
            }
        }

    }

    public void verProducto() {
        for (int i = 0; i <= producto.length - 1; i++) {
            if (!producto[i].getProductoID().equals("")) {
                System.out.println("ID: " + producto[i].getProductoID());
            }
        }
    }
    
    
    
}
