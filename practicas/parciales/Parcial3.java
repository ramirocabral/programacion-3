package parciales;

import grafos.*;
import listaGenerica.*;

public class Parcial3{
    public int[] resolver(Grafo<Ciudad> ciudades,String origen, String destino){
        int[] fases = new int[5];
        if (ciudades != null && !ciudades.esVacio()){
            ListaGenerica<Vertice<Ciudad>> vertices = ciudades.listaDeVertices();
            vertices.comenzar();
            Vertice<Ciudad> vIni = null;
            Vertice<Ciudad> vFin = null;
            while (!vertices.fin()){
                Vertice<Ciudad> vAux = vertices.proximo();
                if (vAux.dato().getNombre().equals(origen)) vIni = vAux;
                if (vAux.dato().getNombre().equals(destino)) vFin = vAux;
            }
            if (vIni != null && vFin != null){
                boolean[] visitados = new boolean[vertices.tamanio()];
                ListaGenerica<Vertice<Ciudad>> aux = new ListaGenericaEnlazada<Vertice<Ciudad>>();
                resolver(ciudades,visitados,vIni,vFin,aux,fases);
            }
        }
        return fases;
    }

    private boolean resolver(Grafo<Ciudad> ciudades,boolean[] visitados,Vertice<Ciudad> vIni, Vertice<Ciudad> vFin, ListaGenerica<Vertice<Ciudad>> l, int[] fases){
        if (vIni.dato().equals(vFin.dato())){
            if (!l.incluye(vIni)){
                l.agregarFinal(vIni);
                fases[vIni.dato().getFase()-1]++;
            }
            return true;
        }
        visitados[vIni.posicion()] = true;
        ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(vIni);
        ady.comenzar();
        boolean flag = false;
        while (!ady.fin()){
            Arista<Ciudad> arista = ady.proximo();
            Vertice<Ciudad> vAux = arista.verticeDestino();
            if (!visitados[vAux.posicion()] && arista.peso() != 0){
                if (resolver(ciudades,visitados,vAux,vFin,l,fases)){
                    if (!l.incluye(vIni)){
                        l.agregarFinal(vIni);
                        fases[vIni.dato().getFase()-1]++;
                    }
                    flag = true;
                }
            }   
        }
        visitados[vIni.posicion()] = false;
        return flag;
    }
}