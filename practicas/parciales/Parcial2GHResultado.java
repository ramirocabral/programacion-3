package parciales;

import listaGenerica.*;


public class Parcial2GHResultado {
    private ListaGenerica<String> camino;
    private int evaluados;

    public Parcial2GHResultado(ListaGenerica<String> camino, int evaluados) {
        this.camino = camino;
        this.evaluados = evaluados;
    }

    public Parcial2GHResultado(){
        this.camino = new ListaGenericaEnlazada<String>();
        this.evaluados = 0;
    }

    public ListaGenerica<String> getCamino() {
        return camino;
    }

    public int getEvaluados() {
        return evaluados;
    }

    public void setCamino(ListaGenerica<String> camino) {
        this.camino = camino;
    }

    public void setEvaluados(int evaluados) {
        this.evaluados = evaluados;
    }

}
