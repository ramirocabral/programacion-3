package heap;

public class MinHeap<T extends Comparable<T>> implements ColaPrioridades<T>{
    private T[] datos;
    private int cant;

    public MinHeap(){
    }

    public MinHeap(T [] elementos){
        for (int i=0; i<elementos.length; i++){
            cant++;
            datos[cant] = elementos[i];
        }
        for (int i=cant/2; i>0; i--)
            this.percolateDown(i);
    }

    public boolean agregar(T dato){
        this.cant++;
        this.datos[cant] = dato;
        this.percolateUp(cant);
        return true;
    }

    private void percolateUp(int pos){
        T temp = datos[pos];
        while (pos/2 > 0 && datos[pos/2].compareTo(temp) < 0){
            datos[pos] = datos[pos/2]
            pos = pos/2;
        }
        datos[pos] = temp;
    }

    private void percolateDown(int posicion){
        T candidato = datos[posicion];
        boolean detener_percolate = false;
        while (2 * posicion <= cant && !detener_percolate) {
            //buscar el hijo minimo de candidato (hijo_minimo es el indice)
            int hijo_minimo = 2 * posicion;
            if (hijo_minimo != this.cant){ //hay+ eltos,tiene hderecho
                if (datos[hijo_minimo + 1].compareTo(datos[hijo_minimo]) < 0) {
                    hijo_minimo++;
                }
            }
            if (candidato.compareTo(datos[hijo_minimo]) > 0) { //padre>hijo
                datos[posicion] = datos[hijo_minimo];
                posicion = hijo_minimo;
            } 
            else {
                detener_percolate = true;
            }
        }
        datos[posicion] = candidato;
    }

    public T eliminar(){
        if (this.esVacia()) return null;
        T res = datos[1];
        datos[1] = datos[cant];
        cant--;
        this.percolateDown(1);
        return res;
    }

    public T tope(){
        if (this.esVacia()) return null;
        return datos[1];
    }


    public T eliminarMin(){
        if (this.esVacia()) return null;
        T res = datos[1];
        datos[1] = datos[cant];
        cant--;
        this.percolateDown(1);
        return res;
    }


    public boolean esVacia(){
        return cant == 0;
    }

    public int tamanio(){
        return cant;
    }

}
