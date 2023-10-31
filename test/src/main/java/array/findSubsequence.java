package array;

import java.util.Arrays;

/** 如果子序列无序 需要从头到当前算一遍
 * 有序可以从当前往回找
 * 找子序列 最长递增子序列
 */
public class findSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS1(new int[]{0,1,0,3,2,3}));
        System.out.println(lengthOfLIS1(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS1(new int[]{7,7,7,7,7,7,7}));
    }

    /**
     * 最长递增子序列
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        // 每一个以num[i]截止的子串的最大长度
        if (nums.length == 0) return 0;
        int max = 0;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            // 初始化dp[i]
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 到当前字符串为止最大连续子串长度
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            // 每一个结尾的中找最大的
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int lengthOfLIS1(int[] nums) {
        // 每一个以num[i]截止的子串的最大长度
        if (nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int max=1;
        for (int i = 1; i < nums.length; i++) {
            // 初始化dp[i]

            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                int j = i - 1;
                boolean flag = false;
                while (j >= 0) {
                    if (nums[j] < nums[i]) {
                        dp[i] = dp[j] + 1;
                        flag = true;
                        break;
                    }
                    j--;
                }
                if (!flag) {
                    dp[i] = 1;
                }
            }

            // 每一个中找最大的
            max = Math.max(max, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

}
