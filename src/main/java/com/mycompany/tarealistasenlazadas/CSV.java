/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarealistasenlazadas;

import java.util.*;
import java.io.FileReader;
import com.opencsv.*;

/**
 *
 * @author juanchuc
 */
public class CSV {

    public ArrayList<Producto> data = new ArrayList<Producto>();

    public ArrayList<Producto> reacdCSV(String filePath, char separator) {
        try {
            FileReader fileReader = new FileReader(filePath);
            CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();
            List<String[]> columns = csvReader.readAll();
            ArrayList<String> identificadores = new ArrayList<>();
            ArrayList<String> nombres = new ArrayList<>();
            ArrayList<String> existencias = new ArrayList<>();


            for (String[] column : columns) {
                identificadores.add(column[0]);
                nombres.add(column[1]);
                existencias.add(column[2]);
            }

            return formattingData(identificadores, nombres, existencias);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Producto> formattingData(ArrayList<String> identificadores, ArrayList<String> nombres, ArrayList<String> existencias) {
        try {
            int tamaño = Math.min(identificadores.size(), Math.min(nombres.size(), existencias.size()));
            for (int i = 0; i < tamaño; i++) {
                Producto producto = new Producto();
                producto.setIdentificador(identificadores.get(i));
                producto.setNombre(nombres.get(i));
                producto.setExistencia(Integer.parseInt(existencias.get(i)));

                this.data.add(producto);
            }

            return this.data;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
