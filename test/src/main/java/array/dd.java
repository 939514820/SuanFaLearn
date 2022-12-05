package array;

import java.util.*;

public class dd {
    // 1 2 3
    // n 台阶 1 1 2 3
    // 输出每一种 路径
    static List<List<String>> res = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        s1(4, new ArrayList());
        System.out.println(Arrays.asList(res.toArray()).toString());
//        System.out.println(map.toString());
    }

    public static int get(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return n;
        } else if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = get(n - 1) + get(n - 2);
            map.put(n, value);
            return value;
        }
    }

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    //
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    // 当前 n -step while(差>0)
    // 走楼梯的路径
    public static void s(int n) {
        int step = n;
        int cur = n;
        while (step > 0) {
            System.out.println("step=" + step);
            List list = new ArrayList();
            while (cur > 0) {
                int curTemp = cur;
                cur = cur - step;
                if (cur > 0) {
                    if (cur <= step) {
                        list.add(cur);
                    } else {
                        list.add(step);
                    }
                } else if (cur == 0) {
                    list.add(curTemp);
                } else {
                    list.add(n - (curTemp));
                    cur = 0;
                }
                System.out.println(list);
            }

            if (cur == 0) {
                res.add(list);
                step--;
                cur = n;
            }
        }


    }

    public static void s1(int n, List list) {
        System.out.println(list);
        if (n == 0) {
            return;
        }
        int cur = n;

        cur = cur - 1;
        list.add(1);
        list.add(cur);
        res.add(list);
        if (cur > 1) {
            list=list.subList(0, list.size()-1);
            s1(cur,list );
        }
    }

    // 不同路徑的數量

    /**
     *
     * @param m
     * @param n dp[i][j]標識 走到當前經過的路徑zong數 dp[i][j]=dp[i-1][j]+dp[i][j-1]
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //
//void rotate(vector<vector<int>>& matrix) {
//    int n = matrix.size();
//
//    for(int i=0 ; i<n ; ++i){
//        for(int j = 0 ; j<i ; ++j){
//            swap(matrix[i][j], matrix[j][i]);
//        }
//    }
//
//    for(int i=0 ; i<n ; ++i){
//        for(int j=0 ; j<n/2 ; ++j){
//            swap(matrix[i][j], matrix[i][n-1-j]);
//        }
//    }
//
//}


}
