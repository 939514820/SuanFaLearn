package tree;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * 字符串排列組合
 */
public class DFS {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(permutation("ab")));
//        System.out.println((letterCombinations("234")));
        pailie("abc");
//        String s = new DFS().code(15620982798L);
//        String s2 = new DFS().decode(s);
//        System.out.println("s=" + s);
////
//        System.out.println("s2=" + s2);
//
//        String s1 = new DFS().code(1240L);
//        String s3 = new DFS().decode(s1);
//
//        System.out.println("s=" + s1);
//        System.out.println("s2=" + s3);

    }

    private static List<String> list = new ArrayList<>();
    private static StringBuilder path = new StringBuilder();
    private static boolean[] used = new boolean[10];

    public static String[] permutation(String S) {
        dfs(S);
        String[] res = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static void dfs(String S) {
        if (path.length() == S.length()) {
            list.add(new String(path.toString()));
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if (!used[i]) {
                path.append(S.charAt(i));
                used[i] = true;
                dfs(S);
                used[i] = false;
                // 回溯到之前节点
                System.out.println(path.toString());
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public void dfs1(String str) {
        if (path.length() == str.length()) {
            list.add(new String(path.toString()));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                path.append(str.charAt(i));
                used[i] = true;
                dfs1(str);
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }


    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        int len = digits.length();
        LinkedList<String> queue = new LinkedList<>();
        LinkedList<String> middle1 = new LinkedList<>();
        LinkedList<String> middle2 = new LinkedList<>();
        int i = 1;

        String[] array1 = convert(digits.charAt(0));
        for (int i1 = 0; i1 < array1.length; i1++) {
            middle1.add(array1[i1]);
        }
        // 根 append 当前每一个
        while (i < len) {
            String[] array2 = convert(digits.charAt(i));
            for (int i1 = 0; i1 < middle1.size(); i1++) {
                for (int i2 = 0; i2 < array2.length; i2++) {
                    String s = middle1.get(i1) + array2[i2];
                    middle2.add(s);
                    if (s.length() == len) {
                        queue.add(s);
                    }
                }
            }
            i++;
            middle1 = middle2;
            middle2 = new LinkedList<>();

        }

        return queue;
    }

    static String[] convert(Character character) {
        String[] list = new String[4];
        if (character == '2') {
            list = new String[]{"a", "b", "c"};
        }
        if (character == '3') {
            list = new String[]{"d", "e", "f"};
        }
        if (character == '4') {
            list = new String[]{"g", "h", "i"};
        }
        if (character == '5') {
            list = new String[]{"j", "k", "l"};
        }
        if (character == '6') {
            list = new String[]{"m", "n", "o"};
        }
        if (character == '7') {
            list = new String[]{"p", "q", "r", "s"};
        }
        if (character == '8') {
            list = new String[]{"t", "u", "v"};
        }
        if (character == '9') {
            list = new String[]{"w", "x", "y", "z"};
        }
        return list;
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isPingHeng(TreeNode root) {
        if (root == null) {
            return true;
        }
        int h = height(root.left) - height(root.right);
        return Math.abs(h) == 1 || h == 0;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }


    public static void pailie(String s) {
        boolean[] use = new boolean[s.length()];
        String res = "";
        dfs1(s, use, res);
    }

    private static void dfs1(String s, boolean[] use, String res) {
        if (res.length() == s.length()) {
            System.out.println(res);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!use[i]) {
                use[i] = true;
                res += s.charAt(i);
                dfs1(s, use, res);
                use[i] = false;
                System.out.println("中間結果=" + res);
                res = res.substring(0, res.length() - 1);
            }
        }
    }

    //    第64题-最小路径和
//    给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//    说明：每次只能向下或者向右移动一步。
//
//    示例 1：
//
//    img
//
//    输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//    输出：7
//    解释：因为路径 1→3→1→1→1 的总和最小。
    // 岛屿数量
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == '1') {
                    findAround(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void findAround(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return;
        }
        //标记当前元素周围节点 向四周扩散结束算一次
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            findAround(grid, i, j - 1);
            findAround(grid, i, j + 1);
            findAround(grid, i - 1, j);
            findAround(grid, i + 1, j);
        }
    }

    //grid =
    // [
    // ["2","2","2","2","0"],
    // ["2","2","0","2","0"],
    // ["2","2","0","0","0"],
    // ["0","0","0","0","0"] ]
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    //    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    private static String[] dict = new String[]{
            "0",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "D1", "E1", "F1", "G1", "H1", "I1", "J1",
            "K1", "L1", "M1", "N1", "O1", "P1", "Q1", "R1",
            "S1", "T1", "U1", "V1", "W1", "X1", "Y1", "Z1", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    static Map<String, Integer> map = new HashMap<>();

    static {
        for (int i = 0; i < dict.length; i++) {
            map.put(dict[i], i);
        }
    }

    public String code(long num) {
        String result = "";

        long n = num;


        while (n > 1) {
            long cur = n / 62;
            Long yu = n % 62;
            n = cur;
            result = dict[yu.intValue()] + result;
        }
        // 當前算出來是各位 疊加到前邊

        return result;

    }

    public String decode(String num) {
        String r = "";
        Long res = 0L;
        int n = num.length();
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            // 前一位*進制+當前位置數*62的N-1-i 次方   當前算出來是各位 疊加之前值
            int ii = map.get(String.valueOf(num.charAt(i)));
            res = res + ii * get62(index);
            index++;
        }
        return String.valueOf(res);
    }

    public Long get62(int n) {
        if (n == 0) {
            return 1L;
        }
        if (n == 1) {
            return 62L;
        } else {
            return 62 * get62(n - 1);
        }
    }


}
