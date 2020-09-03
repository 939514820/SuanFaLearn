//package tree;
//
//import java.util.ArrayList;
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.List;
//
//class Solution {
//
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        Deque<TreeNode> stack = new LinkedList<TreeNode>();
//        if (root == null)
//            return res;
//        else
//            stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode p = stack.pop();
//            if (p != null) {
//                if (p.right != null) stack.push(p.right);
//                if (p.left != null) stack.push(p.left);
//                stack.push(p);
//                stack.push(null);
//            } else { // 栈为空，说明遇到标记，执行方法内部的访问节点操作
//                res.add(stack.pop().val);
//            }
//        }
//        return res;
//    }
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        Deque<TreeNode> stack = new LinkedList<>();
//        List<Integer> res = new LinkedList<>();
//        if (root == null)
//            return res;
//        else
//            stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode p = stack.pop();
//            if (p != null) {
//                if (p.right != null) stack.push(p.right);
//                stack.push(p);
//                stack.push(null);
//                if (p.left != null) stack.push(p.left);
//            } else { // 遇到标记，模拟执行方法内部操作
//                res.add(stack.pop().val);
//            }
//        }
//        return res;
//    }
//
//    public List<Integer> postorderTraversal(TreeNode root) {
//        Deque<TreeNode> stack = new LinkedList<>();
//        List<Integer> res = new LinkedList<>();
//        if (root == null)
//            return res;
//        else
//            stack.add(root);
//        while (!stack.isEmpty()) {
//            TreeNode p = stack.pop();
//            if (p != null) {
//                stack.push(p);
//                stack.push(null);
//                if (p.right != null) stack.push(p.right);
//                if (p.left != null) stack.push(p.left);
//            } else { // 遇到标记，模拟执行方法内部操作
//                res.add(stack.pop().val);
//            }
//        }
//        return res;
//    }
//}
////
////作者：beney-2
////        链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-fei-di-gui-bian-li-by-beney-2/
////        来源：力扣（LeetCode）
////        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
