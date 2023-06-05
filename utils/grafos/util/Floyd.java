package grafos.util;

import grafos.*;
import listaGenerica.*;

public class Floyd{
    public CostoFloyd[][] floyd(Grafo<String> grafo){
        ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
        CostoFloyd[][] matriz = new CostoFloyd[vertices.tamanio()][vertices.tamanio()];
        for (int i = 0; i < vertices.tamanio(); i++){
            for (int j = 0; j < vertices.tamanio(); j++){
                if (i == j)
                    matriz[i][j] = new CostoFloyd(0,vertices.elemento(i));//diagonal en 0
                else if(grafo.esAdyacente(vertices.elemento(i), vertices.elemento(j)))
                    matriz[i][j] = new CostoFloyd(grafo.peso(vertices.elemento(i),vertices.elemento(j)),vertices.elemento(i));//valor correcto de peso
                else
                    matriz[i][j] = new CostoFloyd(Integer.MAX_VALUE,null);//infinito si no estan conectados
            }
        }
        //¿?
        for (int k = 0; k < vertices.tamanio(); k++){
            for (int i = 0; i < vertices.tamanio(); i++){
                for (int j = 0; j < vertices.tamanio(); j++){
                    if (matriz[i][k].getCosto() != Integer.MAX_VALUE && matriz[k][j].getCosto() != Integer.MAX_VALUE){
                        int aux = matriz[i][k].getCosto() + matriz[k][j].getCosto();
                        if (aux < matriz[i][j].getCosto()){
                            matriz[i][j].setCosto(aux);
                            matriz[i][j].setVertPrev(matriz[k][j].getVertPrev());
                        }
                    }
                }
            }
        }
        return matriz;
    }
}
