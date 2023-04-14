import practica6.ListaGenericaEnlazada;

public class ArbolBinarioTest {

	
	public static void main(String[] args) {

/* 		ArbolBinario<Integer> arbolBinarioA;
		ArbolBinario<Integer> arbolBinarioB;
		ArbolBinario<Integer> arbolBinarioC;
		ArbolBinario<Integer> arbolBinarioD;
		ArbolBinario<Integer> arbolBinarioE;
		ArbolBinario<Integer> arbolBinarioF;
		ArbolBinario<Integer> arbolBinarioG;
		
		// ----- arbolBinarioA -----
		arbolBinarioA=new ArbolBinario<Integer>(1);		
		ArbolBinario<Integer> hijoIzquierdo=new ArbolBinario<Integer>(2);
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(4));		
		ArbolBinario<Integer> hijoDerecho=new ArbolBinario<Integer>(5);
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<Integer>(7));
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);





		// ----- arbolBinarioB -----
		arbolBinarioB=new ArbolBinario<Integer>(1);		
		ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));		
		ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
		hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));		
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoDerechoB);
		
		// ----- arbolBinarioC -----				
		arbolBinarioC=new ArbolBinario<Integer>(11);		
		ArbolBinario<Integer> hijoIzquierdoC=new ArbolBinario<Integer>(12);
		hijoIzquierdoC.agregarHijoIzquierdo(new ArbolBinario<Integer>(13));
		hijoIzquierdoC.agregarHijoDerecho(new ArbolBinario<Integer>(14));		
		ArbolBinario<Integer> hijoDerechoC=new ArbolBinario<Integer>(15);
		hijoDerechoC.agregarHijoDerecho(new ArbolBinario<Integer>(8));		
		arbolBinarioC.agregarHijoIzquierdo(hijoIzquierdoC);
		arbolBinarioC.agregarHijoDerecho(hijoDerechoC);
		
		// ----- arbolBinarioD -----				
		arbolBinarioD=new ArbolBinario<Integer>(11);		
		ArbolBinario<Integer> hijoIzquierdoD=new ArbolBinario<Integer>(12);
		hijoIzquierdoD.agregarHijoIzquierdo(new ArbolBinario<Integer>(13));
		hijoIzquierdoD.agregarHijoDerecho(new ArbolBinario<Integer>(14));		
		ArbolBinario<Integer> hijoDerechoD=new ArbolBinario<Integer>(15);
		hijoDerechoD.agregarHijoIzquierdo(new ArbolBinario<Integer>(8));		
		arbolBinarioD.agregarHijoIzquierdo(hijoIzquierdoD);
		arbolBinarioD.agregarHijoDerecho(hijoDerechoD);
		
		// ----- arbolBinarioE -----				
		arbolBinarioE=new ArbolBinario<Integer>(1);		
		ArbolBinario<Integer> hijoIzquierdoE=new ArbolBinario<Integer>(2);
		hijoIzquierdoE.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		hijoIzquierdoE.agregarHijoDerecho(new ArbolBinario<Integer>(5));		
		ArbolBinario<Integer> hijoDerechoE=new ArbolBinario<Integer>(3);
		hijoDerechoE.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));	
		arbolBinarioE.agregarHijoIzquierdo(hijoIzquierdoE);
		arbolBinarioE.agregarHijoDerecho(hijoDerechoE);
		
		// ----- arbolBinarioF -----				
		arbolBinarioF=new ArbolBinario<Integer>(1);		
		ArbolBinario<Integer> hijoIzquierdoF=new ArbolBinario<Integer>(3);
		hijoIzquierdoF.agregarHijoDerecho(new ArbolBinario<Integer>(6));		
		ArbolBinario<Integer> hijoDerechoF=new ArbolBinario<Integer>(2);
		hijoDerechoF.agregarHijoIzquierdo(new ArbolBinario<Integer>(5));
		hijoDerechoF.agregarHijoDerecho(new ArbolBinario<Integer>(4));		
		arbolBinarioF.agregarHijoIzquierdo(hijoIzquierdoF);
		arbolBinarioF.agregarHijoDerecho(hijoDerechoF);
		
		// ----- arbolBinarioG -----
		arbolBinarioG=new ArbolBinario<Integer>();	


		//---------------------------------------------------------------------------------------------------------

		System.out.println(arbolBinarioA.esLLeno()); ///////// mis dos huevos
		System.out.println(arbolBinarioD.esLLeno()); */

	//	ListaGenericaEnlazada<String> l = new ListaGenericaEnlazada<String>();


		// test ADIVINANZAS

		ArbolBinario<String> arbolBinarioX=new ArbolBinario<String>("¿Tiene 4 patas?");
        ArbolBinario<String> hijoIzquierdoX=new ArbolBinario<String>("¿Se mueve?");
        hijoIzquierdoX.agregarHijoIzquierdo(new ArbolBinario<String>("¿Ladra?"));
        hijoIzquierdoX.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<String>("Es un perro"));
        hijoIzquierdoX.agregarHijoDerecho(new ArbolBinario<String>("Es una mesa"));
        ArbolBinario<String> hijoDerechoX = new ArbolBinario<String>("¿Tiene alguna pata?");
		hijoDerechoX.agregarHijoDerecho(new ArbolBinario<String>("Es una chota"));
		hijoDerechoX.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<String>("Es una cabra"));
        arbolBinarioX.agregarHijoIzquierdo(hijoIzquierdoX);
        arbolBinarioX.agregarHijoDerecho(hijoDerechoX);

