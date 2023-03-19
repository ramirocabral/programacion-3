public class Multiplos {
    public static int[] mul(int n) {
        int[] arr = new int[n];
        int aux = n;
        for (int i = 0; i<aux; i++){
            arr[i] = n;
            n = n + aux;
        }
        return arr;
    }
}
