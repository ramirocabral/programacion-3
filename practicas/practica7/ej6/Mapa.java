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

}