package array;

import java.util.Arrays;

public class findMiddle {
    //给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
    //
    //请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    //
    //你可以假设 nums1 和 nums2 不会同时为空。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    // 思路一 先排序重新组成一个新的数组 然后找中位数 注意的地方：转double的运算
    // 思路二 明确要找数组中的拿几个数，用两个指针
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int len = nums1.length + nums2.length;
        int[] sum = new int[len];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                sum[index++] = nums1[i];
                i++;
            } else {
                sum[index++] = nums2[j];
                j++;
            }
        }
        while (i < nums1.length) {

            sum[index++] = nums1[i];
            i++;
        }
        while (j < nums2.length) {

            sum[index++] = nums2[j];
            j++;
        }


        if (sum.length % 2 == 0) {
            // 如果是偶数
            return (double) (sum[len / 2 - 1] + sum[len / 2]) / 2;
        } else {
            return (double) sum[len / 2];
        }
    }

    //快排
    public static void moveZeroes(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) { //如果不加这个判断递归会无法退出导致堆栈溢出异常
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
//        System.out.println("========"+a[low]);
//        getMiddle1(a, low, high,3);
    }

    private static int getMiddle(int[] a, int low, int high) {
        int temp = a[low];//基准元素
        while (low < high) {
            int aHigh = a[high];
            while (low < high && aHigh >= temp) {
                high--;
            }
            a[low] = aHigh;
            int aLow = a[low];
            while (low < high && aLow <= temp) {
                low++;
            }
            a[high] = aLow;
        }
        a[low] = temp;
        return low;
    }

    private static int getMiddle1(int[] a, int low, int high, int k) {
        int s = low;
        int t = high;
        if (low < high) {
            int temp = a[low];//基准元素


            while (low != high) {
                while (low < high && a[high] <= temp) {
                    high--;
                }
                a[low] = a[high];
                while (low < high && a[low] >= temp) {
                    low++;
                }
                a[high] = a[low];
            }
            a[low] = temp;

            if (k - 1 == low) {
                return a[low];
            } else if (k - 1 > low) {
                // 下次
                return getMiddle1(a, low + 1, t, k);
            } else {
                return getMiddle1(a, s, low - 1, k);
            }
        } else if (low == high && low == k - 1)  //区间内只有一个元素，且为 nums[k - 1]
            return a[k - 1];
        return -1;

    }

    public static int QuickSelect(int[] nums, int s, int t, int k) {
        int i = s;
        int j = t;
        int tmp;

        if (s < t) {
            tmp = nums[s];
            while (i != j) {
                while (j > i && nums[j] <= tmp)
                    j--;
                nums[i] = nums[j];

                while (i < j && nums[i] >= tmp)
                    i++;
                nums[j] = nums[i];
            }

            nums[i] = tmp;

            //如果 i == k - 1, 那么 nums[i] 便是第 k 小的元素
            if (k - 1 == i)
                return nums[i];
            else if (k - 1 < i)
                return QuickSelect(nums, s, i - 1, k);
            else
                return QuickSelect(nums, i + 1, t, k);
        } else if (s == t && s == k - 1)  //区间内只有一个元素，且为 nums[k - 1]
            return nums[k - 1];

        return -1;
    }


    public static void main(String[] args) {
        int[] a = new int[]{9, 1, 4, 3, 12};
//        moveZeroes(a);
        System.out.println(Arrays.toString(a));
//        System.out.println(QuickSelect( a,0, a.length - 1, 5));
        System.out.println(getMiddle1(a, 0, a.length - 1, 5));
        System.out.println(Arrays.toString(a));
    }
}
