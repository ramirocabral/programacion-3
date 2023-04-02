package practica4.a.clases;


public class ListaDeEnterosEnlazadaTestBasico {     
    public static void main(String[] args){
        ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
        l.agregarInicio(5);
        l.agregarEn(50,1);
        l.agregarFinal(4);
        l.agregarFinal(5);

        

        //imprimir la l
        while(!l.fin()){
            System.out.println(l.proximo());
        }
    }

    public static void imprimirInverso(ListaDeEnterosEnlazada l){
        if(!l.fin()){
            int elem = l.proximo();
            imprimirInverso(l);
            System.out.println(elem);
        }
    }
}
