package practica7.a.ej9;

import listaGenerica.*;

public class Camino {
    private ListaGenerica<String> camino;
    private int costoMin;

    public Camino(){
        this.camino = new ListaGenericaEnlazada<String>();
        this.costoMin = Integer.MAX_VALUE;
    }

    public Camino(ListaGenerica<String> camino, int costoMin){
        this.camino = camino;
        this.costoMin = costoMin;
    }

    public ListaGenerica<String> getCamino(){
        return this.camino;
    }

    public int getCostoMin(){
        return this.costoMin;
    }

    public void setCamino(ListaGenerica<String> camino){
        this.camino = camino;
    }

    public void setCostoMin(int costoMin){
        this.costoMin = costoMin;
    }

}
