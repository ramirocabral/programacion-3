package practica7.b.ej1;

import grafos.*;
import grafos.util.OrdenTopologico;
import listaGenerica.ListaGenerica;

public class OrdenTopologicoTest {
    public static void main(String[] args){
        Grafo<String> grafo = new GrafoImplListAdy<>();

        Vertice<String> v1 = new VerticeImplListAdy<String>("boxer");
        Vertice<String> v2 = new VerticeImplListAdy<String>("pantalones");
        Vertice<String> v3 = new VerticeImplListAdy<String>("cinturon");
        Vertice<String> v4 = new VerticeImplListAdy<String>("medias");
        Vertice<String> v5 = new VerticeImplListAdy<String>("zapatos");
        Vertice<String> v6 = new VerticeImplListAdy<String>("camisa");
        Vertice<String> v7 = new VerticeImplListAdy<String>("corbata");
        Vertice<String> v8 = new VerticeImplListAdy<String>("saco");
        Vertice<String> v9 = new VerticeImplListAdy<String>("reloj");

        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);
        grafo.agregarVertice(v6);
        grafo.agregarVertice(v7);
        grafo.agregarVertice(v8);
        grafo.agregarVertice(v9);

        grafo.conectar(v1,v2,0);  //boxer -> pantalones
        grafo.conectar(v1,v5,0);  //boxer -> zapatos
        grafo.conectar(v2,v5,0);  //pantalones -> zapatos
        grafo.conectar(v2,v3,0);  //pantalones -> cinturon    
        grafo.conectar(v3,v7,0);  //cinturon -> corbata
        grafo.conectar(v6,v3,0);  //camisa -> cinturon
        grafo.conectar(v6,v7,0);  //camisa -> corbata
        grafo.conectar(v7,v8,0);  //corbata -> saco
        grafo.conectar(v4,v5,0);  //medias -> zapatos

        OrdenTopologico<String> orden = new OrdenTopologico<>();

        ListaGenerica<Vertice<String>> l = orden.ordenTopologico(grafo);

        System.out.println("Orden topologico: " + l.toString());

        //Orden topologico: reloj -> camisa -> medias -> boxer -> pantalones -> cinturon -> corbata -> saco -> zapatos

    }
}
