public abstract class Figura {

    private String color;
    private boolean relleno;

    public Figura(String color, boolean relleno) {
        this.color = "rojo";
        this.relleno = true;
    }

    public Figura(){
    
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    @Override

    public String toString() {
        return "Figura{" + "color=" + color + ", relleno=" + relleno + '}';
    }

    public abstract double getArea();

    public abstract double getPerimetro();


}
