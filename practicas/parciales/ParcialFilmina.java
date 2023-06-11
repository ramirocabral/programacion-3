package parciales;

import grafos.*;
import listaGenerica.*;

public class ParcialFilmina {
    public ListaGenerica<ListaGenerica<String>> resolver(Grafo<String> grafo){
        ListaGenerica<ListaGenerica<String>> res = new ListaGenericaEnlazada<ListaGenerica<String>>();
        if (grafo != null && !grafo.esVacio()){
            ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
            boolean[] visitados = new boolean[vertices.tamanio()];
            vertices.comenzar();
            ListaGenerica<String> caminoAct = new ListaGenericaEnlazada<String>();
            for (int i=0; i< vertices.tamanio(); i++){
                Vertice<String> vIni = vertices.elemento(i);
                resolver(grafo,visitados,vIni,res,caminoAct,0);
            }
        }
        return res;
    }

    private void resolver(Grafo<String> grafo,boolean[] visitados,Vertice<String> vIni,ListaGenerica<ListaGenerica<String>> res,ListaGenerica<String> caminoAct,int costoAct){
        visitados[vIni.posicion()] = true;
        caminoAct.agregarFinal(vIni.dato());
        if (costoAct == 10){
            res.agregarFinal(clonar(caminoAct));
        }
        else{
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vIni);
            ady.comenzar();
            while (!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> vAux = arista.verticeDestino();
                if (!visitados[vAux.posicion()] && costoAct + arista.peso() <= 10){
                    resolver(grafo,visitados,vAux,res,caminoAct,costoAct + arista.peso());
                }
            }
        }
        visitados[vIni.posicion()] = false;
        caminoAct.eliminarEn(caminoAct.tamanio() - 1);
    }

    private ListaGenerica<String> clonar (ListaGenerica<String> lista){
        ListaGenerica<String> res = new ListaGenericaEnlazada<String>();
        if (lista != null){
            lista.comenzar();
            while (!lista.fin()){
                res.agregarFinal(lista.proximo());
            }
        }
        return res;
    }
}
