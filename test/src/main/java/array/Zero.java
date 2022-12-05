package array;

import java.util.Arrays;

/**
 * 移动0
 */
public class Zero {

    public static void main(String[] args) {
        getZero();
    }

    private static void getZero() {
        int[] a = new int[]{0, 9, 10, 3, 4, 0, 23};
        int i = 0;
        int j = a.length - 1;
        while (i < a.length / 2) {
            if (a[i] == 0) {
                a[i] = a[j];
                a[j] = 0;
                j--;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(a));
    }

}
