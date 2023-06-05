import listaGenerica.ListaGenerica;
import listaGenerica.ListaGenericaEnlazada;

public class Resultado<T> {
    private ListaGenerica<T> lista;
    private int cant;

    public Resultado(ListaGenerica<T> lista, int cant) {
        this.lista = lista;
        this.cant = cant;
    }
    
    public Resultado() {
        this.lista = new ListaGenericaEnlazada<>();
        this.cant = 0;
    }

    public ListaGenerica<T> getLista() {
        return lista;
    }

    public int getCant() {
        return cant;
    }

    public void setLista(ListaGenerica<T> lista) {
        this.lista = lista;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
}