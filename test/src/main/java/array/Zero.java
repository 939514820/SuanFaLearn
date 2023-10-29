package array;

import java.util.Arrays;

/**
 * 移动0
 */
public class Zero {
    //    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//    请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    public static void main(String[] args) {
        getZero();
    }

    private static void getZero() {
        int[] a = new int[]{0, 0, 9, 10, 3, 4, 0, 23};
        int i = 0;
        int j = 0;
        while (j < a.length - 1) {
            System.out.println(j);
            while (a[i] != 0) {
                i++;
            }
            while (a[j] == 0) {
                j++;
            }
            if (i != j) {
                a[i] = a[j];
                a[j] = 0;
            }

        }
        System.out.println(Arrays.toString(a));
    }

}
