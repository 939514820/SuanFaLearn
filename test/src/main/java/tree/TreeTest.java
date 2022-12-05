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
        node1.left = node5;
        node2.left = node3;
        node2.right = node6;
        node3.right = node4;
//        System.out.println(postorderTraversal1(node1));
        System.out.println(Arrays.toString(inorderTraversal1(node1).toArray()));
//        System.out.println(getLevel1(node1));
//        System.out.println(preorderTraversal(node1));
//        System.out.println(preorderTraversal(node1));
//        System.out.println(postorderTraversal(node1));
        ;
        //System.out.println(zigzagLevelOrder(node1));
    }

    // 中序列遍历
    public static void getMiddele(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        getMiddele(root.left, list);
        list.add(root.val);
        getMiddele(root.right, list);
    }

    public static void getBefore(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        getBefore(root.left, list);
        getBefore(root.right, list);
    }

    public static void getAfter(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        getAfter(root.left, list);
        getAfter(root.right, list);
        list.add(root.val);
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

    // 后序遍历 左右根
    public static List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList();
        LinkedList<Integer> res = new LinkedList();
        if (null == root) {
            return res;
        }
        stack.push(root);
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

    // 非递归 中序遍历 左不为空，放左;
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (null == root) {
            return list;
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
            list.add(cur.val);
            cur = cur.right;

        }
        return list;
    }

    public static List<Integer> getLevel(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        level(1, root, list);
        return list;
    }

    public static void level(int i, TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        // 超过长度的要填充
        int length = list.size();
        if (length <= i) {
            for (int j = 0; j <= i - length; j++) {
                list.add(length + j, null);
            }
        }
        list.set(i, root.val);
        level(2 * i, root.left, list);
        level(2 * i + 1, root.right, list);

    }

    public static List<Integer> getLevel1(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        // 根节点
        LinkedList<TreeNode> curRoot = new LinkedList<TreeNode>();
        LinkedList<TreeNode> child = new LinkedList<TreeNode>();
        curRoot.add(root);
        int i = 0;
        while (!curRoot.isEmpty()) {
            while (!curRoot.isEmpty()) {
                TreeNode node = curRoot.poll();
                list.add(node.val);
                if (null != node.left) {
                    child.add(node.left);
                }
                if (null != node.right) {
                    child.add(node.right);
                }

            }
            while (!child.isEmpty()) {
                if (i % 2 == 0) {
                    TreeNode node = child.poll();
                    curRoot.add(node);
                } else {
                    TreeNode node = child.poll();
                    curRoot.addFirst(node);
                }

            }
            i++;
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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<TreeNode> stack2 = new LinkedList<TreeNode>();
        stack.add(root);
        int i = 0;
        // 从左往右
        while (!stack.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            while (!stack.isEmpty()) {

                TreeNode pop = stack.pop();
                temp.add(pop.val);

                if (pop.left != null) {
                    stack2.add(pop.left);
                }
                if (pop.right != null) {
                    stack2.add(pop.right);
                }

            }
            if (i % 2 == 0) {
                Collections.reverse(temp);
            }
            list.add(temp);
            i++;
            while (!stack2.isEmpty()) {
                TreeNode pop = stack2.pop();
                stack.push(pop);

            }
        }
        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList();
        LinkedList<Integer> output = new LinkedList();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            // 从左到右的节点逆序
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }
}
