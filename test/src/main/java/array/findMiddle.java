package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        int i = 0, j = 0;
        int start = 0;
        int end = 0;

        int len = nums1.length + nums2.length;

        while ((i < len / 2) || (j < len / 2)) {
            // 外层是或 边界处理
            if (nums1[i] < nums2[j] && i < nums1.length - 1) {
                start = nums1[i];
                i++;
            } else {
                end = nums2[j];
                j++;
            }
        }
        if (len % 2 == 0) {
            return (double) (start + end);
        } else {
            return (double) (end);
        }
    }






    // 寻找第K大的 数组第k-1个 从大到小第k个数，
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


    // 原地删除 [0,0,1,1,1,2,2,3,3,4]
    //         0,1,2,2,3,3,4,3,3,4
    public static int removeDuplicates(int[] nums) {
        // 记录可擦出位置
        // before index
        //
        int Rindex = 0;
        int total = 0;
        Integer bf = null;

        for (int i = 0; i < nums.length; i++) {
            if (null == bf) {
                bf = nums[0];
                Rindex = i;
                continue;
            }
            // 相等记录位置
            if (nums[i] == bf) {
                if (Rindex == 0) {
                    Rindex = i;
                }

            } else {
                if (Rindex > 0) {
                    // 不等移动当前元素
                    nums[Rindex] = nums[i];
                    Rindex++;
                }
                bf = nums[i];
                total++;
            }
        }
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println(

        );
        return total + 1;
    }

    // 删除指定元素
    public static int removeElement(int[] nums, int val) {
        // 记录可擦出位置
        int total = 0;
        Queue<Integer> black = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {

            // 相等记录位置
            if (nums[i] == val) {
                black.offer(i);
            } else {
                if (black.size() > 0) {
                    // 不等移动当前元素
                    Integer index = black.poll();
                    nums[index] = nums[i];
                    //
                    black.offer(i);
                }
                total++;
            }
        }
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println();
        return total;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 1, 4, 3, 12};
        int[] a1 = new int[]{1, 2};
//      int[] a2 = new int[]{1,1,1,2};
        int[] a2 = new int[]{1, 2, 2};
        int[] a3 = new int[]{3, 2, 2, 3};
        int[] a4 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};

        // 0,1,1,1,1,2,2,3,3,4
        System.out.println(Arrays.toString(a));
//        System.out.println(QuickSelect( a,0, a.length - 1, 5));
//        System.out.println(getMiddle1(a, 0, a.length - 1, 5));
//        System.out.println(Arrays.toString(a));
//        System.out.println(findMedianSortedArrays1(a1,a2));
//        System.out.println(removeDuplicates(a2));
//        System.out.println(removeElement(a4, 2));


        HashMap<Integer, Integer> map = new HashMap<>();
        Integer obj = map.put(1, 1);
        Integer obj1 = map.put(1, 1);
        System.out.println(obj);
        System.out.println(obj1);
    }

}
