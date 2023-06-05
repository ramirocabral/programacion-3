package heap;

import listaGenerica.ListaGenerica;

public class MaxHeap<T extends Comparable<T>> implements ColaPrioridades<T>{
    private T[] datos;
    private int cant;

    public MaxHeap(){
    }

    public MaxHeap(T [] elementos){
        for (int i=0; i<elementos.length; i++){
            cant++;
            datos[cant] = elementos[i];
        }
        for (int i=cant/2; i>0; i--)
            this.percolateDown(i);
    }

    public MaxHeap(ListaGenerica<T> lista){
        lista.comenzar();
        while (!lista.fin()){
            this.agregar(lista.proximo());
        }
    }

    public boolean agregar(T dato){
        this.cant++;
        this.datos[cant] = dato;
        this.percolateUp(cant);
        return true;
    }

    private void percolateUp(int pos){
        T temp = datos[pos];
        while (pos/2 > 0 && datos[pos/2].compareTo(temp) > 0){
            datos[pos] = datos[pos/2]
            pos = pos/2;
        }
        datos[pos] = temp;
    }

    private void percolateDown(int posicion){
        T candidato = datos[posicion];
        boolean detener_percolate = false;
        while (2 * posicion <= cant && !detener_percolate) {
            //buscar el hijo maximo de candidato (hijo_máximo es el indice)
            int hijo_maximo = 2 * posicion;
            if (hijo_maximo != this.cant){ //hay+ eltos,tiene hderecho
                if (datos[hijo_maximo + 1].compareTo(datos[hijo_maximo]) > 0) {
                    hijo_maximo++;
                }
            }
            if (candidato.compareTo(datos[hijo_maximo]) < 0) { //padre<hijo
                datos[posicion] = datos[hijo_maximo];
                posicion = hijo_maximo;
            } 
            else {
                detener_percolate = true;
            }
        }
        this.datos[posicion] = candidato;
    }

    public T eliminar(){
        if (this.cant > 0){
            T elem = this.datos[1];
            this.datos[1] = this.datos[this.cant];
            this.cant--;
            this.percolateDown(1);
            return elem;
        }
        return null;
    }

    public T tope(){
        return this.datos[1];
    }

    public boolean esVacia(){
        return this.cant == 0;
    }
}
