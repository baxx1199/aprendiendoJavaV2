/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Grafo {
    private Nodo[] nodos;
    private int[][] matrizAdyacencia;

    public Grafo(Nodo[] nodos) {
        this.nodos = nodos;
        this.matrizAdyacencia = new int[nodos.length][nodos.length];
    }

   

    public void agregarArco(int origen, int destino, int distancia) {
        matrizAdyacencia[origen][destino] = distancia;
        matrizAdyacencia[destino][origen] = distancia;
    }

    public List<Nodo> encontrarRutaMasCorta(int inicio, int fin) {
        int[] distancias = new int[nodos.length];
        boolean[] visitados = new boolean[nodos.length];
        int[] padres = new int[nodos.length];

        for (int i = 0; i < nodos.length; i++) {
            distancias[i] = Integer.MAX_VALUE;
            visitados[i] = false;
            padres[i] = -1;
        }

        distancias[inicio] = 0;

        for (int i = 0; i < nodos.length - 1; i++) {
            int u = encontrarNodoNoVisitadoConDistanciaMinima(distancias, visitados);
            visitados[u] = true;

            for (int v = 0; v < nodos.length; v++) {
                if (matrizAdyacencia[u][v] != 0 && !visitados[v] && distancias[u] != Integer.MAX_VALUE && distancias[u] + matrizAdyacencia[u][v] < distancias[v]) {
                    distancias[v] = distancias[u] + matrizAdyacencia[u][v];
                    padres[v] = u;
                }
            }
        }

        List<Nodo> ruta = new ArrayList<>();
        int actual = fin;
        while (actual != -1) {
            ruta.add(nodos[actual]);
            actual = padres[actual];
        }
        Collections.reverse(ruta);

        ruta.get(ruta.size() - 1).setDistancia(distancias[fin]);

        return ruta;
    }

    private int encontrarNodoNoVisitadoConDistanciaMinima(int[] distancias, boolean[] visitados) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < nodos.length; i++) {
            if (!visitados[i] && distancias[i] <= min) {
                min = distancias[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
