import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int n = in.nextInt();
        int[] ar = Multiplos.mul(n);
        System.out.println(Arrays.toString(ar));
    }
}
