package practica7.b.ej4;

import grafos.*;
import grafos.util.*;

public class FloydTest {
    public static void main(String[] args){
        //grafo imagen
        Grafo<String>grafo= new GrafoImplListAdy<String>();
    
        Vertice<String> v0 = new VerticeImplListAdy<String>("0");
        Vertice<String> v1 = new VerticeImplListAdy<String>("1");
        Vertice<String> v2 = new VerticeImplListAdy<String>("2");
        Vertice<String> v3 = new VerticeImplListAdy<String>("3");
        Vertice<String> v4 = new VerticeImplListAdy<String>("4");
    
        grafo.agregarVertice(v0);
        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);

        grafo.conectar(v0,v2,1);
        grafo.conectar(v1,v2,2);
        grafo.conectar(v1,v3,4);
        grafo.conectar(v1,v0,3);
        grafo.conectar(v2,v3,7);
        grafo.conectar(v2,v4,4);
        grafo.conectar(v3,v4,3);
        grafo.conectar(v3,v0,1);
        grafo.conectar(v4,v1,2);
        grafo.conectar(v4,v3,2);
        grafo.conectar(v4,v0,6);

        Floyd george = new Floyd();

        CostoFloyd[][] matriz = george.floyd(grafo);

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                    System.out.print(matriz[i][j].getCosto() + "|" + matriz[i][j].getVertPrev().dato() + " -- ");
            }
            System.out.println();
        }
    }

}
