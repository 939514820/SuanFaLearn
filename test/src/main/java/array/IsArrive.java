package array;

import java.util.Arrays;

public class IsArrive {
//    给定一个非负整数数组，你最初位于数组的第一个位置。
//
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//    判断你是否能够到达最后一个位置。
//
//    示例 1:
//
//    输入: [2,3,1,1,4]
    // 到当前为止的最大和 >=i
    public static void main(String[] args) {
        System.out.println(isArrive(new int[]{2, 3, 1, 1, 4}));
        System.out.println(isArrive(new int[]{3, 2, 1, 0, 4}));
        System.out.println(isArrive(new int[]{1, 2}));
        System.out.println(isArrive(new int[]{0, 2, 3}));
    }

    public static boolean isArrive(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            // max>=i 才是可达的
            if (max >= i) {
                max = Math.max(max, i + nums[i]);
                if (max >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
    //    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
//    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
//    问总共有多少条不同的路径？
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/unique-paths
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// 走到当前位置有多少方法
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    // 就是先根据左边界进行排序，排序完之后进行进行区间合并，合并的判断规则就是当前区间的左边界是否在上一个区间内。

//    第169题-多数元素
//    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于n/2 的元素。
//
//    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//    示例 1:
//
//    输入: [3,2,3]
//    输出: 3

    // 遍历一遍并且计数 遇到值》的 list.add()
    // 这个多数元素一定是数组的中位数，所以可以转换为寻找数组的中位数，
    // 也就是寻找第nums.length/2小的元素，也就转换为Top K问题了，所以使用快排解决。


}
