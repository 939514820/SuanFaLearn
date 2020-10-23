package string;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLengthStr {
    //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    //
    //示例 1：
    //
    //输入: "babad"
    //输出: "bab"
    //注意: "aba" 也是一个有效答案。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/longest-palindromic-substring
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int index = 0;
        int len = s.length();
        //暴力递归
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (j - i + 1 > maxLen && isNeedStr(chars, i, j)) {
                    index = i;
                    maxLen = j - i + 1;
//                    System.out.println("index="+index);
//                    System.out.println("maxlen="+maxLen);
                }
            }
        }
        return s.substring(index, index + maxLen);
    }

    private static boolean isNeedStr(char[] chars, int i, int j) {
        while (j > i) {
            if (chars[i] != chars[j]) {
                return false;
            }
            j--;
//            System.out.println("j="+j);
            i++;
//            System.out.println("i="+i);
        }
        return true;
    }

    /**
     *
     * @param s
     * @return 动态规划
     */
    public static String longestPalindrome1(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int index = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        //暴力递归
        boolean[][]dp=new boolean[len][len];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
        }
        //开始计算
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    // 三个字符 两边相等的情况
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 记录最长子串
                if (dp[i][j]&&(j - i + 1 > maxLen) ) {
                    index = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(index, index + maxLen);
    }

    /**
     *
     * @param s
     * @return 无重复字符的最长字串
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {return 0;}
        int maxlen = 0;
        Queue<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!queue.contains(c)) {
                queue.offer(c);

            } else {
                while (queue.contains(c)) {
                    queue.poll();
                }
                queue.offer(c);

            }
            maxlen = Math.max(maxlen, queue.size());
        }
        return maxlen;
    }
}
