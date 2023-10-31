package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Iterator {
    public static void main(String[] args) {
        // 1
        //2  3
        // 5   4
        // 遍历二叉树
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.right = node4;
//        middleVisit(node1);
        middleMethod(node1);
    }

    public static void middleVisit(TreeNode root) {
        middleDfs(root);
    }

    public static void middleDfs(TreeNode node) {
        if (node == null) {
            return;
        }
        middleVisit(node.left);
        System.out.println(node.val);
        middleVisit(node.right);
    }

    // 判断是否是平衡二叉树 重点在于求二叉树的深度 深度优先遍历
    // 中序遍历
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        // 记录经历根节点
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null) {
            nodeStack.push(cur);
            cur = cur.left;
        }
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            list.add(node.val);
            if (null != node.right) {
                nodeStack.push(node.right);
            }
        }
        return list;
    }

    // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        // 记录经历根节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }

    public static void middleMethod(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null) {
            stack.add(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            TreeNode curRoot = stack.pop();
            System.out.println("cur:" + curRoot.val);
            curRoot = curRoot.right;
        }
    }
//后序遍历
// 层次遍历

}
