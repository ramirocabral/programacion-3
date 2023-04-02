public class Cola<T> {
    private ListaGenericaEnlazada<T> l;

    public void Encolar(T dato){
        if (this.l.esVacia())
            l = new ListaGenericaEnlazada<>();
        this.l.agregarFinal(dato);
    }

    public T Desencolar(){
        if (this.l.esVacia())
            return null;
        T dato = this.l.elemento(0);
        this.l.eliminarEn(0);
        return dato;
    }

    public T Tope(){
        if (this.l.esVacia())
            return null;
        return this.l.elemento(0);
    }

    public boolean esVacia(){
        return this.l.esVacia();
    }

}
