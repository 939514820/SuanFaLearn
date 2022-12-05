package string;

public class KMP {
    public static void main(String[] args) {
        System.out.println(isMatch("ABCDABCBD", "ABCBD"));
    }

    public static int isMatch(String s, String pattern) {
        int[] next = getNext(pattern);
        int i = 0;
        int j = 0;
        while (i < s.length() && j < pattern.length()) {
            if (j == -1 || s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < pattern.length()) {
            // 开始或者未匹配到的情况
            // 第一次开始
            if (j == -1) {
                i++;
                j++;
                //自己与自己匹配
            } else if (pattern.charAt(i) == pattern.charAt(j)) {
                // 匹配就赋值下次开始位置
                i++;
                j++;
                next[i] = j;
            } else {
                // 定位到重新开始位置
                j = next[j];
            }
        }
        System.out.println(next);
        return next;
    }


}
