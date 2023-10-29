import javafx.scene.layout.Priority;
import tree.TreeNode;

import java.sql.SQLOutput;
import java.util.*;

public class TestJD {
//    1. 题目：一个数组 array 和一个数 k ，从数组中移除 k 个元素，找出移除后数组中剩余不同数的最少数量
//    输入：arr = [5,7,1,1,7,7,6], k = 2，输出：2
//    输入：arr = [5,7,1,1,7,7,6,6], k = 2，输出：3

    public static class SNode implements Comparable<SNode> {
        private int value;
        private int couunt;

        public int getCouunt() {
            return couunt;
        }

        public void setCouunt(int couunt) {
            this.couunt = couunt;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public SNode(int value, int couunt) {
            this.value = value;
            this.couunt = couunt;
        }

        // 以次数为维度的小顶堆
        @Override
        public int compareTo(SNode o) {
            return this.couunt - o.getCouunt();
        }
    }

    // 把出现次数最少的移除
    public static int getCount(int[] a, int k) {
        Queue<SNode> queue = new PriorityQueue<>(a.length);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(map.get(a[i]), 1);
            } else {
                map.put(a[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            queue.offer(new SNode(key, map.get(key)));
        }
        while (k > 0) {
            if (!queue.isEmpty()) {
                queue.poll();
            }
            k--;
        }
        return queue.size();
    }

    public static void main(String[] args) {
        System.out.println(getCount(new int[]{5, 7, 1, 1, 7, 7, 6}, 2));
        ;
        STreeNode root=new STreeNode(2);
        STreeNode le=new STreeNode(1);
        STreeNode ri=new STreeNode(3);
        root.left=le;
        root.right=ri;
        System.out.println(getIsTree(root));
        ;
    }

//            2.给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//    假设一个二叉搜索树具有如下特征：
//    节点的左子树只包含小于当前节点的数。
//    节点的右子树只包含大于当前节点的数。
//    所有左子树和右子树自身必须也是二叉搜索树。
//    示例 1: 输入:
//            2
//            / \
//            1   3
//    输出: true
//    示例 2: 输入:
//            5
//            / \
//            1   4
//            / \
//            3   6
//    输出: false 解释: 输入为: [5,1,4,null,null,3,6]。根节点的值为 5 ，但是其右子节点值为 4 。

    public static class STreeNode {
        int val;
        STreeNode left;
        STreeNode right;

        STreeNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    public static boolean getIsTree(STreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root);
    }

    private static boolean dfs(STreeNode root) {
        if (root == null) {
            return true;
        }
        if(root.left!=null&&root.left.val> root.val){
            return false;
        }
        if(root.right!=null&&root.right.val< root.val){
            return false;
        }
        return dfs(root.left)&&dfs(root.right);
    }
}
