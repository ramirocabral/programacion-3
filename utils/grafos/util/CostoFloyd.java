package grafos.util;

import grafos.*;

public class CostoFloyd{
    private int costo;
    private Vertice<String> vertPrev;

    public CostoFloyd(int costo,Vertice<String> vertPrev){
        this.costo = costo;
        this.vertPrev = vertPrev;
    }

    public Vertice<String> getVertPrev(){
        return this.vertPrev;
    }

    public int getCosto(){
        return this.costo;
    }

    public void setVertPrev(Vertice<String> vertPrev){
        this.vertPrev = vertPrev;
    }

    public void setCosto(int costo){
        this.costo = costo;
    }

}
