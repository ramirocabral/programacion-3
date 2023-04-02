
public class ej2 {
    public static void main(String[] args){
        ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>();

        l.comenzar();

        l. agregarFinal(5);
        l. agregarFinal(4);
        l. agregarFinal(3);
        l. agregarFinal(2);
        l. agregarFinal(1);

        System.out.println("Original :");

        System.out.println(l.toString());  

        System.out.println("Invertida:");

        ListaGenericaEnlazada<Integer> invertida = new ListaGenericaEnlazada<Integer>();

        invertida = l.invertir();

        System.out.println(invertida.toString());  

    }
}
