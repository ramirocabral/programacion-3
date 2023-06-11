package parciales;

public class Persona {
    private boolean esEmpleado;
    private String nombre;
    private String domicilio;

    public Persona(boolean esEmpleado, String nombre, String domicilio) {
        this.esEmpleado = esEmpleado;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public boolean esEmpleado() {
        return esEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setEsEmpleado(boolean esEmpleado) {
        this.esEmpleado = esEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

}
