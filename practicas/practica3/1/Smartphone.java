public class Smartphone extends Mobile{

    private int numero;

    public Smartphone(String marca, String sistemaOperativo, String modelo, double costo, int numero) {
        super(marca, sistemaOperativo, modelo, costo);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override

    public boolean equals(Smartphone mob){
        if (this.toString() == mob.toString()){
            return true;
        }
        return false;
    }

}
