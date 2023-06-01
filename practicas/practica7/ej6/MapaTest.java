import grafos.VerticeImplListAdy;
import listaGenerica.ListaGenerica;
import listaGenerica.ListaGenericaEnlazada;
import grafos.Vertice;
import grafos.Grafo;
import grafos.GrafoImplListAdy;

public class MapaTest {
    public static void main(String args[]) {
      Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
      Vertice<String> v2 = new VerticeImplListAdy<String>("Cordoba");
      Vertice<String> v3 = new VerticeImplListAdy<String>("Rosario");
      Vertice<String> v4 = new VerticeImplListAdy<String>("Mendoza");
      Vertice<String> v5 = new VerticeImplListAdy<String>("La Plata");
      Vertice<String> v6 = new VerticeImplListAdy<String>("Mar del Plata");
      Vertice<String> v7 = new VerticeImplListAdy<String>("San Luis");
      Vertice<String> v8 = new VerticeImplListAdy<String>("San Juan");
  
      Grafo<String> grafo = new GrafoImplListAdy<String>();
      grafo.agregarVertice(v1);
      grafo.agregarVertice(v2);
      grafo.agregarVertice(v3);
      grafo.agregarVertice(v4);
      grafo.agregarVertice(v5);
      grafo.agregarVertice(v6);
      grafo.agregarVertice(v7);
      grafo.agregarVertice(v8);
  
      grafo.conectar(v1, v2,0);   //bs as - cordoba
      grafo.conectar(v1, v3, 10);  //bs as - rosario
      grafo.conectar(v1, v4, 11);  //bs as -mendoza  
      grafo.conectar(v2, v3, 15);   //cordoba - rosario
      grafo.conectar(v2, v5, 0);  //cordoba - la plata
      grafo.conectar(v5, v3, 0);
      grafo.conectar(v5, v4, 0);  //la plata - mendoza
      grafo.conectar(v3, v4, 50);
      grafo.conectar(v3, v5, 3);  //rosario - la plata
      grafo.conectar(v3, v6, 3);
      grafo.conectar(v4, v6, 2);
      grafo.conectar(v4, v7, 4);
      grafo.conectar(v4, v8, 5);
  
      Mapa mapa = new Mapa(grafo);
  
      //a
      //System.out.println("El camino desde Buenos Aires a San Juan es: " + mapa.devolverCamino("Buenos Aires", "San Juan"));
      //Buenos Aires -> Cordoba -> Rosario -> Mendoza -> San Juan

      //b
      // ListaGenerica<String> exceptuadas = new ListaGenericaEnlazada<String>();
      // exceptuadas.agregarFinal("Mar del Plata");
      // exceptuadas.agregarFinal("Rosario");
      // System.out.println("El camino desde Buenos Aires a San Juan con exceptuadas es: " + mapa.devolverCaminoExceptuando("Buenos Aires", "San Juan",exceptuadas));

      //c
      //System.out.println(mapa.caminoMasCorto("Cordoba", "San Luis"));

      //d
      //System.out.println(mapa.caminoSinCargarCombustible("Buenos Aires","Mendoza", 10));

      //e
      Resultado<String> res = mapa.caminoConMenorCargaDeCombustible("Buenos Aires","Mendoza",10);
      System.out.println("asd " + res.getLista());
      System.out.println("asd: " + res.getCant());
    }
}