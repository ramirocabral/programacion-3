package parciales;

import grafos.*;
import listaGenerica.*;

public class BuscadorDeCaminos {
    public ListaGenerica<ListaGenerica<String>> recorridosMasSeguros (Grafo<String> bosque){
        ListaGenerica<ListaGenerica<String>> res = new ListaGenericaEnlazada<ListaGenerica<String>>();
        boolean[] visitados = new boolean[bosque.listaDeVertices().tamanio()];
        if(bosque != null && !bosque.esVacio()){
            ListaGenerica<Vertice<String>> vertices = bosque.listaDeVertices();
            vertices.comenzar();
            Vertice<String> vIni = vertices.proximo();
            while(!vertices.fin()){
                Vertice<String> vAux = vertices.proximo();
                if (vAux.dato().equals("Casa Caperucita")){
                    vIni = vAux;
                    break;
                }
            }
            if (vIni != null){
                ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
                recorridosMasSeguros(bosque,visitados,vIni,res,camino);
            }
        }
        return res;
    }

    private void recorridosMasSeguros(Grafo<String> bosque, boolean[] visitados,Vertice<String> vIni,ListaGenerica<ListaGenerica<String>> res, ListaGenerica<String> caminoAct){
        visitados[vIni.posicion()] = true;
        caminoAct.agregarFinal(vIni.dato());
        if (vIni.dato().equals("Casa Abuelita")){
            res.agregarFinal(clonar(caminoAct));
        }
        else{
            ListaGenerica<Arista<String>> adyacentes = bosque.listaDeAdyacentes(vIni);
            adyacentes.comenzar();
            while (!adyacentes.fin()){
                Arista<String> arista = adyacentes.proximo();
                Vertice<String> vAux = arista.verticeDestino();
                if ((!visitados[vAux.posicion()]) && (arista.peso() < 5)){
                    recorridosMasSeguros(bosque,visitados,vAux,res,caminoAct);
                }
            }
        }
        caminoAct.eliminarEn(caminoAct.tamanio()-1);
        visitados[vIni.posicion()] = false;        
}

    private ListaGenerica<String> clonar(ListaGenerica<String> l){
        ListaGenerica<String> res = new ListaGenericaEnlazada<String>();
        l.comenzar();
        while(!l.fin()){
            res.agregarFinal(l.proximo());
        }
        return res;
    }

}