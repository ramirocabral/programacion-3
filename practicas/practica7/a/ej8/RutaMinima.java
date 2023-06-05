package practica7.a.ej8;

import listaGenerica.*;

public class RutaMinima {
    
    private ListaGenerica<String> l;
    private boolean nuevo;              //si hay que comprar boleto nuevo
    private int longitud;

    public RutaMinima(ListaGenerica<String> l, boolean nuevo, int longitud){
        this.l = l;
        this.nuevo = nuevo;
        this.longitud = longitud;
    }

    public RutaMinima(){
        this.l = new ListaGenericaEnlazada<String>();
        this.nuevo = false;
        this.longitud = 0;
    }

    public void setLista(ListaGenerica<String> l){
        this.l = l;
    }

    public void setNuevo(boolean nuevo){
        this.nuevo = nuevo;
    }

    public void setLongitud(int longitud){
        this.longitud = longitud;
    }

    public ListaGenerica<String> getCamino(){
        return this.l;
    }

    public boolean getNuevo(){
        return this.nuevo;
    }

    public int getLongitud(){
        return this.longitud;
    }
}
