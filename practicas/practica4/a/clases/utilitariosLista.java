package practica4.a.clases;


public class utilitariosLista {

    public static void main(String[] args) {
        ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();

        l.agregarInicio(4);
        l.agregarInicio(65);
        l.agregarInicio(76);
        l.agregarInicio(12);
        
        l = mergeSort(l);

        while(!l.fin()){    
            System.out.println(l.proximo());
        }
    }

    public static ListaDeEnterosEnlazada mergeSort(ListaDeEnterosEnlazada l){
        if (l.tamanio() < 2){
            return l;
        }
        int mitad = l.tamanio() / 2;
        ListaDeEnterosEnlazada l1 = new ListaDeEnterosEnlazada();
        ListaDeEnterosEnlazada l2 = new ListaDeEnterosEnlazada();
        for (int i = 0; i < mitad; i++){        //obtenemos las listas izquierda y derecha
            l1.agregarFinal(l.elemento(i));
        }
        for (int i = mitad; i < l.tamanio(); i++){
            l2.agregarFinal(l.elemento(i));
        }
        l1 = mergeSort(l1);
        l2 = mergeSort(l2);
        return merge(l1,l2);
    }

    public static ListaDeEnterosEnlazada merge(ListaDeEnterosEnlazada l1, ListaDeEnterosEnlazada l2){
        int i = 0;
        int j = 0;
        ListaDeEnterosEnlazada res = new ListaDeEnterosEnlazada();
        while ((i < l1.tamanio()) && (j < l2.tamanio())){  //l1 y l2 llegan ordenadas
            if (l1.elemento(i) < l2.elemento(j)){
                res.agregarFinal(l1.elemento(i));
                i++;
            }
            else{
                res.agregarFinal(l2.elemento(j));
                j++;
            }
        }
        while (i < l1.tamanio()){                          //metemos los elementos que quedaron en la lista que no se vacio
            res.agregarFinal(l1.elemento(i));
            i++;
        }
        while (j < l2.tamanio()){
            res.agregarFinal(l2.elemento(j));
            j++;
        }
        return res;                                        //devolvemos una nueva lista ordenada
    }
}
