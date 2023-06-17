package parciales;

import grafos.*;
import listaGenerica.*;

public class Parcial2GH{
    public Parcial2GHResultado resolver(Grafo<String> ciudades,String origen, String destino, ListaGenerica<String> pasandoPor){
        Parcial2GHResultado res = new Parcial2GHResultado();
        if (ciudades != null && !ciudades.esVacio()){
            ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
            vertices.comenzar();
            boolean[] visitados = new boolean[vertices.tamanio()];
            Vertice<String> vIni = null;
            Vertice<String> vFin = null;
            while (!vertices.fin()){
                Vertice<String> v = vertices.proximo();
                if (v.dato().equals(origen))
                    vIni = v;
                if (v.dato().equals(destino))
                    vFin = v;
            }
            if (vIni != null & vFin!=null){
                Parcial2GHResultado caminoAct = new Parcial2GHResultado();
                resolver(ciudades,visitados,vIni,vFin,res,caminoAct,pasandoPor);
            }
        }
        return res;
    }

    private void resolver(Grafo<String> ciudades,boolean[] visitados,Vertice<String> vIni,Vertice<String> vFin,Parcial2GHResultado res,Parcial2GHResultado caminoAct,ListaGenerica<String> pasandoPor){
        visitados[vIni.posicion()] = true;
        caminoAct.getCamino().agregarFinal(vIni.dato());
        if(vIni.dato().equals(vFin.dato())){
            if ( res.getCamino().esVacia() || res.getEvaluados() < caminoAct.getEvaluados())
            res.setCamino(clonar(caminoAct.getCamino()));
            res.setEvaluados(caminoAct.getEvaluados());
        }
        else{

            ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(vIni);
            ady.comenzar();
            while (!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> vAux = arista.verticeDestino();
                if (!visitados[vAux.posicion()]){
                    if (pasandoPor.incluye(vAux.dato())){
                        caminoAct.setEvaluados(caminoAct.getEvaluados()+1);
                        resolver(ciudades,visitados,vAux,vFin,res,caminoAct,pasandoPor);
                        caminoAct.setEvaluados(caminoAct.getEvaluados()-1);
                    }
                    else{
                        resolver(ciudades,visitados,vAux,vFin,res,caminoAct,pasandoPor);
                    }
                }
            }
        }
        visitados[vIni.posicion()] = false;
        caminoAct.getCamino().eliminarEn(caminoAct.getCamino().tamanio()-1);
    }

    private ListaGenerica<String> clonar(ListaGenerica<String> l){
        ListaGenerica<String> aux = new ListaGenericaEnlazada<String>();
        l.comenzar();
        while(!l.fin()){
            aux.agregarFinal(l.proximo());
        }
        return aux;
    }
}