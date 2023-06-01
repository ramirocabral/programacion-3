package practica7.ej7;

import grafos.*;

public class AlgoritmosTest {
    public static void main(String[] args) {
        Vertice<Integer> v1 = new VerticeImplListAdy<Integer>(1);
        Vertice<Integer> v2 = new VerticeImplListAdy<Integer>(2);
        Vertice<Integer> v3 = new VerticeImplListAdy<Integer>(3);
        Vertice<Integer> v4 = new VerticeImplListAdy<Integer>(4);
        Vertice<Integer> v5 = new VerticeImplListAdy<Integer>(5);
        Vertice<Integer> v6 = new VerticeImplListAdy<Integer>(6);
        Grafo<Integer> g = new GrafoImplListAdy<Integer>();
        g.agregarVertice(v1);
        g.agregarVertice(v2);
        g.agregarVertice(v3);
        g.agregarVertice(v4);
        g.agregarVertice(v5);
        g.agregarVertice(v6);
        g.conectar(v1, v2, 0);
        g.conectar(v2, v3, 0);
        g.conectar(v3, v4, 0);
        g.conectar(v4, v5, 0);
        g.conectar(v5, v2, 0);
        g.conectar(v5, v6, 0);
        g.conectar(v6, v1, 0);
        Algoritmos<Integer> aux = new Algoritmos<>();
        //System.out.println("El grafo contiene un subgrafo cuadrado: " + aux.subgrafoCuadrado(g));
        //System.out.println("grado del grafo: " + aux.getGrado(g));
        System.out.println("tiene ciclo: " + aux.tieneCiclo(g));
    }
}