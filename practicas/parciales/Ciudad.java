package parciales;

public class Ciudad {
    private int fase;
    private String nombre;

    public Ciudad(){
        this.fase = 0;
        this.nombre = "";
    }

    public Ciudad(String nombre){
        this.fase = 0;
        this.nombre = nombre;
    }

    public Ciudad(String nombre, int fase){
        this.fase = fase;
        this.nombre = nombre;
    }

    public int getFase(){
        return this.fase;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setFase(int fase){
        this.fase = fase;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
