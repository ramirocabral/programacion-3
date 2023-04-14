public class TRIE {

    private ArbolGeneral<Character> trie;

    public TRIE(){
        trie = new ArbolGeneral<Character>(null);
    }

    public ArbolGeneral<Character> getTrie(){
        return trie;
    }

    public void agregarPalabra(String palabra){
        ArbolGeneral<Character> aux = trie;
        for (char c : palabra.toCharArray()) {  //por cada char del string
            ListaGenerica<ArbolGeneral<Character>> hijos = aux.getHijos();
            int pos = incluye(hijos,c);
            if (pos != -1)
                aux = hijos.elemento(pos);
            else {
                aux = aux.getHijos().elemento(agregarChar(hijos, c));
            }
        }
    }

    //si un hijo incluye al caracter c, devuelve la posicion del hijo
    private int incluye(ListaGenerica<ArbolGeneral<Character>> hijos, char c) {
        hijos.comenzar();
        for (int i=0; i<hijos.tamanio(); i++) {
            if (hijos.elemento(i).getDato() == c)
                return i;
        }
        return -1;
    }

    //agrega el char en la posiciion correspondiente, devuelve la posicion
    private int agregarChar(ListaGenerica<ArbolGeneral<Character>> hijos, char c) {

        if (hijos.esVacia()){
            hijos.agregarInicio(new ArbolGeneral<Character>(c));
            return 0;
        }

        hijos.comenzar();
        int i=0;
        for (i=0; i < hijos.tamanio(); i++) {
            if (hijos.elemento(i).getDato() > c)
                break;
        }
        hijos.agregarEn(new ArbolGeneral<Character>(c), i);
        return i;
    }

    public void ImprimirPorNiveles(){
        trie.imprimirPorNiveles();
    }

    //--------------------2---------------------

    public ListaGenerica<StringBuilder> palabrasQueEmpiezanCon(String prefijo){
        ListaGenerica<StringBuilder> lista = new ListaGenericaEnlazada<StringBuilder>();
        ListaGenerica<ArbolGeneral<Character>> aux = trie.getHijos();
        for (char c : prefijo.toCharArray()) {  //por cada char del string
            int pos = incluye(aux,c);
            if (pos == -1)
                return null; //si el prefijo no existe en el trie
            aux = aux.elemento(pos).getHijos(); //queda en el ultimo nodo del prefijo
        }

        palabras(aux, new StringBuilder(prefijo), lista);
        
        return lista;
    }

    private void palabras (ListaGenerica<ArbolGeneral<Character>> aux, StringBuilder st, ListaGenerica<StringBuilder> lista){
        aux.comenzar();
        for (int i=0; i<aux.tamanio(); i++) {
            ArbolGeneral<Character> nodo = aux.elemento(i);
            st.append(nodo.getDato());
            if (nodo.esHoja())
                lista.agregarFinal(new StringBuilder(st));
            else
                palabras(nodo.getHijos(), st, lista);
            st.deleteCharAt(st.length()-1);
        }
    }
}
