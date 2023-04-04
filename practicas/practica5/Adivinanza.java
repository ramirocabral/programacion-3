public class Adivinanza {

    public ListaGenericaEnlazada<String> maximoCamino(ArbolBinario<String> arbol){
        if (!arbol.esVacio()){
            
            if (arbol.esHoja()){
                ListaGenericaEnlazada<String> l = new ListaGenericaEnlazada<String>();
                l.agregarInicio(arbol.getDato());
                return (l);
            }


            ListaGenericaEnlazada<String> lIzq = new ListaGenericaEnlazada<String>();
            ListaGenericaEnlazada<String> lDer = new ListaGenericaEnlazada<String>();

            if (arbol.tieneHijoIzquierdo())
                lIzq = maximoCamino(arbol.getHijoIzquierdo())
            if (arbol.tieneHijoDerecho())
                lDer = maximoCamino(arbol.getHijoDerecho())
                
            if (lIzq.tamanio() >= lDer.tamanio()){
                lIzq.agregarInicio(arbol.getDato());
                return lIzq;
            }
            else{
                lDer.agregarInicio(arbol.getDato());
                return lDer;
            }
        }
        else
            return null;
    }
}
