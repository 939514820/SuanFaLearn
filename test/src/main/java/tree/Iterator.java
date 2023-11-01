package tree;

import java.util.*;

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
//        middleMethod(node1);
//        zMethod(node1);
        beforeMethod(node1).toString();
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
            if (null != curRoot.right) {
                stack.push(curRoot.right);
            }
        }
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

    public static void zMethod(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> r = new LinkedList<>();
        Queue<TreeNode> c = new LinkedList<>();
        int index = 0;
        r.add(root);
        while (!r.isEmpty()) {
            while (!r.isEmpty()) {
                TreeNode node = r.poll();
                System.out.println(index + "=:" + node.val);
                if (node.left != null) {
                    c.add(node.left);
                }
                if (node.right != null) {
                    c.add(node.right);
                }
            }
            while (!c.isEmpty()) {
                r.add(c.poll());
            }
            index++;
        }
    }

    public static List<Integer> beforeMethod(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            result.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return result;
    }
//后序遍历
// 层次遍历

}
