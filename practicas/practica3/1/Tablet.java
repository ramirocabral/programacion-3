public class Tablet extends Mobile{
    private float pulgadas;

    public Tablet(String marca, String sistemaOperativo, String modelo, double costo, float pulgadas) {
        super(marca, sistemaOperativo, modelo, costo);
        this.pulgadas = pulgadas;
    }

    public float getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(float pulgadas) {
        this.pulgadas = pulgadas;
    }

    public boolean equals(Tablet mob){
    if (this.toString() == mob.toString()){
        return true;
    }
    return false;
}
}
