package parciales;

import grafos.*;
import listaGenerica.*;

public class Parcial{
    public Resultado resolver(Grafo<String> ciudades, String origen, int maxMonto){
        Resultado res = new Resultado();
        res.setMontoRestante(maxMonto);
        if (ciudades != null && !ciudades.esVacio()){
            Vertice<String> vIni = null;
            ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
            boolean[] visitados = new boolean[vertices.tamanio()];
            vertices.comenzar();
            while (!vertices.fin()){
                Vertice<String> vAux = vertices.proximo();
                if (vAux.dato().equals(origen)){
                    vIni = vAux;
                    break;
                }
            }
            if (vIni != null){
                ListaGenerica<String> caminoAct = new ListaGenericaEnlazada<String>();
                resolver(ciudades,visitados,vIni,res,caminoAct,maxMonto);
            }
        }
        return res;
    }

    private void resolver(Grafo<String> ciudades,boolean[] visitados,Vertice<String> vIni,
    Resultado res, ListaGenerica<String> caminoAct, int montoAct){
        visitados[vIni.posicion()] = true;
        caminoAct.agregarFinal(vIni.dato());
        if (res.getCamino().esVacia() || res.getCamino().tamanio() < caminoAct.tamanio() || (res.getCamino().tamanio() == caminoAct.tamanio() && res.getMontoRestante() < montoAct)){
            res.setCamino(clonar(caminoAct));
            res.setMontoRestante(montoAct);
        }
        ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(vIni);
        ady.comenzar();
        while (!ady.fin()){
            Arista<String> arista = ady.proximo();
            Vertice <String> vAux = arista.verticeDestino();
            if (!visitados[vAux.posicion()] && (montoAct-arista.peso() >= 0)){
                resolver(ciudades,visitados,vAux,res,caminoAct,montoAct-arista.peso());
            }
        }
        caminoAct.eliminarEn(caminoAct.tamanio() - 1);
        visitados[vIni.posicion()] = false;
    }

    public ListaGenerica<String> clonar(ListaGenerica<String> l){
        ListaGenerica<String> aux = new ListaGenericaEnlazada<String>()
        l.comenzar();
        while (!l.fin()){
            aux.agregarFinal(l.proximo());
        }
        return aux;
    }
}