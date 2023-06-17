package parciales;

public class Ciudad1 {
    private String nombre;
    private int dias;

    public Ciudad1 (String nombre, int dias) {
        this.nombre = nombre;
        this.dias = dias;
    }

    public String getNombre () {
        return this.nombre;
    }

    public int getDias () {
        return this.dias;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public void setDias (int dias) {
        this.dias = dias;
    }

}
