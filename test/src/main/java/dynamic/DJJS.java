package dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 打傢結社
 */
public class DJJS {
    public static int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i - 1], dp[i - 2] + nums[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }
}
