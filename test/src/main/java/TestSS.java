import list.DeleteDuplicate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSS {
    public static class ListNodes {
        String val;
        ListNodes next;

        ListNodes(String x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNodes node1 = new ListNodes("2");
        ListNodes node2 = new ListNodes("s");
        ListNodes node3 = new ListNodes("d");
        ListNodes node4 = new ListNodes("3");
        ListNodes node5 = new ListNodes("f");
        ListNodes node6 = new ListNodes("e");
        ListNodes node7 = new ListNodes("5");
        ListNodes node8 = new ListNodes("l");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNodes listNode = get(node1);


        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNodes get(ListNodes root) {
        if (null == root) {
            return null;
        }

        ListNodes newHead = new ListNodes(null);
        ListNodes numHead = new ListNodes(null);
        ListNodes numHead1 = null;

        while (root != null) {
            if (isNumber(root.val)) {
                if (numHead.val == null) {
                    numHead1 = root;
                }
                numHead.next = root;
                numHead = numHead.next;
            } else {
                newHead.next = root;
                newHead = newHead.next;
            }

            root = root.next;
        }
        return newHead.next;
    }

    public static boolean isNumber(String s) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(s);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}
