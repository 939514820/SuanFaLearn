package tree;

import java.util.*;

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
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList();
        Deque<TreeNode> stack = new LinkedList();
        if (root == null)
            return res;
        else
            stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p != null) {
                if (p.right != null) stack.push(p.right);
                if (p.left != null) stack.push(p.left);
                stack.push(p);
                stack.push(null);
            } else { // 栈为空，说明遇到标记，执行方法内部的访问节点操作
                res.add(stack.pop().val);
            }
        }
        return res;
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
//        System.out.println(inorderTraversal(node1));
        System.out.println(preorderTraversal(node1));
//        System.out.println(inorderTraversal2(node1));
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
            // 根节点
            TreeNode node = nodeStack.pop();
            list.add(node.val);
            cur = node.right;
        }
        return list;
    }

    // 层次遍历一棵树
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        // 根节点
        Queue<TreeNode> curRoot = new LinkedList<TreeNode>();
        Queue<TreeNode> child = new LinkedList<TreeNode>();
        TreeNode cur = root;
        curRoot.add(cur);
        int i=0;
        while(!curRoot.isEmpty()){
            while (!curRoot.isEmpty()) {
                TreeNode node = curRoot.poll();
                list.add(node.val);
                if(child.isEmpty()){
                    if (node.left != null) {
                        child.add(node.left);
                    }
                    if (node.right != null) {
                        child.add(node.right);
                    }
                }

            }
            // 根队列空
            while (!child.isEmpty()){
                TreeNode node1 = child.poll();
                curRoot.add(node1);
            }
            // 子队列空
            i++;
            System.out.println("第"+i+"层数");
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
