package grafos.util;

import grafos.Arista;
import grafos.Grafo;
import grafos.Vertice;
import listaGenerica.*;

public class OrdenTopologico<T>{

    public ListaGenerica<Vertice<T>> ordenTopologico(Grafo<T> grafo){
        Pila<Vertice<T>> pila = new Pila<Vertice<T>>();
        boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i=0; i<grafo.listaDeVertices().tamanio(); i++){
            Vertice<T> vAct = grafo.listaDeVertices().elemento(i);
            if (!visitados[i])
                this.ordenTopologico(vAct,grafo,pila,visitados);
        }
        ListaGenerica<Vertice<T>> l = new ListaGenericaEnlazada<>();
        while (!pila.esVacia()){
            l.agregarFinal(pila.desapilar());
        }
        return l;
    }

    private void ordenTopologico(Vertice<T> v,Grafo<T> grafo,Pila<Vertice<T>> pila,boolean[] visitados){
        visitados[v.posicion()] = true;
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()){
            Arista<T> arista = ady.proximo();
            if (!visitados[arista.verticeDestino().posicion()]){
                ordenTopologico(arista.verticeDestino(), grafo, pila, visitados);
            }
        }
        pila.apilar(v);
    }
    
}
