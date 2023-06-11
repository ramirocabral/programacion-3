package parciales;

import grafos.*;
import listaGenerica.*;

public class ParcialBFSTest {
    public static void main(String[] args){
        Grafo<Persona> grafo = new GrafoImplListAdy<Persona>();
        Vertice<Persona> e1 = new VerticeImplListAdy<Persona>(new Persona(true, " ", "1"));
        Vertice<Persona> e2 = new VerticeImplListAdy<Persona>(new Persona(true, " ", "2"));
        Vertice<Persona> e3 = new VerticeImplListAdy<Persona>(new Persona(true, " ", "3"));
        
        Vertice<Persona> v4 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "4"));
        Vertice<Persona> v5 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "5"));
        Vertice<Persona> v6 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "6"));
        Vertice<Persona> v7 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "7"));
        Vertice<Persona> v8 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "8"));
        Vertice<Persona> v9 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "9"));
        Vertice<Persona> v10 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "10"));
        Vertice<Persona> v11 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "11"));
        Vertice<Persona> v12 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "12"));
        Vertice<Persona> v13 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "13"));
        Vertice<Persona> v14 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "14"));
        Vertice<Persona> v15 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "15"));
        Vertice<Persona> v16 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "16"));
        Vertice<Persona> v17 = new VerticeImplListAdy<Persona>(new Persona(false, " ", "17"));

        grafo.agregarVertice(e1);
        grafo.agregarVertice(e2);
        grafo.agregarVertice(e3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);
        grafo.agregarVertice(v6);
        grafo.agregarVertice(v7);
        grafo.agregarVertice(v8);
        grafo.agregarVertice(v9);
        grafo.agregarVertice(v10);
        grafo.agregarVertice(v11);
        grafo.agregarVertice(v12);
        grafo.agregarVertice(v13);
        grafo.agregarVertice(v14);
        grafo.agregarVertice(v15);
        grafo.agregarVertice(v16);
        grafo.agregarVertice(v17);

        grafo.conectar(e1,e2,0);
        grafo.conectar(e1,e3,0);
        grafo.conectar(e2,v14,0);
        grafo.conectar(e2,v15,0);
        grafo.conectar(e3,v16,0);
        grafo.conectar(e3,v17,0);
        grafo.conectar(e1,v4,0);
        grafo.conectar(e1,v7,0);
        grafo.conectar(e1,v9,0);
        grafo.conectar(e1,v10,0);
        grafo.conectar(e1,v11,0);
        grafo.conectar(v4,v5,0);
        grafo.conectar(v4,v6,0);
        grafo.conectar(v7,v8,0);
        grafo.conectar(v11,v12,0);
        grafo.conectar(v11,v13,0);

        ParcialBFS parcial = new ParcialBFS();
        ListaGenerica<Persona> res = parcial.bfs(grafo, 0);

        System.out.println(res.tamanio());

    }
}
