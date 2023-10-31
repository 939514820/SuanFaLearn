package tree;

public class Morris {

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
        TreeNode node7 = new TreeNode(7);
        node1.right = node2;
        node1.left = node5;
        node2.left = node3;
        node2.right = node6;
        node3.right = node4;
        getMir(node1);
        System.out.println("===========");
        getMir1(node1);
    }

    public static void getMir(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode cur = node;
        TreeNode mostRight = null;


        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 找到左子树中最右边的
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.println(cur.val);
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                    System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }

    public static void getMir1(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode cur = node;
        TreeNode mostRight = null;


        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 找到左子树中最右边的
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

}
