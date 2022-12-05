package list;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

public class TestList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //对链表进行排序
    public static ListNode sortList(ListNode head) {
        ListNode cur = head;
        ListNode fast = head;
        while (null != cur) {
            // 每一个cur 去冒泡
            while (null != fast) {
                if (cur.val > fast.val) {
                    int temp = fast.val;
                    fast.val = cur.val;
                    cur.val = temp;
                }
                fast = fast.next;
            }

            cur = cur.next;
            fast = cur;
        }
        return head;
    }

    public static ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
//       ListNode node5 = newListNode(4);
//       ListNode node6 = newListNode(5);
//       ListNode node7 = newListNode(6);
//       ListNode node8 = newListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        sortList(node1);
        reverseList(node1);
        while (null != node1) {
            System.out.print(node1.val + " ");
            node1 = node1.next;
        }
    }
}
