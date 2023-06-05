package heap;

interface ColaPrioridades<T> {
    public boolean esVacia();
    public T eliminar();
    public boolean agregar(T dato);
    public T tope();
}
