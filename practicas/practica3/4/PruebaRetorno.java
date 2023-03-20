public class PruebaRetorno {

    //el metodo debe devolver el minimo, maximo y promedio de los elementos del arreglo
    public String procesarArreglo(int[] arr) {
        int min = 9999;
        int max = -9999;
        float prom = 0;
        int suma = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
            suma += arr[i];
        }
        prom = suma / arr.length;

        return ("Minimo: " + min + " Maximo: " + max + " Promedio: " + prom);
    }

    public Resultado procesarArreglo2(int[] arr) {
        int min = 9999;
        int max = -9999;
        float prom = 0;
        int suma = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
            suma += arr[i];
        }
        prom = suma / arr.length;

        return new Resultado(min, max, prom);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        PruebaRetorno pr = new PruebaRetorno();
        System.out.println(pr.procesarArreglo(arr));
        PruebaRetorno pr2 = new PruebaRetorno();
        Resultado res = pr2.procesarArreglo2(arr);
        System.out.println(res);
    }
}