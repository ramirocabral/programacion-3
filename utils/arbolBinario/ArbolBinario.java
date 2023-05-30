package arbolBinario;

import listaGenerica.Cola;
import listaGenerica.ListaGenerica;
import listaGenerica.ListaGenericaEnlazada;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() {
		return false;
	}

	
//-------------------------------IMPLEMENTACIONES----------------------------



	public void preOrder(){
		System.out.println(this.getDato());
		if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().preOrder();
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().preOrder();
	}

	public void inOrder(){
		if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().inOrder();
		System.out.println(this.getDato());
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().inOrder();
	}

	public void postOrder(){
		if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().postOrder();
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().postOrder();
		System.out.println(this.getDato());
	}


	public int contarHojas(){
		if (this.esHoja())
			return 1;
		else{
			int cantHojas = 0;
			if (this.tieneHijoIzquierdo())
				cantHojas += this.getHijoIzquierdo().contarHojas();
			if (this.tieneHijoDerecho())
				cantHojas += this.getHijoDerecho().contarHojas();
			return cantHojas;
		}
	}

	public ListaGenerica<T> frontera(){
		ListaGenerica<T> res = new ListaGenericaEnlazada<>();
		frontera(res);
		return res;
	}

	public void frontera(ListaGenerica<T> res){
		if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().frontera(res);
		if (this.esHoja()){
			res.agregarFinal(this.getDato());
		}
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().frontera(res);
	}
	
	public boolean esLLeno(){
		ArbolBinario<T> aux = null;
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		boolean lleno = true;
		int cantNodos = 0;
		int nivel = 0;
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia() && lleno){
			aux = cola.desencolar();
			if (aux != null){
				System.out.println(aux.getDato());
				if (aux.tieneHijoIzquierdo()){
					cola.encolar(aux.getHijoIzquierdo());
					cantNodos++;
				}
				if (aux.tieneHijoDerecho()){
					cola.encolar(aux.getHijoDerecho());
					cantNodos++;
				}
			}
			else if (!cola.esVacia()){ // es null
				if ((double)cantNodos == Math.pow(2, ++nivel)){
					cola.encolar(null);
					cantNodos = 0;
					System.out.println();
				}
				else
					lleno = false;
			}
		}
		return lleno;
	}

}
