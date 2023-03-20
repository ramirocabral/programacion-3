public class Cuadrado extends Rectangulo{
    public Cuadrado(){
    }
    
    public Cuadrado(double lado){
        super(lado, lado);
    }
    
    public Cuadrado(String color, Boolean relleno, double lado){
        super(color, relleno, lado, lado);
    }
    
    public double getLado(){
        return getLargo();
    }
    
    public void setLado(double lado){
        setLargo(lado);
        setAncho(lado);
    }
    
    @Override
    public void setLargo(double lado){
        setLado(lado);
    }
    
    @Override
    public void setAncho(double lado){
        setLado(lado);
    }
    
    @Override
    public String toString(){
        return super.toString() + " Cuadrado{" + "lado=" + getLado() + '}';
    }
}
