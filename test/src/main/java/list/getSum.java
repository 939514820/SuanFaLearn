package list;

public class getSum {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        //(2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        node.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;
        addTwoNumbers(node, node4);

        s(100);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = 0;//进位
        int sum = 0;//和
        //先初始化一个节点值为0的空节点
        ListNode first = new ListNode(0);
        //此时cur与first都指向0节点
        ListNode cur = first;
        while (l1 != null || l2 != null) {
            //将l1和l2中的值赋给x，y；不能省略判断语句，不然执行深度不同的链表会直接报错
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            //求和
            sum = num + x + y;
            //求进位
            num = sum / 10;
            //链接新链表
            cur.next = new ListNode(sum % 10);
            //现在cur指向节点1,l1与l2也切换到下一节点
            cur = cur.next;
            //不能省略判断语句，不然执行深度不同的链表会直接报错
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        //由于数值相加有进位的话要放到下一个节点，所以增加一个判断语句
        if (num > 0) {
            cur.next = new ListNode(num);
            System.out.print("进位cur.next=" + cur.next.val);
        }
        //加上返回值
        return first.next;
    }


    public static int s(int n) {
        boolean[] isPrime = new boolean[n];
        int count = 0;
        // 素數從2開始
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = i * i; j < n; j += i) {
                    System.out.print("j=" + j);
                    isPrime[j] = true;
                }
                System.out.println();
            }
        }
        return count;
    }

    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next && null != slow) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    // 数字反转 123 -》321

}
