package array;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        moveZeroes(new int[]{23, 1, 4, 3, 5, 2});
        int[] ints = {23, 1, 4, 3, 5, 2};
        System.out.println(getMiddle1(ints, 0, ints.length - 1, 4));
    }

    //快排
    public static void moveZeroes(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] a, int low, int high) {
        if (a == null || low >= high || a.length <= 1) {
            return;
        }
        //如果不加这个判断递归会无法退出导致堆栈溢出异常
        int middle = getMiddle(a, low, high);
        quickSort(a, low, middle - 1);
        quickSort(a, middle + 1, high);
    }

    private static int getMiddle(int[] a, int low, int high) {
        int temp = a[low];//基准元素
        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        // 填充中间元素
        a[low] = temp;
        return low;
    }

    /**
     * 快排的变种 寻找第k大的
     * 相当于找第k个数
     * @param a
     * @param low
     * @param high
     * @param k
     * @return
     */
    private static int getMiddle1(int[] a, int low, int high, int k) {
        int s = low;
        int e = high;
        // 一次找中间位置的排序
        while (low < high) {
            int temp = a[low];
            while (a[high] < temp && low < high) {
                high--;
            }
            a[low] = a[high];
            while (a[low] > temp && low < high) {
                low++;
            }
            a[high] = a[low];
            a[low] = temp;
        }
        // 下一次寻找的区间
        if (low < k - 1) {
            return getMiddle1(a, low + 1, e, k);
        } else if (low > k - 1) {
            return getMiddle1(a, s, low - 1, k);
        } else {
            return a[low];
        }
    }
}
