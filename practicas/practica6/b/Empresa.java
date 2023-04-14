public class Empresa {
    private ArbolGeneral<Empleado> empleados;

    public Empresa(ArbolGeneral<Empleado> empleados) {
        this.empleados = empleados;
    }

    public  ArbolGeneral<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArbolGeneral<Empleado> empleados) {
        this.empleados = empleados;
    }


    public int empleadosPorCategoria(int categoria){
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		cola.encolar(empleados);
		cola.encolar(null);
		ArbolGeneral<Empleado> aux;
		ListaGenerica <ArbolGeneral<Empleado>> hijos;
        int cant = 0;
		while(!cola.esVacia()){
			aux = cola.desencolar();
			if (aux != null){
                if (aux.getDato().getCategoria() == categoria)
                    cant++;
				hijos = aux.getHijos();
				hijos.comenzar();
				while (!hijos.fin()){
					cola.encolar(hijos.proximo());
				}
			}
			else if (!cola.esVacia()){
                cola.encolar(null);
			}
		}
		return cant;
	}

    public int categoriaConMasEmpleados(){
        Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
        cola.encolar(empleados);
        cola.encolar(null);
        ArbolGeneral<Empleado> aux;
        ListaGenerica <ArbolGeneral<Empleado>> hijos;
        int cant = 0;
        int max = -1;
        int cat = 0;
        int catMayor = 0;
        while(!cola.esVacia()){
            aux = cola.desencolar();
            if (aux != null){
                cat = aux.getDato().getCategoria();
                cant++;
                hijos = aux.getHijos();
                hijos.comenzar();
                while (!hijos.fin()){
                    cola.encolar(hijos.proximo());
                }
            }
            else if (!cola.esVacia()){
                if (cant > max){
                    max = cant;
                    catMayor = cat;
                }
                cant = 0;
                cola.encolar(null);
            }
        }
        return catMayor;
    }

    public int cantidadTotalDeEmpleados(){
        Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
        cola.encolar(empleados);
        cola.encolar(null);
        ArbolGeneral<Empleado> aux;
        ListaGenerica <ArbolGeneral<Empleado>> hijos;
        int cant = 0;
        while(!cola.esVacia()){
            aux = cola.desencolar();
            if (aux != null){
                cant++;
                hijos = aux.getHijos();
                hijos.comenzar();
                while (!hijos.fin()){
                    cola.encolar(hijos.proximo());
                }
            }
            else if (!cola.esVacia()){
                cola.encolar(null);
            }
        }
        return cant;
    }

    public void reemplazarPresidente(){
        ArbolGeneral<Empleado> aux = empleados;

        if (aux.esHoja()){
            return;
        }

        while(true){
            ArbolGeneral<Empleado> temp = aux.getHijos().elemento(0);
            for (int i = 1; i< aux.getHijos().tamanio(); i++){
                if (aux.getHijos().elemento(i).getDato().getCategoria() > temp.getDato().getCategoria()){
                    temp = aux.getHijos().elemento(i);
                }
            }
            temp.getDato().setCategoria(temp.getDato().getCategoria() - 1);
            aux.setDato(temp.getDato());
            if (temp.esHoja()){
                aux.eliminarHijo(temp);
                break;
            }
            aux = temp;
        }
    }

    public void imprimirPorNiveles(){
        Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();        
        cola.encolar(empleados);
        cola.encolar(null);
        ArbolGeneral<Empleado> aux;
        ListaGenerica <ArbolGeneral<Empleado>> hijos;
        while(!cola.esVacia()){
            aux = cola.desencolar();
            if (aux != null){
                System.out.print(aux.getDato().getNombre() + " ");
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