package tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TreeTest01 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int kthSmallest(TreeNode root, int k) {

        if (null == root) {
            return -1;
        }

        // 记录经历根节点
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        // 找左节点
        TreeNode cur = root;
        while (cur != null || !nodeStack.isEmpty()) {

            while (null != cur) {
                nodeStack.push(cur);
                cur = cur.left;
            }
            cur = nodeStack.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            cur = cur.right;
        }

        return -1;
    }

    public static void main(String[] args) {
        // 1
        //5   2
        //   3  6
        //  4
        // 遍历二叉树
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.right = node2;
        node1.left = node5;
        node2.left = node3;
        node2.right = node6;
        node3.right = node4;
//        node3.left = node7;
//        System.out.println(kthSmallest(node1, 3));

//        System.out.println(getResult(node1));
//        String[] serilized = getSerilized(node1);

//        System.out.println(Arrays.toString(serilized));
//        System.out.println(getMaxDistance(node1)[0]);
        int[] maxhappy = getMaxhappy(node1);
        System.out.println(Math.max(maxhappy[0], maxhappy[1]));
//        System.out.println(getDSerilized(serilized, 0));
    }

    // 判断一个树是不是平衡二叉树
    public static boolean getResult(TreeNode root) {
        if (null == root) {
            return false;
        }
        return isBalanced(root)[0] == 1;
    }

    private static int[] isBalanced(TreeNode node) {
        if (node == null) return new int[]{1, 0};
        int[] a = isBalanced(node.left);
        int[] b = isBalanced(node.right);
        // 高度
        int height = Math.max(a[1], b[1]) + 1;
        // 是否平衡&&是否XXX
        boolean isBalance = (a[0] == 1 && b[0] == 1 && Math.abs(a[1] - b[1]) < 2);
        return new int[]{isBalance ? 1 : 0, height};
    }

    /**
     * 左右两边的最远距离或者 当前节点左边和当前节点右边(高度)
     *
     * @param node
     * @return
     */
    private static int[] getMaxDistance(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] a = getMaxDistance(node.left);
        int[] b = getMaxDistance(node.right);
        int maxDis = Math.max(a[1] + b[1] + 1, Math.max(a[0], b[0]));
        int maxheight = Math.max(a[1], b[1]) + 1;
        return new int[]{maxDis, maxheight};
    }

    private static int[] getMaxhappy(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] a = getMaxhappy(node.left);
        int[] b = getMaxhappy(node.right);
        int curMax = node.val + a[1] + b[1];
        int curMaxNot = a[0] + b[0];
        return new int[]{curMax, curMaxNot};
    }

    /**
     * 序列化 前序遍历
     * 应该是用前序遍历
     *
     * @param node
     * @return
     */
    public static String[] getSerilized(TreeNode node) {
        StringBuilder a = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            String val = cur.val == -1 ? "#" : String.valueOf(cur.val);
            a.append(val).append(",");
            if (!"#".equals(val)) {
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    stack.push(new TreeNode(-1));
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                } else {
                    stack.push(new TreeNode(-1));
                }
            }

        }
        return a.toString().split("\\,");
    }

    // 反序列化 使用层次遍历
    public static TreeNode getDSerilized(String[] split) {

        int len = split.length;
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));

        int curindex = 0;

        return root;

    }

    /**
     * 针对完全二叉树的解法
     * <p>
     * 满二叉树的结点数为：2^depth - 1
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {// 左子树是满二叉树
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (1 << leftDepth) + countNodes(root.right);
        } else {// 右子树是满二叉树
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;

//        作者：carlsun-2
//        链接：https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-er-ch-iz5t/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
