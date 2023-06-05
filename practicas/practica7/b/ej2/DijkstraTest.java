package practica7.b.ej2;

import grafos.*;
import grafos.util.*;

public class DijkstraTest {
    public static void main(String[] args){
        //grafo filmina teoria
        Grafo<String> grafo = new GrafoImplListAdy<String>();

        Vertice<String> v1 = new VerticeImplListAdy<String>("1");
        Vertice<String> v2 = new VerticeImplListAdy<String>("2");
        Vertice<String> v3 = new VerticeImplListAdy<String>("3");
        Vertice<String> v4 = new VerticeImplListAdy<String>("4");
        Vertice<String> v5 = new VerticeImplListAdy<String>("5");
        Vertice<String> v6 = new VerticeImplListAdy<String>("6");

        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);
        grafo.agregarVertice(v6);

        grafo.conectar(v1,v3,40);
        grafo.conectar(v1,v5,10);
        grafo.conectar(v1,v6,5);
        grafo.conectar(v2,v4,5);
        grafo.conectar(v3,v2,10);
        grafo.conectar(v3,v5,5);
        grafo.conectar(v4,v3,5);
        grafo.conectar(v5,v4,20);
        grafo.conectar(v6,v2,20);
        grafo.conectar(v6,v5,10);

        Dijkstra d = new Dijkstra();

        Costo[] aux = d.dijkstraSinHeap(grafo, v1);

        for (int i=0; i< aux.length; i++){
            if (aux[i].getVerticeAnt() !=  null)
                System.out.println(i+1 + " :     dist: " + aux[i].getCostoMin() + " previo: " + aux[i].getVerticeAnt().dato());
        }

        /*  
        *   2 :     dist: 25 previo: 6
        *   3 :     dist: 35 previo: 4
        *   4 :     dist: 30 previo: 5
        *   5 :     dist: 10 previo: 1
        *   6 :     dist: 5  previo: 1
        */

        Costo[] aux2 = d.dijkstraConHeap(grafo, v1);

        for (int i=0; i< aux2.length; i++){
            if (aux2[i].getVerticeAnt() !=  null)
                System.out.println(i+1 + " :     dist: " + aux2[i].getCostoMin() + " previo: " + aux2[i].getVerticeAnt().dato());
        }
        
    }
}
