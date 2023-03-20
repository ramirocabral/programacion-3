public class TestFigurasGeometricas {
    public static void main(String[] args){
        Figura[] figuras = new Figura[3];

        figuras[0] = new Circulo("Rojo",true, 5.0);
        figuras[1] = new Rectangulo("Azul",false, 2.0, 3.0);
        figuras[2] = new Cuadrado("Verde",true, 4.0);

        for (Figura figura : figuras) {
            System.out.println(figura.toString());
        }

    }    
}
