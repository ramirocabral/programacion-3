package parciales;

import grafos.*;
import listaGenerica.*;

public class Parcial1Test {

  public static void main(String args[]) {
    Vertice<Ciudad1> sp = new VerticeImplListAdy<Ciudad1>(new Ciudad1("Suipacha", 3));
    Vertice<Ciudad1> ck = new VerticeImplListAdy<Ciudad1>(new Ciudad1("Carlos Keen", 2));
    Vertice<Ciudad1> m = new VerticeImplListAdy<Ciudad1>(new Ciudad1("Moreno", 2));
    Vertice<Ciudad1> q = new VerticeImplListAdy<Ciudad1>(new Ciudad1("Quilmes", 3));
    Vertice<Ciudad1> l = new VerticeImplListAdy<Ciudad1>(new Ciudad1("La Plata", 1));
    Vertice<Ciudad1> a = new VerticeImplListAdy<Ciudad1>(new Ciudad1("Abasto", 3));
    Vertice<Ciudad1> c = new VerticeImplListAdy<Ciudad1>(new Ciudad1("Cañuelas", 2));
    Vertice<Ciudad1> n = new VerticeImplListAdy<Ciudad1>(new Ciudad1("Navarro", 1));
    Vertice<Ciudad1> sa = new VerticeImplListAdy<Ciudad1>(new Ciudad1("Saladillo", 2));
    Vertice<Ciudad1> lo = new VerticeImplListAdy<Ciudad1>(new Ciudad1("Lobos", 1));
    Vertice<Ciudad1> pi = new VerticeImplListAdy<Ciudad1>(new Ciudad1("Pinamar", 1));

    Grafo<Ciudad1> ciudades = new GrafoImplListAdy<Ciudad1>();

    ciudades.agregarVertice(sp);
    ciudades.agregarVertice(ck);
    ciudades.agregarVertice(m);
    ciudades.agregarVertice(q);
    ciudades.agregarVertice(l);
    ciudades.agregarVertice(a);
    ciudades.agregarVertice(c);
    ciudades.agregarVertice(n);
    ciudades.agregarVertice(sa);
    ciudades.agregarVertice(lo);
    ciudades.agregarVertice(pi);

    ciudades.conectar(sp, ck, 2);
    ciudades.conectar(ck, sp, 2);
    ciudades.conectar(sp, n, 1);
    ciudades.conectar(n, sp, 1);
    ciudades.conectar(ck, m, 2);
    ciudades.conectar(m, ck, 2);
    ciudades.conectar(m, q, 2);
    ciudades.conectar(q, m, 2);
    ciudades.conectar(q, l, 2);
    ciudades.conectar(l, q, 2);
    ciudades.conectar(l, a, 2);
    ciudades.conectar(a, l, 2);
    ciudades.conectar(a, m, 3);
    ciudades.conectar(m, a, 3);
    ciudades.conectar(a, c, 2);
    ciudades.conectar(c, a, 2);
    ciudades.conectar(c, n, 2);
    ciudades.conectar(n, c, 2);
    ciudades.conectar(n, sa, 2);
    ciudades.conectar(sa, n, 2);
    ciudades.conectar(n, lo, 4);
    ciudades.conectar(lo, n, 4);

    Parcial1 parcial = new Parcial1();

    System.out.println(parcial.resolver(ciudades, "La Plata", "Abasto", 2));
  }

}
