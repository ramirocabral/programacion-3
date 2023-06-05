package grafos.util;

import grafos.Vertice;

public class CostoMinimos {

    /* i dont use generic types because java is so fucked up */

    private int costoMin;
    private Vertice<String> verticeAnt;
    private int cantCaminos;

    public CostoMinimos(int costoMin, Vertice<String> verticeAnt, int cantCaminos){
        this.costoMin = costoMin;
        this.verticeAnt = verticeAnt;
        this.cantCaminos = cantCaminos;
    }

    public CostoMinimos(){
        this.costoMin = Integer.MAX_VALUE;
        this.verticeAnt = null;
        this.cantCaminos = 0;
    }

    public int getCostoMin(){
        return this.costoMin;
    }

    public Vertice<String> getVerticeAnt(){
        return this.verticeAnt;
    }

    public int getCantCaminos(){
        return this.cantCaminos;
    }

    public void setCostoMin(int costoMin){
        this.costoMin = costoMin;
    }

    public void setVerticeAnt(Vertice<String> verticeAnt){
        this.verticeAnt = verticeAnt;
    }

    public void setCantCaminos(int cantCaminos){
        this.cantCaminos = cantCaminos;
    }

}
