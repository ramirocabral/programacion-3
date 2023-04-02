public class PilaTest {
    public static void main(String[] args){
        Pila<Character> p = new Pila<>();
        p.apilar('a');
        p.apilar('b');
        p.apilar('c');
        p.apilar('d');
        p.apilar('e');
        System.out.println(p.tope());
        System.out.println(p.desapilar());
        System.out.println(p.desapilar());
        System.out.println(p.desapilar());
        System.out.println(p.desapilar());
        System.out.println(p.desapilar());
    }
}
