public class TestAnimal3 {
public static void main(String[] args) {
    Gato gato1 = new Gato();
    gato1.saludo();
    Perro perro1 = new Perro();
    perro1.saludo();
    PerroGrande perroGrande1 = new PerroGrande();
    perroGrande1.saludo();
    Animal animal1 = new Gato();
    animal1.saludo();
    Perro animal2 = new Perro();
    animal2.saludo();
    PerroGrande animal3 = new PerroGrande();
    animal3.saludo();

    Perro perro2 = animal2;
    PerroGrande perroGrande2 = animal3;
    PerroGrande perro3 = animal3;
    Perro gato2 = animal2;
    perro2.saludo(perro3);
    perro3.saludo(perro2);
    perro2.saludo(perroGrande2);
    perroGrande2.saludo(perro2);
    perroGrande2.saludo(perroGrande1);
    }
}