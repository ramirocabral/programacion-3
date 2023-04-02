public class TestBalanceo {
    public static void main(String[] args){
        StringBuffer s = new StringBuffer("({[(()]})");
        System.out.println(balanceado(s));
    }

    public static boolean balanceado(StringBuffer s) {
        Pila<Character> p = new Pila<>();
        while (s.length() != 0) {
            if (abierto(s.charAt(0))) {
                p.apilar(s.charAt(0));
            } 
            else {
                if (p.esVacia()) {
                    return false;
                } 
                else {
                    if (pares(p.tope(), s.charAt(0))) {
                        p.desapilar();
                    } 
                    else {
                        return false;
                    }
                }
            }
            s.deleteCharAt(0); //pasamos al siguiente
        }

        if (p.esVacia()) {
            return true;
        } 
        else {
            return false;
        }
    }

    public static boolean abierto(Character c) {
        return (c == '(' || c == '[' || c == '{');
    }

    public static boolean pares(Character a, Character b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }
}
