package parciales;

import listaGenerica.*;

public class Resultado{
    private ListaGenerica<String> camino;
    private int montoRestante;

    public Resultado(){
        this.camino = new ListaGenericaEnlazada<String>();
        this.montoRestante = Integer.MAX_VALUE;
    }

    public void setCamino(ListaGenerica<String> camino){
        this.camino = camino;
    }

    public void setMontoRestante(int monto){
        this.montoRestante = monto;
    }

    public ListaGenerica<String> getCamino(){
        return this.camino;
    }

    public int getMontoRestante(){
        return this.montoRestante;
    }
}