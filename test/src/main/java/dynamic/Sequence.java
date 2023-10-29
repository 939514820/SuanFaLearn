package dynamic;

import java.util.Arrays;

public class Sequence {
    public static int seqMax(int[] a) {

        int[] dp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                System.out.println("i= " + i + Arrays.toString(dp));
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[a.length - 1];
    }
//如果找具体的递增子序列 dp[j]=dp[i]-1&&arr[j]<arr[i]
    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(seqMax(a));
    }
}
