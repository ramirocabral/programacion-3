package practica7.a.ej9;

import grafos.*;
import listaGenerica.*;


public class GuiaDeTurismo {
    public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo,String puntoInteresOrigen,String puntoInteresDestino){
        if (grafo == null || grafo.esVacio()) {
            return null;
        }
        ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
        boolean[] visitados = new boolean[vertices.tamanio()];
        Camino aux = new Camino();
        Camino res = new Camino();
        Vertice<String> vInicial = null;
        Vertice<String> vFinal = null;
        for (int i = 0; i < vertices.tamanio(); i++) {
            if (vertices.elemento(i).dato().equals(puntoInteresOrigen)) vInicial = vertices.elemento(i);
            if (vertices.elemento(i).dato().equals(puntoInteresDestino)) vFinal = vertices.elemento(i);
        }
        if (vInicial != null && vFinal != null){
            caminoConMenorNrodeViajes(grafo, vInicial, vFinal, visitados, aux, res);
        }
        return res.getCamino();
    }

    private void caminoConMenorNrodeViajes(Grafo<String> grafo, Vertice<String> vInicial,Vertice<String> vFinal,boolean[] visitados,Camino aux,Camino res){
        visitados[vInicial.posicion()] = true;
        aux.getCamino().agregarFinal(vInicial.dato());
        if (vInicial == vFinal){
            if (res.getCamino().esVacia() || aux.getCostoMin() > res.getCostoMin()){
                res.setCostoMin(aux.getCostoMin());
                copiarLista(aux.getCamino(), res.getCamino());
            }
        }
        else{
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vInicial);
            ady.comenzar();
            while (!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> vAux = arista.verticeDestino();
                if (!visitados[vAux.posicion()]){
                    if (arista.peso() < aux.getCostoMin()){
                        int act = aux.getCostoMin();
                        aux.setCostoMin(arista.peso());
                        caminoConMenorNrodeViajes(grafo, vAux, vFinal, visitados, aux, res);
                        aux.setCostoMin(act);
                    }
                    else
                        caminoConMenorNrodeViajes(grafo, vAux, vFinal, visitados, aux, res);
                }
            }
        }
        visitados[vInicial.posicion()] = false;
        aux.getCamino().eliminarEn(aux.getCamino().tamanio()-1);
    }

    private void copiarLista(ListaGenerica<String> caminoAct, ListaGenerica<String> camino){
        while (!camino.esVacia())
            camino.eliminarEn(0);
        caminoAct.comenzar();
        while (!caminoAct.fin())
            camino.agregarFinal(caminoAct.proximo());
    }
}
