package parciales;

import grafos.*;
import listaGenerica.*;


public class Parcial2GHTest {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("La Plata");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Pinamar");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Quilmes");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Abasto");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Moreno");
        Vertice<String> v6 = new VerticeImplListAdy<String>("Cañuelas");
        Vertice<String> v7 = new VerticeImplListAdy<String>("Carlos Keen");
        Vertice<String> v8 = new VerticeImplListAdy<String>("Lobos");
        Vertice<String> v9 = new VerticeImplListAdy<String>("Navarro");
        Vertice<String> v10 = new VerticeImplListAdy<String>("Saladillo");
        Vertice<String> v11 = new VerticeImplListAdy<String>("Suipacha");


        Grafo<String> ciudades = new GrafoImplListAdy<String>();
        ciudades.agregarVertice(v1);
        ciudades.agregarVertice(v2);
        ciudades.agregarVertice(v3);
        ciudades.agregarVertice(v4);
        ciudades.agregarVertice(v5);
        ciudades.agregarVertice(v6);
        ciudades.agregarVertice(v7);
        ciudades.agregarVertice(v8);
        ciudades.agregarVertice(v9);
        ciudades.agregarVertice(v10);
        ciudades.agregarVertice(v11);

        ciudades.conectar(v1, v2, 1); //La Plata - Pinamar
        ciudades.conectar(v2, v1, 1);

        ciudades.conectar(v1, v3, 1); //La Plata - Quilmes
        ciudades.conectar(v3, v1, 1);

        ciudades.conectar(v1, v4, 1); //La Plata - Abasto
        ciudades.conectar(v4, v1, 1);

        ciudades.conectar(v3, v5, 1); //Quilmes - Moreno
        ciudades.conectar(v5, v3, 1);

        ciudades.conectar(v4, v5, 1); //Abasto - Moreno
        ciudades.conectar(v5, v4, 1);

        ciudades.conectar(v7, v5, 1); //Moreno - Carlos Keen
        ciudades.conectar(v5, v7, 1);

        ciudades.conectar(v4, v6, 1); //Abasto - Cañuelas
        ciudades.conectar(v6, v4, 1);

        ciudades.conectar(v9, v6, 1); //Cañuelas - Navarro
        ciudades.conectar(v6, v9, 1);

        ciudades.conectar(v9, v10, 1); //Navarro - Saladillo
        ciudades.conectar(v10, v9, 1);

        ciudades.conectar(v9, v8, 1); //Navarro - Lobos
        ciudades.conectar(v8, v9, 1);

        ciudades.conectar(v9, v11, 1); //Navarro - Suipacha
        ciudades.conectar(v11, v9, 1);

        ciudades.conectar(v7, v11, 1); //Suipacha - Carlos Keen
        ciudades.conectar(v11, v7, 1);

        Parcial2GH P2 = new Parcial2GH();
        ListaGenerica<String> ciudadesObligatorias = new ListaGenericaEnlazada<String>();
        ciudadesObligatorias.agregarInicio(v2.dato());  //pinamar

        Parcial2GHResultado res = P2.resolver(ciudades, "La Plata", "Lobos", ciudadesObligatorias);

        System.out.println(res.getCamino());
        // -> La Plata -> Quilmes -> Moreno -> Carlos Keen -> Suipacha
    }
}
