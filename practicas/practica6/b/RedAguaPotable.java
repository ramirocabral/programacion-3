import practicas.practica7.ej6.ListaGenerica;

public class RedAguaPotable {
    public static void main(String[] args){
        ArbolGeneral<Double> a = new ArbolGeneral<Double>(1.0);
        //hace un arbol random
        a.agregarHijo(new ArbolGeneral<Double>(2.0));
        a.agregarHijo(new ArbolGeneral<Double>(3.0));
        a.agregarHijo(new ArbolGeneral<Double>(4.0));
        a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Double>(5.0));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Double>(6.0));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Double>(10.0));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Double>(7.0));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(8.0));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(9.0));
        a.imprimirPorNiveles();
        System.out.println();
        System.out.println("minCaudal: "+ minimoCaudal(a, 2000));
    }

    public static double minimoCaudal(ArbolGeneral<Double> red , double litros){
        if (red.esHoja())
            return litros;
        ListaGenerica<ArbolGeneral<Double>> hijos = red.getHijos();
        hijos.comenzar();
        double min = 99999;
        double aux = litros/hijos.tamanio(); //litros de cada hijo
        while (!hijos.fin()){
            double temp = minimoCaudal(hijos.proximo(), aux);
            if (temp < min)
                min = temp;
                System.out.println(aux);
        }

        return min;
    }
}
