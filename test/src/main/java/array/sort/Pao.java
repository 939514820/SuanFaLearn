package array.sort;

import java.util.Arrays;

public class Pao {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println(Arrays.toString(sort(new int[]{11, 6, 1, 9, 3, 2})));
        System.out.println(Arrays.toString(sort(new int[]{4, 5, 6, 2, 3})));
        // 4, 5, 6, 2, 3
        // 4, 5, 2, 3,6
        // 4, 2, 3, 5,6
        // 4, 2, 3, 5,6

    }


    public static int[] sort(int[] a) {

        boolean flag = true;
        int index = 0;
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                return a;
            }
        }
        return a;

    }
}
