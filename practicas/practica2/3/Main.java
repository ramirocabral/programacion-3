public class Main{
    public static void main (String[] args){
        Tablet[] arr = new Tablet[3];

        arr[0] = new Tablet("Samsung", "Android", "Galaxy Tab S6", 10000, 10.5f);
        arr[1] = new Tablet("Apple", "iOS", "iPad Pro", 20000, 12.9f);
        arr[2] = new Tablet("Huawei", "Android", "MediaPad M5", 15000, 10.8f);

        for (Tablet t : arr){
            System.out.println(t.devolverDatos());
        }
    }
}