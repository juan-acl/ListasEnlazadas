/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarealistasenlazadas;

import java.util.*;

/**
 *
 * @author juanchuc
 */
public class Lista {

    public Nodo primero = null;
    public int length = 0;

    private void logLista(Producto producto) {
        System.out.printf("%-15s %-25s %-10d%n",
                producto.getIdentificador(),
                producto.getNombre(),
                producto.getExistencia());
    }


    private void logInsercion(Producto producto, int index) {
        System.out.printf("%-15d %-15s %-25s %-10d%n", index, producto.getIdentificador(), producto.getNombre(), producto.getExistencia());
    }

    private void log(Producto producto, int paso) {
        String mensaje = switch (paso) {
            case 1 ->
                String.format("[INSERCIÓN] Producto agregado:\n  - ID: %s\n  - Nombre: %s\n  - Existencia: %d",
                producto.getIdentificador(), producto.getNombre(), producto.getExistencia());
            case 2 ->
                String.format("[ELIMINACIÓN] Producto eliminado:\n  - ID: %s\n  - Nombre: %s\n  - Existencia: %d",
                producto.getIdentificador(), producto.getNombre(), producto.getExistencia());
            case 3 ->
                String.format("[LISTADO] Información del producto:\n  - ID: %s\n  - Nombre: %s\n  - Existencia: %d",
                producto.getIdentificador(), producto.getNombre(), producto.getExistencia());
            default ->
                "Paso no reconocido.";
        };

        System.out.println(mensaje);
    }


    public void insertarAlprincipio(Producto producto) {
        Nodo nuevoProducto = new Nodo(producto);
        log(producto, 1);
        length++;
        if (primero == null) {
            primero = nuevoProducto;
            return;
        }
        nuevoProducto.siguiente = primero.siguiente;
        primero = nuevoProducto;
    }

    public void insertarAlFinal(Producto producto, boolean visibleLog) {
        Nodo nuevoProducto = new Nodo(producto);
        length++;
        if (visibleLog) {
            log(producto, 1);
        }
        if (primero == null) {
            primero = nuevoProducto;
            return;
        }

        Nodo puntero = primero;
        while (puntero.siguiente != null) {
            puntero = puntero.siguiente;
        }

        puntero.siguiente = nuevoProducto;
    }

    public void insercionPorLotes(ArrayList<Producto> productos) {
        System.out.printf("%-15s %-15s %-25s %-10s%n", "Correlativo", "Código", "Nombre Producto", "Existencia");
        System.out.println("--------------------------------------------------------------------");

        int index = 0;
        for (Producto prod : productos) {
            length++;
            index++;
            Nodo nuevoproducto = new Nodo(prod);
            if (primero == null) {
                logInsercion(nuevoproducto.producto, index);
                primero = nuevoproducto;
                continue;
            }
            logInsercion(nuevoproducto.producto, index);
            insertarAlFinal(prod, false);
        }
    }

    public void recorrer() {
        System.out.printf("%-15s %-25s %-10s%n", "Código", "Nombre Producto", "Existencia");

        System.out.println("---------------------------------------------------------------");

        Nodo puntero = primero;
        while (puntero != null) {
            logLista(puntero.producto);
            puntero = puntero.siguiente;
        }
    }

    public void eliminarPrimero() {
        if (primero == null) {
            return;
        }
        length--;
        Nodo puntero = primero;
        log(primero.producto, 2);
        primero = puntero.siguiente;
        puntero.siguiente = null;

    }

    public void eliminarUltimo() {
        if (primero == null) {
            return;
        }
        length--;
        Nodo puntero = primero;
        while (puntero.siguiente.siguiente != null) {
            puntero = puntero.siguiente;
        }
        log(puntero.siguiente.producto, 2);
        puntero.siguiente = null;

    }

    public void insertarEnIndice(Producto producto, int index) {
        if (primero == null) {
            return;
        }
        length++;
        Nodo nuevoProducto = new Nodo(producto);
        log(producto, 1);
        Nodo puntero = primero;
        int contador = 1;
        while (contador < index && puntero.siguiente != null) {
            contador++;
            puntero = puntero.siguiente;
        }

        if (contador != index) {
            return;
        }

        nuevoProducto.siguiente = puntero.siguiente;
        puntero.siguiente = nuevoProducto;

    }

    public void eliminarEnIndice(int index) {
        if (primero == null) {
            return;
        }

        if (index > length) {
            return;
        }

        length--;

        if (index == 0) {
            eliminarPrimero();
            return;
        }

        Nodo puntero = primero;

        int contador = 0;
        int anterior = index - 1;
        while (contador < anterior) {
            contador++;
            puntero = puntero.siguiente;
        }
        Nodo temp = puntero.siguiente;
        log(temp.producto, 3);
        puntero.siguiente = temp.siguiente;
        temp.siguiente = null;
    }

}
