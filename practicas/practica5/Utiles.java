public class Utiles {
    public Integer sumaMaximaVertical(ArbolBinario<Integer> arbol){
        if (!arbol.esVacio()){
            if (arbol.esHoja())
                return (arbol.getDato());
            
            int sumaIzq = sumaMaximaVertical(arbol.getHijoIzquierdo());
            int sumaDer = sumaMaximaVertical(arbol.getHijoDerecho());

            if (sumaIzq >= sumaDer)
                return (arbol.getDato() + sumaIzq);
            else
                return (arbol.getDato() + sumaDer);
        }
        else
            return 0;
    }

    public Integer esLLeno(ArbolBinario<Integer> arbol){
		ArbolBinario<Integer> aux = null;
		Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
		int suma = 0;
        int sumaMax = 0;
		cola.encolar(arbol);
		cola.encolar(null);
		while (!cola.esVacia()){
			aux = cola.desencolar();

			if (aux != null){
                suma += aux.getDato();
				if (aux.tieneHijoIzquierdo()){
					cola.encolar(aux.getHijoIzquierdo());
				}
				if (aux.tieneHijoDerecho()){
					cola.encolar(aux.getHijoDerecho());
				}
			}
			else { // es null
                cola.encolar(null);
                if (suma > sumaMax)
                    sumaMax = suma;
				}
                suma = 0;
			}
		return sumaMax;
    }


}
