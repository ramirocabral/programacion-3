package grafos.util;

import grafos.Vertice;

public class Costo {

    /* i dont use generic types because java is so fucked up */

    private int costoMin;
    private Vertice<String> verticeAnt;

    public Costo(int costoMin, Vertice<String> verticeAnt){
        this.costoMin = costoMin;
        this.verticeAnt = verticeAnt;
    }

    public Costo(){
        this.costoMin = Integer.MAX_VALUE;
        this.verticeAnt = null;
    }

    public int getCostoMin(){
        return this.costoMin;
    }

    public Vertice<String> getVerticeAnt(){
        return this.verticeAnt;
    }

    public void setCostoMin(int costoMin){
        this.costoMin = costoMin;
    }

    public void setVerticeAnt(Vertice<String> verticeAnt){
        this.verticeAnt = verticeAnt;
    }

}
