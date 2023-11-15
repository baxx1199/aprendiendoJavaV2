/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.estaciones;

import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Nodo[] nodos = {
            new Nodo("Calle72"),
            new Nodo("Calle 76"),
            new Nodo("Heroes"),
            new Nodo("Escuela Militar"),
            new Nodo("Av.Boyaca")
        };

        Grafo grafo = new Grafo(nodos);

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < nodos.length - 1; i++) {
            for (int j = i + 1; j < nodos.length; j++) {
                System.out.print("Ingrese la distancia entre " + nodos[i].getNombre() + " y " + nodos[j].getNombre() + ": ");
                int distancia = scanner.nextInt();
                grafo.agregarArco(i, j, distancia);
            }
        }

        System.out.print("Ingrese el índice de la estación de inicio (entre 0 y " + (nodos.length - 1) + "): ");
        int inicio = scanner.nextInt();

        System.out.print("Ingrese el índice de la estación de destino (entre 0 y " + (nodos.length - 1) + "): ");
        int fin = scanner.nextInt();

        List<Nodo> ruta = grafo.encontrarRutaMasCorta(inicio, fin);

        System.out.print("La ruta más corta desde " + nodos[inicio].getNombre() + " hasta " + nodos[fin].getNombre() + " es: ");
        for (int i = 0; i < ruta.size(); i++) {
            System.out.print(ruta.get(i).getNombre());
            if (i != ruta.size() - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println(" con un tiempo total de " + ruta.get(ruta.size() - 1).getDistancia() + " minutos.");
    }
}