/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarealistasenlazadas;

import java.util.*;

/**
 *
 * @author juanchuc
 */
public class TareaListasEnlazadas {

    public static final String CSV_FILE_PATH = "/Users/juanchuc/Desktop/listasenlazadas.csv";
    public static final char SEPARATOR = ',';
    public static Lista listaEnlazadaProducto = new Lista();

    public static void main(String[] args) {
        CSV csv = new CSV();

        System.out.println("-------------------------------INCISO 2---------------------------");
        System.out.println("\n");

        System.out.println("---------------A. Se cargo CSV correctamente----------------");
        System.out.println("\n");


        ArrayList<Producto> lista = csv.reacdCSV(CSV_FILE_PATH, SEPARATOR);
        if (lista == null) {
            System.out.println("Error en carga y formateo de datos");
        }

        System.out.println("---------------B. Datos del estudiante----------------");
        System.out.println("\n");

        System.out.println("Nombre: Juan Ariel Chuc Lopez");
        System.out.println("Carnet: 5190-23-18778");
        System.out.println("-----------------------------------------------");
        System.out.println("\n");

        System.out.println("-------------------C. Cargada de registros desde csv--------------------");
        System.out.println("\n");

        System.out.println("-------------------i. Insercion de registros ingresados--------------------");
        System.out.println("\n");
        listaEnlazadaProducto.insercionPorLotes(lista);
        System.out.println("\n");

        System.out.println("-----------ii. Listado de todos los registros ingresados---------");
        System.out.println("\n");

        listaEnlazadaProducto.recorrer();
        System.out.println("\n");

        System.out.println("-------------------D. Eliminar registros--------------------");
        System.out.println("\n");

        System.out.println("-----------i. Se elimina un registro al final de la lista---------");
        System.out.println("\n");
        listaEnlazadaProducto.eliminarUltimo();
        System.out.println("\n");

        System.out.println("-----------ii. Se elimina el primer registro de la lista---------");
        System.out.println("\n");
        listaEnlazadaProducto.eliminarPrimero();
        System.out.println("\n");

        System.out.println("-----------iii. Se lista los registros de la lista---------");
        System.out.println("\n");
        listaEnlazadaProducto.recorrer();
        System.out.println("\n");

        System.out.println("-------------------E. Agregar registros--------------------");
        System.out.println("\n");
        System.out.println("-----------i. Se inserta registro al inicio de la lista---------");
        System.out.println("\n");

        Producto nuevoProducto = new Producto();
        nuevoProducto.setIdentificador("SD-98");
        nuevoProducto.setNombre("Producto SD-98");
        nuevoProducto.setExistencia(23);
        listaEnlazadaProducto.insertarAlprincipio(nuevoProducto);
        System.out.println("\n");

        System.out.println("-----------ii. Se inserta registro al final de la lista---------");
        System.out.println("\n");

        Producto nuevoProductofinal = new Producto();
        nuevoProductofinal.setIdentificador("SD-99");
        nuevoProductofinal.setNombre("Producto SD-99");
        nuevoProductofinal.setExistencia(92);
        listaEnlazadaProducto.insertarAlFinal(nuevoProductofinal, true);
        System.out.println("\n");

        System.out.println("-----------iii. Se listan registros de la lista---------");
        System.out.println("\n");
        listaEnlazadaProducto.recorrer();
        System.out.println("\n");

        System.out.println("-----------iv. Se inserta registro en cualquier posicion ( posicion 5 )---------");
        System.out.println("\n");
        Producto nuevoProductoPosicion = new Producto();
        nuevoProductoPosicion.setIdentificador("SD-100");
        nuevoProductoPosicion.setNombre("Producto SD-100");
        nuevoProductoPosicion.setExistencia(21);
        listaEnlazadaProducto.insertarEnIndice(nuevoProductoPosicion, 5);
        System.out.println("\n");

        System.out.println("-----------v. Se inserta registro en cualquier posicion (posicion 14 )---------");
        System.out.println("\n");
        Producto nuevoProductoPosicion2 = new Producto();
        nuevoProductoPosicion2.setIdentificador("SD-100");
        nuevoProductoPosicion2.setNombre("Producto SD-100");
        nuevoProductoPosicion2.setExistencia(21);
        listaEnlazadaProducto.insertarEnIndice(nuevoProductoPosicion2, 14);
        System.out.println("\n");

        System.out.println("-----------vi. Se lista registros de la lista---------");
        System.out.println("\n");
        listaEnlazadaProducto.recorrer();
        System.out.println("\n");

    }
}
