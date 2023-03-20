public class Rectangulo extends Figura{
    private double largo;
    private double ancho;

    public Rectangulo(){
    }

    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    public Rectangulo(String color, Boolean relleno, double largo, double ancho) {
        super(color, relleno);
        this.largo = largo;
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getArea() {
        return largo * ancho;
    }

    public double getPerimetro() {
        return (2 * largo) + (2 * ancho);
    }

    @Override

    public String toString() {
        return super.toString() + " Rectangulo{" + "largo=" + largo + ", ancho=" + ancho + '}';
    }
}
