package grafos;

import listaGenerica.*;
import java.util.Arrays;

//copypaste gonza
public class GradosDeSeparacion {
    public int maximoGradoDeSeparacion(Grafo<String> grafo) {
        int len = grafo.listaDeVertices().tamanio();
        int max = -1, aux;
        for (int i = 0; i < len; i++) {
            aux = maximoGradoDeSeparacion(i, grafo);
            if(aux > max)
                max = aux;
        }
        return max;
    }

    private int maximoGradoDeSeparacion(int i, Grafo<String> grafo) {
        ListaGenerica<Arista<String>> ady = null;
        Cola<Vertice<String>> cola = new Cola<Vertice<String>>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        int[] distancias = new int[grafo.listaDeVertices().tamanio()];
        cola.encolar(grafo.listaDeVertices().elemento(i));
        marca[i] = true;
        while (!cola.esVacia()) {
            Vertice<String> V = cola.desencolar();
            ady = grafo.listaDeAdyacentes(V);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                int j = arista.verticeDestino().posicion();
                if (!marca[j]) {
                    marca[j] = true;
                    cola.encolar(arista.verticeDestino());
                    distancias[arista.verticeDestino().posicion()] = distancias[V.posicion()] + 1;
                }
            }
        }
        return Arrays.stream(distancias).max().getAsInt();
    }
    
}