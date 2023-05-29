package practicas.practica7.ej6;
public class Cola<T> {
    private ListaGenericaEnlazada<T> l;

    public void encolar(T dato){
        if (this.l == null)
            l = new ListaGenericaEnlazada<T>();
        this.l.agregarFinal(dato);
    }

    public T desencolar(){
        if (this.l.esVacia())
            return null;
        T dato = this.l.elemento(0);
        this.l.eliminarEn(0);
        return dato;
    }

    public T tope(){
        if (this.l.esVacia())
            return null;
        return this.l.elemento(0);
    }

    public boolean esVacia(){
        if (this.l == null){
            return true;
        }
        return this.l.esVacia();
    }

}
