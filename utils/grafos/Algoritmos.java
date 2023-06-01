package grafos;

import listaGenerica.ListaGenerica;
import listaGenerica.ListaGenericaEnlazada;

public class Algoritmos<T> {

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~A~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public boolean subgrafoCuadrado(Grafo<T> grafo){
        ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
        boolean[] eval = new boolean[vertices.tamanio()];
        for (int i=0; i<vertices.tamanio();i++){
            eval[i] = true;
            boolean[] visitados = new boolean[vertices.tamanio()];
            if (subgrafoCuadrado(grafo,vertices.elemento(i),visitados,eval) == 4)
                return true;
        }
        return false;
    }

    private int subgrafoCuadrado(Grafo<T> grafo, Vertice<T> v, boolean[] visitados, boolean[] eval){
        visitados[v.posicion()] = true;
        int arcos = 0;

        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();

        while (!ady.fin()){
            Vertice<T> aux = ady.proximo().verticeDestino();
            if (!visitados[aux.posicion()]){
                arcos += subgrafoCuadrado(grafo, aux, visitados, eval);
                if (arcos > 0)
                    return arcos+1;
            }
            else if (eval[aux.posicion()])
                return 1;
        }
        return arcos;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~B~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public int getGrado(Grafo<T> grafo){
        ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
        int[] grados = new int[vertices.tamanio()];
        System.out.println(grados.length);
        for (int i=0; i<vertices.tamanio(); i++){
            Vertice<T> vAux = vertices.elemento(i);
            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(vAux);
            grados[i] += ady.tamanio();
            for(int j=0; j<ady.tamanio(); j++)
                grados[ady.elemento(j).verticeDestino().posicion()]+=1;
        }
        return getMax(grados);
    }

    private int getMax(int[] arr){
        int max=-1;
        for (int i=0; i<arr.length;i++){
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~C~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//medio ilegal pero funciona
public boolean tieneCiclo(Grafo<T> grafo){
    ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
    boolean[] eval = new boolean[vertices.tamanio()];
    for (int i=0; i<vertices.tamanio();i++){
        eval[i] = true;
        boolean[] visitados = new boolean[vertices.tamanio()];
        if (tieneCiclo(grafo,vertices.elemento(i),visitados,eval) != 0)
            return true;
    }
    return false;
}

private int tieneCiclo(Grafo<T> grafo, Vertice<T> v, boolean[] visitados, boolean[] eval){
    visitados[v.posicion()] = true;
    int arcos = 0;

    ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();

    while (!ady.fin()){
        Vertice<T> aux = ady.proximo().verticeDestino();
        if (!visitados[aux.posicion()]){
            arcos += subgrafoCuadrado(grafo, aux, visitados, eval);
            if (arcos > 0)
                return arcos+1;
        }
        else if (eval[aux.posicion()])
            return 1;
    }
    return arcos;
}
}
