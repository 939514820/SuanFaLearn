package tree;

import java.util.*;

public class TreeTest {
    // 中序遍历：左根右
    // 非迭代：一直找左节点直到为空 转到中间节点 再转到右节点 递归的调用过程是不断往左边走，当左边走不下去了，就打印节点，并转向右边，然后右边继续这个过程。
    //我们在迭代实现时，就可以用栈来模拟上面的调用过程。
    // 前序遍历： 根左右
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //初始化栈，并将根节点入栈；
    //当栈不为空时：
    //弹出栈顶元素 node，并将值添加到结果中；
    //如果 node 的右子树非空，将右子树入栈；
    //如果 node 的左子树非空，将左子树入栈；
    //
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList();
        Deque<TreeNode> stack = new LinkedList();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return res;
    }
    // 后序遍历
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList();
        LinkedList<Integer> res = new LinkedList();
        if (root == null) {
            return res;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            res.addFirst(node.val);//每次在链表的头部插入元素
            if (node.left != null) {  //注意与前序对比着看
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // 1
        //5  2
        //  3  6
        //   4
        // 遍历二叉树
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.right = node2;
        node1.left=node5;
        node2.left = node3;
        node2.right=node6;
        node3.right = node4;
//        System.out.println(inorderTraversal(node1));
//        System.out.println(preorderTraversal(node1));
        System.out.println(preorderTraversal(node1));
        System.out.println(postorderTraversal(node1));

    }

    // 递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        get(root, list);
        return list;
    }

    // 中序列遍历
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
            if (cur.left != null) {
                nodeStack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = nodeStack.pop();
                list.add(pop.val);
                cur = cur.right;
            }
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
        int i = 0;
        while (!curRoot.isEmpty()) {
            while (!curRoot.isEmpty()) {
                TreeNode node = curRoot.poll();
                list.add(node.val);
                if (node.left != null) {
                    child.add(node.left);
                }
                if (node.right != null) {
                    child.add(node.right);
                }

            }
            // 根队列空
            while (!child.isEmpty()) {
                TreeNode node1 = child.poll();
                curRoot.add(node1);
            }
            // 子队列空
            i++;
            System.out.println("第" + i + "层数");
        }

        return list;
    }
}
