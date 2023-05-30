import grafos.GrafoImplListAdy;
import grafos.Arista;
import grafos.VerticeImplListAdy;
import listaGenerica.ListaGenerica;

public class TestGrafoImplListAdy {
	
	public static void main(String[] args){
		GrafoImplListAdy<Integer> grafo = new GrafoImplListAdy<Integer>();

		VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
		VerticeImplListAdy<Integer> vert2 = new VerticeImplListAdy<Integer>(2);
		grafo.agregarVertice(vert1);
		grafo.agregarVertice(vert2);
		grafo.conectar(vert1, vert2);
		boolean ok = false;
		
		ListaGenerica<Arista<Integer>> lista = grafo.listaDeAdyacentes(vert1);
		Arista<Integer> arista;
		lista.comenzar();
		while(!lista.fin()){
			arista = lista.proximo();
			if (arista.verticeDestino() == vert2){
				ok= true;
			}
			
		}
	}
}