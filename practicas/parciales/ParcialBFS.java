package parciales;

import grafos.*;
import listaGenerica.*;

public class ParcialBFS {
    public ListaGenerica<Persona> bfs(Grafo<Persona> grafo, int posOrigen){
        ListaGenerica<Vertice<Persona>> vertices = grafo.listaDeVertices();
        Vertice<Persona> vIni = vertices.elemento(posOrigen);
        if (grafo == null || grafo.esVacio() || vIni == null || !vIni.dato().esEmpleado()){
            return null;
        }
        ListaGenerica<Persona> res = new ListaGenericaEnlazada<Persona>();
        Cola<Vertice<Persona>> cola = new Cola<Vertice<Persona>>();
        boolean[] visitados = new boolean[vertices.tamanio()];
        cola.encolar(vIni);
        cola.encolar(null);
        int dist = 0;
        while (!cola.esVacia() && dist < 2){
            Vertice<Persona> vAct = cola.desencolar();
            if(vAct != null){
                ListaGenerica<Arista<Persona>> ady = grafo.listaDeAdyacentes(vAct);
                ady.comenzar();
                while (!ady.fin()){
                    Vertice<Persona> vAux = ady.proximo().verticeDestino();
                    if (!visitados[vAux.posicion()] && !vAux.dato().esEmpleado()){
                        cola.encolar(vAux);
                        visitados[vAux.posicion()] = true;
                        if (res.tamanio() < 40)
                            res.agregarFinal(vAux.dato());
                    }
                }
            }
            else if (!cola.esVacia()){
                cola.encolar(null);
                dist++;
            }
        }
        return res;
    }
}
