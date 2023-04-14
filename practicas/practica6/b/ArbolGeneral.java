public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		if (this.esHoja())
			return 0;
		else {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			Integer altura = 0;
			while (!hijos.fin()) {
				ArbolGeneral<T> hijo = hijos.proximo();
				Integer alturaHijo = hijo.altura();
				if (alturaHijo > altura)
					altura = alturaHijo; //la altura maxima de los hijos
			}
			return altura + 1;
		}
	}

	public boolean include (T data){
		if (this.dato.equals(data))
			return true;
		else {
			if (this.tieneHijos()){
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					ArbolGeneral<T> hijo = hijos.proximo();
					if (hijo.include(data))
						return true;
				}
			}
			return false;
		}
	}

	public Integer nivel(T dato){
		Integer miNivel = 0;
		if (this.getDato().equals(dato))
			return miNivel;
		else {
			if (this.tieneHijos()){
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					ArbolGeneral<T> hijo = hijos.proximo();
					Integer nivelHijo = hijo.nivel(dato);
					if (nivelHijo != -1)
						return nivelHijo+1;
				}
			}
			return -1;
		}
	}

	public ArbolGeneral<T> buscarNodo(T dato){
		if (this.getDato().equals(dato))
			return this;
		else {
			if (this.tieneHijos()){
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					ArbolGeneral<T> hijo = hijos.proximo();
					if (hijo.include(dato))
						return this;
				}
			}
			return null;
		}
	}


	public int ancho(){
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		ArbolGeneral<T> aux;
		ListaGenerica <ArbolGeneral<T>> hijos;
		int anchoMayor = -1;
		int anchoActual = 0;
		while(!cola.esVacia()){
			aux = cola.desencolar();
			if (aux != null){
				hijos = aux.getHijos();
				hijos.comenzar();
				while (!hijos.fin()){
					cola.encolar(hijos.proximo());
					anchoActual++;
				}
			}
			else if (!cola.esVacia()){
				if (anchoActual > anchoMayor)
					anchoMayor = anchoActual;
				cola.encolar(null);
				anchoActual = 0;
			}
		}
		return anchoMayor;
	}


	public void imprimirPorNiveles(){
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		ArbolGeneral<T> aux;
		ListaGenerica <ArbolGeneral<T>> hijos;
		while(!cola.esVacia()){
			aux = cola.desencolar();
			if (aux != null){
				System.out.print(aux.getDato() + " ");
				hijos = aux.getHijos();
				hijos.comenzar();
				while (!hijos.fin()){
					cola.encolar(hijos.proximo());
				}
			}
			else if (!cola.esVacia()){
				cola.encolar(null);
				System.out.println();
			}
		}
	}
}