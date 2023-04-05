
public  class Adivinanza {

    public ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario) {
        if (abinario == null) {
            return null;
        }

        if (abinario.esHoja()) {
            ListaGenericaEnlazada<String> result = new ListaGenericaEnlazada<String>();
            result.agregarInicio(abinario.getDato());
            return result;
        }

        ListaGenericaEnlazada<String> izq = new ListaGenericaEnlazada<>();
        ListaGenericaEnlazada<String> der = new ListaGenericaEnlazada<>();

        if(abinario.tieneHijoIzquierdo())
            izq = secuenciaConMasPreguntas(abinario.getHijoIzquierdo());
        if(abinario.tieneHijoDerecho())
            der = secuenciaConMasPreguntas(abinario.getHijoDerecho());
 
        if (izq.tamanio() >= der.tamanio()) {
            izq.agregarInicio(abinario.getDato());
            return izq;
        } else {
            der.agregarInicio(abinario.getDato());
            return der;
        }
    }

    // chat gpt

    public ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciasConMasPreguntas2(ArbolBinario<String> abinario) {
        if (abinario.esVacio()) {
            return null;
        }
    
        if (abinario.esHoja()) {
            ListaGenericaEnlazada<String> result = new ListaGenericaEnlazada<String>();
            result.agregarInicio(abinario.getDato());
            ListaGenericaEnlazada<ListaGenericaEnlazada<String>> res = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
            res.agregarInicio(result);
            return res;
        }
    
        ListaGenericaEnlazada<ListaGenericaEnlazada<String>> izq = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
        ListaGenericaEnlazada<ListaGenericaEnlazada<String>> der = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
    
        if(abinario.tieneHijoIzquierdo())
            izq = secuenciasConMasPreguntas2(abinario.getHijoIzquierdo());
        if(abinario.tieneHijoDerecho())
            der = secuenciasConMasPreguntas2(abinario.getHijoDerecho());
    
        ListaGenericaEnlazada<ListaGenericaEnlazada<String>> result = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
    
        if ((der.elemento(0) == null) && (izq.elemento(0).tamanio() >= der.elemento(0).tamanio())) {
            for (int i = 0; i < izq.tamanio(); i++) {
                izq.elemento(i).agregarInicio(abinario.getDato());
                result.agregarFinal(izq.elemento(i));
            }
        } else {
            for (int i = 0; i < der.tamanio(); i++) {
                der.elemento(i).agregarInicio(abinario.getDato());
                result.agregarFinal(der.elemento(i));
            }
        }
        
        return result;
    }

}