import java.util.Scanner;

public class IteradorAB{
    public void iteracionConFor(int a, int b){
        Scanner in = new Scanner(System.in);
        for (int i = a; i <= b; i++)
            System.out.println(i);
    }

    public void iterarionConWhile(int a, int b){
        Scanner in = new Scanner(System.in);
        int i = a;
        while (i <= b){
            System.out.println(i);
            i++;
        }
    }

    public void recursivo (int a, int b){
        Scanner in = new Scanner(System.in);
        if (a > b){
            int aux = b;
            b= a;
            a = aux;
        }
        System.out.println(a);
        if (a < b){
            recursivo(a+1, b);
        }
    }
}