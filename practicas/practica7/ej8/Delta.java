package practica7.ej8;

import grafos.*;
import listaGenerica.*;

public class Delta {

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~A~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public int maxIslasDistintas(Grafo<String> grafo){
        boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
        visitados[0] = true;
        int max = -1;
        for (int i=0; i<visitados.length; i++) {
            Vertice<String> v = grafo.listaDeVertices().elemento(i);
            if (!visitados[i]){
                int act = maxIslasDistintas(grafo,v, visitados);
                if (act > max) max = act;
            }
        }
        return max;
    }

    private int maxIslasDistintas(Grafo<String> grafo, Vertice<String> v, boolean[] visitados){
        visitados[v.posicion()] = true;
        int cant = 1;

        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()){
            Vertice<String> vAux = ady.proximo().verticeDestino();
            if (!visitados[vAux.posicion()]) cant += maxIslasDistintas(grafo, vAux, visitados);
        }
        return cant;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~B~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public RutaMinima caminoMasCorto(Grafo<String> grafo, String islaO, String islaD){
        boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
        RutaMinima res = new RutaMinima();
        RutaMinima aux = new RutaMinima();
        aux.setNuevo(false);
        Vertice<String> vInicial = null;
        Vertice<String> vFinal = null;
        if (grafo != null && !grafo.esVacio()){
            ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
            vertices.comenzar();
            while (!vertices.fin()){
                Vertice<String> vAux = vertices.proximo();
                if (vAux.dato().equals(islaO)) vInicial = vAux;
                if (vAux.dato().equals(islaD)) vFinal = vAux;
            }
            if (vInicial != null && vFinal != null){
                //caminoMasCorto(grafo, visitados, vInicial, vFinal, res, aux);
            }
        }
        return res;
    }

    //usar dijkstra
}
