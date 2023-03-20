public class Circulo extends Figura {
    private double radio;


    public Circulo(String color, Boolean relleno, double radio) {
        super(color, relleno);
        this.radio = radio;
    }

    public Circulo (double radio) {
        this.radio = radio;
    }

    public Circulo() {
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double getPerimetro(){
        return (2 * Math.PI * radio);
    }

    @Override

    public String toString() {
        return super.toString()+" Circulo{" + "radio=" + radio + '}';
    }

}
