package listaGenerica;

public class Pila<T> {
    private ListaGenericaEnlazada<T> l;
  
    public void apilar(T elem) {
      if(this.esVacia()) {
        this.l = new ListaGenericaEnlazada<>();
      }
      this.l.agregarInicio(elem);
    }
  
    public T desapilar() {
      if (this.esVacia())
        return null;
      T dato = this.l.elemento(0);
      this.l.eliminarEn(0);
      if (this.l.tamanio() == 0)
        this.l = null;
      return dato;
    }
  
    public T tope() {
      if (this.esVacia()) {
        return null;
      }
      return l.elemento(0);
    }
  
    public boolean esVacia() {
      return this.l == null;
    }
  }