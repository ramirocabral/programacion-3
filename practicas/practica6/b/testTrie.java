import practicas.practica7.ej6.ListaGenerica;

public class testTrie {
    public static void main(String[] args) {
        TRIE trie = new TRIE();
        trie.agregarPalabra("arbol");  //pola
        trie.agregarPalabra("araña");
        trie.agregarPalabra("arañita");
        trie.agregarPalabra("hoja");
        trie.agregarPalabra("homo");
        trie.ImprimirPorNiveles();
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        ListaGenerica<StringBuilder> p = trie.palabrasQueEmpiezanCon("ar");
        System.out.println(p.toString());
    }
}
