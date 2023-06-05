package grafos.util;

import listaGenerica.*;
import grafos.Arista;
import grafos.Grafo;
import grafos.Vertice;
import java.util.PriorityQueue;

public class Dijkstra {

    /* implementacion de dijkstra usando un arreglo normal
     * no uso tipo generico porque java es gay y no me deja
     */
    public Costo[] dijkstraSinHeap(Grafo<String> grafo, Vertice<String> v){
        if (grafo.esVacio() || !grafo.listaDeVertices().incluye(v)){
            System.out.println("wut");
            return null;        
        }
        Costo[] costos = new Costo[grafo.listaDeVertices().tamanio()];
        boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
        //inicializamos el arreglo de costos, no se si se inicializa solo
        for (int i=0; i<costos.length; i++){        
            costos[i] = new Costo();
        }
        //posicion inicial en 0
        costos[v.posicion()].setCostoMin(0);
        for (int i=0; i<grafo.listaDeVertices().tamanio();i++){
            Vertice<String> vAux = minimoCosto(grafo,costos, visitados);
            visitados[vAux.posicion()] = true;
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vAux);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> vDestino = arista.verticeDestino();
                if (!visitados[vDestino.posicion()]){
                    int costoAct = costos[vAux.posicion()].getCostoMin() + arista.peso();
                    //swap si el costoAct es menor al actual
                    if (costoAct < costos[vDestino.posicion()].getCostoMin()){
                        costos[vDestino.posicion()].setCostoMin(costoAct);
                        costos[vDestino.posicion()].setVerticeAnt(vAux);
                    }
                }
            }
        }
        return costos;
    }

    /* retorna la posicion del vertice no visitado con el menor costoAct */
    private Vertice<String> minimoCosto(Grafo<String> grafo,Costo[] costos, boolean[] visitados){
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for (int i=0; i<costos.length; i++){
            if (!visitados[i] && costos[i].getCostoMin() < min){
                min = costos[i].getCostoMin();
                pos = i;
            }
        }
        return grafo.listaDeVertices().elemento(pos);
    }



    /* --------------------------------------------------------------------------------*/



    public Costo[] dijkstraConHeap(Grafo<String> grafo, Vertice<String> v){
        if (grafo.esVacio() || !grafo.listaDeVertices().incluye(v)){
            return null;        
        }
        Costo[] costos = new Costo[grafo.listaDeVertices().tamanio()];
        boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
        //inicializamos el arreglo de costos, no se si se inicializa solo
        for (int i=0; i<costos.length; i++){        
            costos[i] = new Costo();
        }
        //posicion inicial en 0
        costos[v.posicion()].setCostoMin(0);
        PriorityQueue<CostoHeap<String>> heap = new PriorityQueue<CostoHeap<String>>();
        heap.offer(new CostoHeap<String>(v.posicion(),0));

        while(!heap.isEmpty()){
            Vertice<String> vAux = grafo.listaDeVertices().elemento(heap.poll().getPos());
            if (visitados[vAux.posicion()]) continue;
            visitados[vAux.posicion()] = true;
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vAux);
            ady.comenzar();
            while (!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> vDestino = arista.verticeDestino();
                if (!visitados[vDestino.posicion()]){
                    int costoAct = costos[vAux.posicion()].getCostoMin() + arista.peso();
                    //swap si el costoAct es menor al actual
                    if (costoAct < costos[vDestino.posicion()].getCostoMin()){
                        costos[vDestino.posicion()].setCostoMin(costoAct);
                        costos[vDestino.posicion()].setVerticeAnt(vAux);
                        heap.offer(new CostoHeap<String>(vDestino.posicion(),costoAct));
                    }
                }
            }
        }
        return costos;
    }

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


    public CostoMinimos[] dijkstraTodosMinimos(Grafo<String> grafo, Vertice<String> vIni){
        if (grafo.esVacio() || !grafo.listaDeVertices().incluye(vIni))
            return null;        

        boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
        CostoMinimos[] costos = new CostoMinimos[grafo.listaDeVertices().tamanio()];
        for (int i=0; i<costos.length; i++){
            costos[i] = new CostoMinimos();
        }
        costos[vIni.posicion()].setCostoMin(0);
        costos[vIni.posicion()].setCantCaminos(1);
        for (int i=0; i< costos.length ; i++){
            Vertice<String> vAux = minimoCosto(grafo,costos, visitados);
            visitados[vAux.posicion()] = true;
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vAux);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> vDestino = arista.verticeDestino();
                if (!visitados[vDestino.posicion()]){
                    int costoAct = costos[vAux.posicion()].getCostoMin() + arista.peso();
                    //swap si el costoAct es menor al actual
                    if (costoAct < costos[vDestino.posicion()].getCostoMin()){
                        costos[vDestino.posicion()].setCostoMin(costoAct);
                        costos[vDestino.posicion()].setCantCaminos(costos[vAux.posicion()].getCantCaminos());
                        costos[vDestino.posicion()].setVerticeAnt(vAux);
                    }
                    else if (costoAct == costos[vDestino.posicion()].getCostoMin()){
                        //esto es del copilot
                        costos[vDestino.posicion()].setCantCaminos(costos[vDestino.posicion()].getCantCaminos() + costos[vAux.posicion()].getCantCaminos());
                    }
                }
            }
        }
        return costos;
    }


    private Vertice<String> minimoCosto(Grafo<String> grafo,CostoMinimos[] costos, boolean[] visitados){
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for (int i=0; i<costos.length; i++){
            if (!visitados[i] && costos[i].getCostoMin() < min){
                min = costos[i].getCostoMin();
                pos = i;
            }
        }
        return grafo.listaDeVertices().elemento(pos);
    }
}
