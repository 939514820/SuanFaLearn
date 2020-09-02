package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTest {
    // 中序遍历：左根右
    // 前序遍历： 根左右
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        // 1
        //   2
        //  3
        //   4
        // 遍历二叉树
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.right = node2;
        node2.left = node3;
        node3.right = node4;
        System.out.println(inorderTraversal(node1));
        System.out.println(inorderTraversal1(node1));
    }

    // 递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        get(root, list);
        return list;
    }

    public static void get(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            get(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            get(root.right, list);
        }
    }

    // 非递归 中序遍历
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        // 记录经历根节点
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        // 找左节点
        TreeNode cur = root;
        while (cur != null || !nodeStack.isEmpty()) {
            // 找到最左端的节点
            while (cur != null) {
                nodeStack.push(cur);
                cur = cur.left;
            }
            TreeNode node = nodeStack.pop();
            list.add(node.val);
            cur = node.right;
        }
        return list;
    }

//    public List < Integer > inorderTraversal(TreeNode root) {
//        List < Integer > res = new ArrayList  ();
//        Stack < TreeNode > stack = new Stack ();
//        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()) {
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
//            res.add(curr.val);
//            curr = curr.right;
//        }
//        return res;
//    }
}
