package string;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.aliyun.openservices.shade.com.alibaba.fastjson.JSONArray;

import java.util.*;

public class Test {
    // 评测题目: 链表转化
// 输入:
// 给定一组节点，以及每个节点前序节点的ID，将其恢复成一个链表
// 输入
//[
//   { id: 2, pre: 33 },
//   { id: 33, pre: 24 },
//   { id: 24, pre: 11 },
//   { id: 11 },
//   { id: 5, pre: 2 },
// ]
// 实际链表数据顺序：[11,24,33,2,5]
// 输出（以JSON的方式打印）:
// {
// id:11,
// next:{
//     id:24, pre: 11
//     next:{
//         id:33, pre:24
//         next: {
//             id: 2, pre: 33
//             next: {
//                 id: 5, pre: 2
//                 }
//             }
//         }
//     }
// }

    public static class C {
        private Integer id;
        private B next;

        public void setId(Integer id) {
            this.id = id;
        }

        public void setNext(B next) {
            this.next = next;
        }

        public Integer getId() {
            return id;
        }

        public B getNext() {
            return next;
        }
    }

    public static class B {
        private Integer id;
        private Integer pre;
        private B next;

        public void setId(Integer id) {
            this.id = id;
        }

        public void setPre(Integer pre) {
            this.pre = pre;
        }

        public void setNext(B next) {
            this.next = next;
        }

        public B getNext() {
            return next;
        }

        public Integer getId() {
            return id;
        }

        public Integer getPre() {
            return pre;
        }
    }

    public static void main(String[] args) {
        List<B> list = JSONArray.parseArray("[{ \"id\": 2, \"pre\": 33 },\n" +
                "{ \"id\": 33, \"pre\": 24 },\n" +
                "{ \"id\": 24,\"pre\": 11 },\n" +
                "{ \"id\": 11 },\n" +
                "{ \"id\": 5, \"pre\": 2 } ]", B.class);
        Map<Integer, B> map = new HashMap<>();
        B root = null;
        for (B item : list) {
            if (item.pre == null) {
                root = item;
                continue;
            }
            map.put(item.pre, item);
        }
        Set<Integer> isvisit = new HashSet<>();
        C c = new C();
        c.setId(root.getId());
        c.setNext(new B());
        dfs(root, c.next, map, isvisit);
        System.out.println(JSON.toJSONString(c) + "-" + c.getId());
        System.out.println(longestPalindrome("abccccdd"));
        minCut("ACDCDCDAD");
    }

    public static void dfs(B cur, B obj, Map<Integer, B> map, Set<Integer> isvisit) {
        if (cur == null || isvisit.contains(cur.getId()) || !map.containsKey(cur.getId())) {
            return;
        }
        isvisit.add(cur.getId());
        B pre = map.get(cur.getId());
        obj.setId(pre.getId());
        obj.setPre(pre.getPre());
        obj.setNext(new B());
        dfs(pre, obj.getNext(), map, isvisit);
    }

    public static int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }

        int len = s.length();
        int[][] dp = new int[len][len];
        char[] a = s.toCharArray();
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (a[i] != a[j]) {
                    dp[i][j] = 0;

                } else {
                    if (j - i < 3) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] == 1 && (j - i + 1 > maxLen)) {
                    maxLen = j - i + 1;
                }
            }

        }
        return maxLen;
    }

    public static int minCut(String s) {
        int len = s.length();
        int[][] is = new int[len][len];
        int[] dp = new int[len + 1];
        char[] a = s.toCharArray();
        dp[len] = -1;
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (a[i] == a[j] && (j - i < 2 || is[i + 1][j - 1] == 1)) {
                    is[i][j] = 1;
                    // 每次i-j中最小分割数
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                    System.out.println(Arrays.toString(dp));
                }
            }
        }
        return dp[0];
    }
}
