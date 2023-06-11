package parciales;

import grafos.*;
import listaGenerica.*;

public class BuscadorDeCaminosTest {
    public static void main(String[] args){
        Grafo<String> bosque = new GrafoImplListAdy<String>();
        Vertice<String> v0 = new VerticeImplListAdy<String>("Casa Caperucita");
        Vertice<String> v1 = new VerticeImplListAdy<String>("Claro 1");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Claro 2");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Claro 3");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Claro 4");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Claro 5");
        Vertice<String> v6 = new VerticeImplListAdy<String>("Casa Abuelita");
    
        bosque.agregarVertice(v0);
        bosque.agregarVertice(v1);
        bosque.agregarVertice(v2);
        bosque.agregarVertice(v3);
        bosque.agregarVertice(v4);
        bosque.agregarVertice(v5);
        bosque.agregarVertice(v6);
    
        bosque.conectar(v0,v3,4);
        bosque.conectar(v0,v1,3);
        bosque.conectar(v0,v2,4);
        bosque.conectar(v3,v5,15);
        bosque.conectar(v1,v5,3);
        bosque.conectar(v2,v1,4);
        bosque.conectar(v2,v5,11);
        bosque.conectar(v2,v4,10);
        bosque.conectar(v4,v6,9);
        bosque.conectar(v5,v6,4);

        BuscadorDeCaminos buscador = new BuscadorDeCaminos();
        ListaGenerica<ListaGenerica<String>> res = buscador.recorridosMasSeguros(bosque);
        res.comenzar();
        while(!res.fin()){
            ListaGenerica<String> camino = res.proximo();
            System.out.println(camino);
        }

    }

}
