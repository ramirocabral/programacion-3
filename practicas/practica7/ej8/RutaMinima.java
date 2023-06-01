package practica7.ej8;

import listaGenerica.*;

public class RutaMinima {
    
    private ListaGenerica<String> l;
    private boolean nuevo;              //si hay que comprar boleto nuevo

    public RutaMinima(ListaGenerica<String> l, boolean nuevo){
        this.l = l;
        this.nuevo = nuevo;
    }

    public RutaMinima(){
        this.l = new ListaGenericaEnlazada<String>();
        this.nuevo = false;
    }

    public void setLista(ListaGenerica<String> l){
        this.l = l;
    }

    public void setNuevo(boolean nuevo){
        this.nuevo = nuevo;
    }

    public ListaGenerica<String> getCamino(){
        return this.l;
    }

    public boolean getNuevo(){
        return this.nuevo;
    }
}
