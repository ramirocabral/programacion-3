package parciales;

import grafos.*;
import listaGenerica.*;


public class Parcial1 {
    public int resolver(Grafo<Ciudad1> ciudades, String origen, String destino, int maxControles){
        if (ciudades == null || ciudades.esVacio())
            return 0;
        ListaGenerica<Vertice<Ciudad1>> vertices = ciudades.listaDeVertices();
        vertices.comenzar();
        boolean[] visistados = new boolean[vertices.tamanio()];
        Vertice<Ciudad1> vIni = null;
        Vertice<Ciudad1> vFin = null;
        while (!vertices.fin()){
            Vertice<Ciudad1> vAux = vertices.proximo();
            if (vAux.dato().getNombre().equals(origen))
                vIni = vAux;
            if (vAux.dato().getNombre().equals(destino))
                vFin = vAux;
        }
        if (vIni == null || vFin == null)
            return 0;
        ListaGenerica<Vertice<Ciudad1>> l = new ListaGenericaEnlazada<Vertice<Ciudad1>>();
        return resolver(ciudades,visistados,vIni,vFin,maxControles);
    }

    private int resolver(Grafo<Ciudad1> ciudades, boolean[] visitados, Vertice<Ciudad1> vIni, Vertice<Ciudad1> vFin, int maxControles){
        if (vIni.dato().getNombre().equals(vFin.dato().getNombre()))
            return vIni.dato().getDias();
        visitados[vIni.posicion()] = true;
        ListaGenerica<Arista<Ciudad1>> ady = ciudades.listaDeAdyacentes(vIni);
        ady.comenzar();
        int max = -1;
        while (!ady.fin()){
            Arista<Ciudad1> a = ady.proximo();
            Vertice<Ciudad1> vAux = a.verticeDestino();
            if (!visitados[vAux.posicion()] && a.peso() <= maxControles){
                int dias = resolver(ciudades,visitados,vAux,vFin,maxControles);
                if (dias != -1 && dias>max){
                    max = dias;
                }
                    
            }
        }
        visitados[vIni.posicion()] = false;
        if (max != -1)
            return max + vIni.dato().getDias();
        else
            return max;
    }

}
