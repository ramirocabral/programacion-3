public class Recorridos<T> {

    public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo){
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        ListaGenericaEnlazada<Vertice<T>> l = new ListaGenericaEnlazada<Vertice<T>>();
        for (int i=0; i<marca.length;i++){
            if (!marca[i])
                this.dfs(i, grafo, marca,l);
        }
        return l;
    }
    private void dfs(int i, Grafo<T> grafo, boolean[] marca,ListaGenerica<Vertice<T>> l){
        marca[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        l.agregarFinal(v);
        System.out.println(v);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while(!ady.fin()){
            int j = ady.proximo().verticeDestino().posicion();
            if(!marca[j])
            this.dfs(j, grafo, marca,l);
        }
    }

    public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        ListaGenerica<Vertice<T>> l = new ListaGenericaEnlazada<Vertice<T>>();
        for (int i=0; i<marca.length; i++) {
            if (!marca[i])
                this.bfs(i, grafo, marca,l);
        }
        return l;
    }
    
    private void bfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> l){
        ListaGenerica<Arista<T>> ady = null;
        Cola<Vertice<T>> q = new Cola<Vertice<T>>();
        Vertice<T> v1 = grafo.listaDeVertices().elemento(i);
        q.encolar(v1);
        l.agregarFinal(v1);
        marca[i] = true;
        while(!q.esVacia()){
            Vertice<T> v =q.desencolar();
            ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while(!ady.fin()){
                Arista<T> arista = ady.proximo();
                int j = arista.verticeDestino().posicion();
                if (!marca[j]){
                    Vertice<T> w = arista.verticeDestino();
                    marca[j] = true;
                    q.encolar(w);
                    l.agregarFinal(w);
                }
            }
        }
    }
}    
