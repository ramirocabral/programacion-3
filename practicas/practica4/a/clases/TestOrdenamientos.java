package practica4.a.clases;

public class TestOrdenamientos {     
    public static void main(String[] args){
        ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();

        l.agregarInicio(4);
        l.agregarInicio(2);
        l.agregarInicio(1);

        

        //imprimir la l


        ListaDeEnterosEnlazada l2 = new ListaDeEnterosEnlazada();
        l2.agregarInicio(100);
        l2.agregarInicio(99);
        l2.agregarInicio(98);
        l2.agregarInicio(97);
        l2.agregarInicio(6);
        l2.agregarInicio(3);

        ListaDeEnterosEnlazada comb = l.combinarOrdenado(l2);

        while(!comb.fin()){    
            System.out.println(comb.proximo());
        }
    
    }
}

