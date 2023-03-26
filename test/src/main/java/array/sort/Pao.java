package sort;

import java.util.Arrays;

public class Pao {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println(Arrays.toString(sort(new int[]{11, 6, 1, 9, 3, 2})));
        ;
    }


    public static int[] sort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.println("i=" + i);
            for (int j = 0; j < a.length-1 ; j++) {
                System.out.println("j=" + j);
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;

    }
}
