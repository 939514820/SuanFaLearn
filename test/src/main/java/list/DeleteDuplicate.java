package list;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicate {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        ListNode listNode = removeDuplicateNodes(node1);
        ListNode listNode = removeElements(node1, 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    //删除链表重复节点
    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode pre = head;

        if (pre == null) {
            return head;
        }
        ListNode cur = head.next;
        //初始化
        Set<Integer> set = new HashSet<Integer>();
//        Long flag = (1L << pre.val);
        while (cur != null) {
            //判断当前重複了 pre不變
//            if ((flag & (1L << cur.val)) > 0) {
            if (set.contains(cur.val)) {
                pre.next = null;
            } else {
//                flag |= (1L << cur.val);
                set.add(cur.val);
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }
    // 不使用缓冲区的方法
    // 快慢指针法 快指针走完一起圈,慢指针指向下个节点 ；快指针比对和cur相同的，则改变节点 head2.next=head2.next.next;


    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 找到起始节点
        ListNode pre = head;
        while (null != pre && pre.val == val) {
            pre = pre.next;
        }
        if (pre == null) {
            return pre;
        }
        // 注意需要重新设置头指针位置
        head = pre;
        ListNode cur = pre.next;
        while (cur != null) {
            // 相同 前指针不变 当前指针向后移动
            if (cur.val == val) {
                cur = cur.next;
                pre.next = null;
            } else {
                // 不相同 当前指针和cur都向后移动
                pre.next = cur;
                cur = cur.next;
                pre = pre.next;
            }
        }
        return head;
    }
}
