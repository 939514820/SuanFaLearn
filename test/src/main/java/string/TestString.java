package string;

import java.util.*;

public class TestString {
    public static void convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int len = s.length();
        int start = 0;
        boolean shuFlag = true;
        for (int i = 0; i < len; i++) {
            // 竖着
            if (shuFlag) {
                sb[start].append(s.charAt(i));
                if (start == numRows - 1) {
                    shuFlag = false;
                } else {
                    start++;
                }
            } else {
                start--;
                // 横着
                for (int j = 0; j < sb.length; j++) {
                    if (start != j) {
                        sb[j].append(" ");
                    }
                }
                sb[start].append(s.charAt(i));
                if (start == 1) {
                    start = 0;
                    shuFlag = true;
                }

            }
        }

        for (int i = 0; i < sb.length; i++) {
            System.out.println(sb[i].toString());
        }
    }

    public static void main(String[] args) {

//        convert("LEETCODEISHIRING", 4);
//        String a = "1";
//        String a2 = "1";
//        String a3 = new String("1");
//        String a4 = String.valueOf(1);
//        System.out.println(a == a2);
//        System.out.println(a == a3);
//        System.out.println(a == a4);
//        System.out.println(a.equals(a3));
//        System.out.println(a.equals(a2));
//
//        Integer b = 127;
//        Integer b1 = new Integer(127);
//        Integer b2 = Integer.valueOf(127);
//        Integer b3 = Integer.valueOf(129);
//        Integer b4 = 129;
//        System.out.println(b == b1);
//        System.out.println(b == b2);
//        System.out.println(b3 == b4);
        //Integer类型 默认-128---127存储在方法区，之外数据存储在堆中

//        String a = new String("aw");
//        String b = new String("aw");
//        String c= "aa";
//        String d= "aa";
//
//        System.out.println(a==b);//false
//        System.out.println(c==d);//true

        List<String> abcd = getZuhe("123");
        for (String s : abcd) {
            System.out.print(s + " ");
            System.out.println();
        }
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(grid));
        System.out.println(grid.length);
        System.out.println(grid[0].length);
    }

    public boolean isValid(String s) {
        // write code here
        Map<Character, Character> map = new HashMap();
        Stack<Character> stack = new Stack();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        stack.push(s.charAt(0));
        int i = 1;
        while (i < s.length()) {
            Character top = stack.peek();
            Character cur = s.charAt(i);
            if (cur == map.get(top)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }
        return stack.isEmpty();
    }


    //N叉树深度优先搜索
//    private void DFS(String s, int start, int end, boolean[][] isPalindrome) {
//        if (start > end) {
//            List<String> l = new ArrayList<>();
//            l.addAll(path);
//            res.add(l);
//            return;
//        }
//        //N叉树分支遍历
//        for (int len = 1; len <= end - start + 1; len++) {
//
//            if (!isPalindrome[start][start + len - 1]) continue;
//            //路径添加本分段
//            path.add(s.substring(start, start + len));
//            //下层继续深度优先搜索
//            DFS(s, start + len, end, isPalindrome);
//            //路径删除本分段
//            path.remove(path.size() - 1);
//        }
//    }
    static boolean[] used;

    public static List<String> getZuhe(String str) {
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>(str.length());
        used = new boolean[str.length()];
        dfs(str, res, path);
        return res;
    }

    private static void dfs(String str, List<String> res, List<String> path) {
        if (path.size() == str.length()) {
            String s = path.toString();
            if (!res.contains(s)) {
                res.add(s);
            }
            path = new ArrayList<>(str.length());
        }
        for (int i = 0; i < str.length(); i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(String.valueOf(str.charAt(i)));
            dfs(str, res, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    //    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//    岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//    此外，你可以假设该网格的四条边均被水包围。
    public static int numIslands(char[][] grid) {
//        boolean[][] used = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    int i1 = dfsGrid(grid, i, j);
                    System.out.println(i1);
                    res = Math.max(res, i1);
                }

            }
        }
//        for (int i = 0; i < grid.length; i++) {
//            for (int i1 = 0; i1 < grid[i].length; i1++) {
//                System.out.print(grid[i][i1] + ",");
//            }
//            System.out.println();
//        }
        return res;
    }
    static boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }


    private static int dfsGrid(char[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) {
            return 0;
        }

        if (grid[i][j] != '1') {
            return 0;
        }
        grid[i][j] = '2';
        return 1 +
                dfsGrid(grid, i, j - 1) +
                dfsGrid(grid, i, j + 1) +
                dfsGrid(grid, i - 1, j) +
                dfsGrid(grid, i + 1, j);

    }


}
