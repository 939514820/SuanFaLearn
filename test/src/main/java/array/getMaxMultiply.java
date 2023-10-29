package array;

import java.util.Arrays;

public class getMaxMultiply {
    /**
     * 乘积最大子数组
     *
     * @param nums dp 以当前数结尾乘积
     * @return
     */
    public static int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        // 最大乘积
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            // 当前数，前一个最大*当前，前一个最小*当前 取最大  当前数 当前前一个*当前 前一个最小*当前
            // 当前数，前一个最小*当前，前一个最小*当前 取最小 处理正负
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{0, 2}));
    }

    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
