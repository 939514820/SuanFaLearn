package array;

/**
 * 找子序列
 */
public class findSubsequence {
    public static void main(String[] args) {

    }


    public int lengthOfLIS(int[] nums) {
        // 每一个以num[i]截止的子串的最大长度
        if (nums.length == 0) return 0;
        int max = 0;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            // 每一个结尾的中找最大的
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
