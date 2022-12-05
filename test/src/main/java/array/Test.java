package array;

import java.util.Arrays;

public class Test {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        if (nums.length == 1 || k == 1) {
            return nums;
        }
        int index = 0;
        int s = 0;
        int j = 0;
        while (index < res.length) {

            int max = Integer.MIN_VALUE;
            //每一个滑动窗口 从i->i+k
            for (int i = s; i < s + k; i++) {
                max = Math.max(max, nums[i]);
                if (j - s + 1 == k) {
                    res[index] = max;
                    index++;
                } else {
                    j++;
                }

            }
            // 初始化
            s++;
            j = s;

        }
        return res;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] a = new int[]{7, 2, 4};

        System.out.println(Arrays.toString(maxSlidingWindow(a, 2)));
    }
}
