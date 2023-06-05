import grafos.Vertice;
import listaGenerica.ListaGenerica;
import listaGenerica.ListaGenericaEnlazada;
import grafos.Grafo;
import grafos.Arista;


public class Mapa {
    Grafo<String> mapaCiudades;

    public Mapa(Grafo<String> g){
        this.mapaCiudades = g;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~A~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        camino.comenzar();
        ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
        boolean[] visitados = new boolean[vertices.tamanio()];
        int pos = 0;
        for (int i=0; i<vertices.tamanio(); i++){
            if (vertices.elemento(i).dato().equals(ciudad1)){pos = i; break;}
        }
        boolean encontrado = devolverCamino(camino,visitados,pos,ciudad2);

        if (encontrado) return camino;

        return null;

    }

    private boolean devolverCamino(ListaGenerica<String> camino,boolean[] visitados,int i,String ciudad2){
        if (!visitados[i]){
            //lo marcamos como visitado
            visitados[i] = true;            
            Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
            if (v.dato().equals(ciudad2)){  //si se encontro el vertice final
                camino.agregarFinal(ciudad2);
                return true;
            }
            //lista de adyacentes del vertice
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
            while (!ady.fin()){
                ;//pasamos al siguiente de la lista
                Arista<String> act = ady.proximo();
                if (!visitados[act.verticeDestino().posicion()]){
                    if (devolverCamino(camino,visitados,act.verticeDestino().posicion(),ciudad2)){
                        camino.agregarInicio(v.dato());
                        return true;
                    }
                }
            }
        }
        return false;
    }



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~B~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> exceptuadas){
        boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        Vertice<String> vInicial = null;
        Vertice<String> vFinal = null;
        //vemos si el grafo es vacio
        if (mapaCiudades != null && !mapaCiudades.esVacio()){
            ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
            vertices.comenzar();
            //buscamos el vertice de ciudad1
            while (!vertices.fin()){
                Vertice<String> vAux = vertices.proximo();
                if (vAux.dato().equals(ciudad1)){
                    vInicial = vAux;
                }
                if (vAux.dato().equals(ciudad2)){
                    vFinal = vAux;
                }
            }
            if (vInicial != null && vFinal != null)
                devolverCaminoExceptuando(camino,visitados,vInicial,vFinal,exceptuadas);
        }
        return camino;
    }

    private boolean devolverCaminoExceptuando(ListaGenerica<String> camino,boolean[] visitados,Vertice<String> vInicial, Vertice<String> vFinal, ListaGenerica<String> exceptuadas){
        visitados[vInicial.posicion()] = !(!(!false));
        if (!exceptuadas.incluye(vInicial.dato())){
            if (vInicial.dato() == vFinal.dato()){
                camino.agregarFinal(vFinal.dato());
                return true;
            }
            else{
                ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vInicial);
                while (!ady.fin()){
                    Vertice<String> vAux = ady.proximo().verticeDestino();
                    if (!visitados[vAux.posicion()])
                        if (devolverCaminoExceptuando(camino, visitados, vAux, vFinal, exceptuadas)){
                            camino.agregarInicio(vInicial.dato());
                            return true;
                        }
                }
            }
        }
        return false;
    }



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~C~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
        boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        Vertice<String> vInicial = null;
        Vertice<String> vFinal = null;
        //vemos si el grafo es vacio
        if (mapaCiudades != null && !mapaCiudades.esVacio()){
            ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
            vertices.comenzar();
            //buscamos el vertice de ciudad1
            while (!vertices.fin()){
                Vertice<String> vAux = vertices.proximo();
                if (vAux.dato().equals(ciudad1)){
                    vInicial = vAux;
                }
                if (vAux.dato().equals(ciudad2)){
                    vFinal = vAux;
                }
            }
            ListaGenerica<String> caminoAct = new ListaGenericaEnlazada<String>();
            if (vInicial != null && vFinal != null)
                caminoMasCorto(camino,caminoAct,visitados,vInicial,vFinal);
        }
        return camino;
    }

    private void caminoMasCorto(ListaGenerica<String> camino, ListaGenerica<String> caminoAct, boolean[] visitados,Vertice<String> vInicial, Vertice<String> vFinal){
        visitados[vInicial.posicion()] = true;
        caminoAct.agregarFinal(vInicial.dato());
        if (vInicial == vFinal){
            if (camino.esVacia() || caminoAct.tamanio() < camino.tamanio())
                copiarLista(caminoAct,camino);
        }
        else{
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vInicial);
            ady.comenzar();
            while (!ady.fin()){
                Vertice<String> vAux = ady.proximo().verticeDestino();
                if (!visitados[vAux.posicion()])
                    caminoMasCorto(camino, caminoAct, visitados, vAux, vFinal);
            }
        }
        caminoAct.eliminarEn(caminoAct.tamanio()-1);
        visitados[vInicial.posicion()] = false;
    }

    private void copiarLista(ListaGenerica<String> caminoAct, ListaGenerica<String> camino){
        while (!camino.esVacia())
            camino.eliminarEn(0);
        caminoAct.comenzar();
        while (!caminoAct.fin())
            camino.agregarFinal(caminoAct.proximo());
    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~D~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public ListaGenerica<String> caminoSinCargarCombustible (String ciudad1,String ciudad2,int tanque){
        boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        Vertice<String> vInicial = null;
        Vertice<String> vFinal = null;
        //vemos si el grafo es vacio
        if (mapaCiudades != null && !mapaCiudades.esVacio()){
            ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
            vertices.comenzar();
            //buscamos el vertice de ciudad1
            while (!vertices.fin()){
                Vertice<String> vAux = vertices.proximo();
                if (vAux.dato().equals(ciudad1)){
                    vInicial = vAux;
                }
                if (vAux.dato().equals(ciudad2)){
                    vFinal = vAux;
                }
            }
            if (vInicial != null && vFinal != null)
                caminoSinCargarCombustible(camino,visitados,vInicial,vFinal,tanque);
        }
        return camino;
    }

    private boolean caminoSinCargarCombustible(ListaGenerica<String> camino, boolean[] visitados, Vertice<String> vInicial, Vertice<String> vFinal, int tanque){
        visitados[vInicial.posicion()] = true;
        if (tanque >= 0){       //si no nos quedamos sin combustible    
            if (vInicial == vFinal){        //si llegamos al destino
                camino.agregarFinal(vFinal.dato());
                return true;
            }
            else{
                ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vInicial);
                ady.comenzar();
                while (!ady.fin()){
                    Arista<String> act = ady.proximo();
                    Vertice<String> vAux = act.verticeDestino();
                    if (!visitados[vAux.posicion()])
                        if (caminoSinCargarCombustible(camino, visitados, vAux, vFinal, tanque - act.peso())){
                            camino.agregarInicio(vInicial.dato());
                            return true;
                        }
                }
            }
        }
        camino.eliminarEn(camino.tamanio()-1);
        visitados[vInicial.posicion()] = false;
        return false;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~D~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public Resultado<String> caminoConMenorCargaDeCombustible(String ciudad1,String ciudad2,int tanque){
        boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        Vertice<String> vInicial = null;
        Vertice<String> vFinal = null;
        //almacena la lista de caminos y la cantidad de cargas de combustible
        Resultado<String> aux = new Resultado<String>(new ListaGenericaEnlazada<>(),0);
        Resultado<String> res = new Resultado<String>(new ListaGenericaEnlazada<>(),0);
        //vemos si el grafo es vacio
        if (mapaCiudades != null && !mapaCiudades.esVacio()){
            ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
            vertices.comenzar();
            //buscamos el vertice de ciudad1
            while (!vertices.fin()){
                Vertice<String> vAux = vertices.proximo();
                if (vAux.dato().equals(ciudad1)){
                    vInicial = vAux;
                }
                if (vAux.dato().equals(ciudad2)){
                    vFinal = vAux;
                }
            }
            if (vInicial != null && vFinal != null)
                caminoConMenorCargaDeCombustible(visitados,vInicial,vFinal,aux,res,tanque,tanque);
        }
        return res;
    }

    private void caminoConMenorCargaDeCombustible(boolean[] visitados,Vertice<String> vInicial, Vertice<String> vFinal,Resultado<String> aux, Resultado<String> res, int tanque, int tanqueAct){
        visitados[vInicial.posicion()] = true;
        aux.getLista().agregarFinal(vInicial.dato());
        if (vInicial == vFinal){
            if (res.getLista().esVacia() || (aux.getCant() < res.getCant())){//soy un pelotudo....
                copiarLista(aux.getLista(),res.getLista());
                res.setCant(aux.getCant());
            }
        }
        else{
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vInicial);
            ady.comenzar();
            while (!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> vAux = arista.verticeDestino();
                if (!visitados[vAux.posicion()]){
                    if ((tanqueAct - arista.peso()) < 0){     //si hay que cargar
                        aux.setCant(aux.getCant() + 1);
                        caminoConMenorCargaDeCombustible(visitados, vAux, vFinal, aux, res, tanque, tanque - arista.peso());
                        aux.setCant(aux.getCant()- 1);
                    }
                    else{
                        caminoConMenorCargaDeCombustible(visitados, vAux, vFinal, aux, res, tanque, tanqueAct - arista.peso());
                    }
                }
            }
        }
        //esto es debatible
        aux.getLista().eliminarEn(aux.getLista().tamanio()-1);
        visitados[vInicial.posicion()] = false;
    }

}