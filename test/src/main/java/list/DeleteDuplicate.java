package list;

import java.util.*;

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
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
//        ListNode listNode = removeDuplicateNodes(node1);
//        ListNode listNode = removeElements(node1, 1);
//        ListNode[] listNodes = new ListNode[10];
//        listNodes[0] = node1;
//        listNodes[2] = node5;
//        listNodes[3] = node8;
//        ListNode listNode = mergeKLists(listNodes);
//        ListNode listNode = mergeTwoLists(node1, node5);
        ListNode cur = node1;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
        ListNode listNode = swapPairs3(node1, 3);
//        ListNode listNode = reverseList(node1);
//        ListNode listNode = new DeleteDuplicate().reverseKGroupNew(node1, 3);
//        ListNode listNode = new DeleteDuplicate().reverseKGroup(node1, 3);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }

    }

    //删除链表重复节点
    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        //初始化
        Set<Integer> set = new HashSet<Integer>();
        while (cur != null) {
            //判断当前重複了 pre不變
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            // 当前指针一直往后移动
            cur = cur.next;
        }
        return head;
    }
    // 不使用缓冲区的方法
    // 快慢指针法 快指针走完一起圈,慢指针指向下个节点 ；快指针比对和cur相同的，则改变节点 head2.next=head2.next.next;


    // 合并两个有序链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        // 两个指针 小于等于向后移动并且记录
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while (null != cur1 || null != cur2) {
            // 处理空值
            int x = null == cur2 ? Integer.MAX_VALUE : cur2.val;
            while (null != cur1 && cur1.val <= x) {
                // 新链表
                cur.next = cur1;
                cur = cur.next;
                // 当前指针
                cur1 = cur1.next;
            }
            // 处理空值
            int y = null == cur1 ? Integer.MAX_VALUE : cur1.val;
            while (null != cur2 && cur2.val <= y) {
                cur.next = cur2;
                cur = cur.next;

                cur2 = cur2.next;
            }
        }
        return head.next;

    }

    // 合并K个升序链表
    public static ListNode mergeKLists(ListNode[] lists) {
        // 两两合并
        if (lists.length < 1) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        for (int i = 1; i < lists.length; i++) {
            // 当前链表等于当前与前一个之和
            lists[i] = mergeTwoLists(lists[i - 1], lists[i]);
        }
        return lists[lists.length - 1];
    }

    /**
     * @param head
     * @return 反转链表
     */
    public static ListNode reverseList(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * @param head
     * @return 两两反转
     */
    public static ListNode swapPairs2(ListNode head) {
        while (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = head;
        ListNode res = pre;
        while (cur != null && cur.next != null) {
            // 先连2边再连中间
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;

            pre = pre.next.next;
            cur = cur.next;

        }
        return res.next;
    }


    /**
     * @param head
     * @param n    双指针法 快指针先走N步
     * @return 删除倒数第n个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        ListNode end = pre;
        ListNode start = pre;
        pre.next = head;

        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;

    }

    /**
     * @param headA a指针经过的路径 a+b+c
     * @param headB a指针经过的路径 b+c+a 如果有交点 指针会相遇
     * @return 两个链表相交的起始节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //1.特判
        if (headA == null || headB == null) return null;
        //2.定义两个指针
        ListNode p1 = headA;
        ListNode p2 = headB;
        //3.遍历 循环条件:是否相遇 假设有交点 ，构造成环，相反方如果有交点 一定会相遇
        while (p1 != p2) {
            p1 = p1.next;   //同步前行
            p2 = p2.next;
            if (p1 == null && p2 == null) return null;
            if (p1 == null) p1 = headB;
            if (p2 == null) p2 = headA;
        }
        return p1;
    }

    public static void swapPairs(ListNode left, ListNode start, ListNode end, ListNode right) {
        ListNode pre = null;
        ListNode cur = start;
        System.out.println("start=" + start.val + "end=" + end.val);
        while (cur != right) {
            // 连接新的链表
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        // 重新连接
        if (left != null) {
            left.next = end;
        }
        start.next = right;
    }

    // 反转指针 间隔k个元素
    public static ListNode swapPairs3(ListNode head, int k) {
        if (k < 2) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        ListNode start = null;
        ListNode next = null;
        int index = 1;
        while (null != cur) {
            next = cur.next;
            if (index % k == 0) {

                start = pre == null ? head : pre.next;
                // 记录链表头 值为第一组反转后的end节点的值 也就是cur元素
                head = pre == null ? cur : head;
                swapPairs(pre, start, cur, cur.next);

                // end变成下一次的起始位置
                pre = start;
                index = 0;
            }
            index++;
            cur = next;//关键
        }

//        1->2->3->4->5->6->7->8
//               pre cur
//        1<-2<-3->4->5->6->7->8
//             pre cur
        return head;
    }

}