/* 		arbolBinarioX.inOrder();

		Adivinanza a = new Adivinanza();

		ListaGenericaEnlazada<String> L2 = new ListaGenericaEnlazada<String>();

		L2 = a.secuenciaConMasPreguntas(arbolBinarioX);

		System.out.println(L2.toString());   */

		// funciona con primera

		System.out.println(arbolBinarioX.esLleno());


		Adivinanza a = new Adivinanza();

		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> ej2 = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		
        ej2 = a.secuenciaConMasPreguntas2(arbolBinarioX);

		for (int i=0; i < ej2.tamanio(); i++){
			System.out.println(ej2.elemento(i).toString());
		}

	}
}
	

/* 	public void testFrontera() {
		
		//CASO arbolBinarioA
		ListaGenericaEnlazada<Integer> listaFronteraEsperada=new ListaGenericaEnlazada<Integer>();
		listaFronteraEsperada.agregarFinal(3);
		listaFronteraEsperada.agregarFinal(4);
		listaFronteraEsperada.agregarFinal(6);
		listaFronteraEsperada.agregarFinal(7);
		
		ListaGenerica<Integer> listaFronteraDeArbolBinario=arbolBinarioA.frontera();
		if (listaFronteraEsperada.elemento(0) == listaFronteraDeArbolBinario.elemento(0)) System.out.println("bien");
		if (listaFronteraEsperada.elemento(1) == listaFronteraDeArbolBinario.elemento(1)) System.out.println("bien");
		if (listaFronteraEsperada.elemento(2) == listaFronteraDeArbolBinario.elemento(2)) System.out.println("bien");
		if (listaFronteraEsperada.elemento(3) == listaFronteraDeArbolBinario.elemento(3)) System.out.println("bien");
		
		
		//CASO arbolBinarioC
		listaFronteraEsperada=new ListaGenericaEnlazada<Integer>();
		listaFronteraEsperada.agregarEn(13,0);
		listaFronteraEsperada.agregarEn(14,1);
		listaFronteraEsperada.agregarEn(8,2);
		
		listaFronteraDeArbolBinario=arbolBinarioC.frontera();
		if (listaFronteraEsperada.elemento(0) ==  listaFronteraDeArbolBinario.elemento(0)) System.out.println("bien");
		if (listaFronteraEsperada.elemento(1) ==  listaFronteraDeArbolBinario.elemento(1)) System.out.println("bien");
		if (listaFronteraEsperada.elemento(2) ==  listaFronteraDeArbolBinario.elemento(2)) System.out.println("bien");
	}

	public void testLleno() {
		if (arbolBinarioA.esLleno()) System.out.println("bien");
		if (!arbolBinarioD.esLleno()) System.out.println("bien");
	}
	

	public void testContarHojas() {
		if(arbolBinarioA.contarHojas() == 4) System.out.println("bien"); else System.out.println("mal");
		if(arbolBinarioC.contarHojas() == 3) System.out.println("bien");else System.out.println("mal");
		if(arbolBinarioD.contarHojas() == 3) System.out.println("bien");else System.out.println("mal");
	}

	public static void main(String[] args){}
}
 */