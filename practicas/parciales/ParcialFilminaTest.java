package parciales;

import grafos.*;
import listaGenerica.*;

public class ParcialFilminaTest {
    public static void main(String[] args){
        Grafo<String> grafo = new GrafoImplListAdy<>();
        Vertice<String> v1 = new VerticeImplListAdy<>("Buenos Aires");
        Vertice<String> v2 = new VerticeImplListAdy<>("Santiago");
        Vertice<String> v3 = new VerticeImplListAdy<>("Montevideo");
        Vertice<String> v4 = new VerticeImplListAdy<>("Lima");
        Vertice<String> v5 = new VerticeImplListAdy<>("Asuncion");
        Vertice<String> v6 = new VerticeImplListAdy<>("La Habana");
        Vertice<String> v7 = new VerticeImplListAdy<>("Caracas");

        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);
        grafo.agregarVertice(v6);
        grafo.agregarVertice(v7);

        grafo.conectar(v1,v2,3);
        grafo.conectar(v1,v5,10);
        grafo.conectar(v1,v3,4);
        grafo.conectar(v1,v4,2);
        grafo.conectar(v2,v6,4);
        grafo.conectar(v2,v5,500);
        grafo.conectar(v3,v5,6);
        grafo.conectar(v4,v5,4);
        grafo.conectar(v7,v5,11);
        grafo.conectar(v7,v6,10);

        ParcialFilmina pf = new ParcialFilmina();
        ListaGenerica<ListaGenerica<String>> res = pf.resolver(grafo);
        res.comenzar();
        while (!res.fin()){
            ListaGenerica<String> camino = res.proximo();
            System.out.println(camino);
        }
    }
}
