package string;

import java.util.*;
import java.util.regex.Pattern;

public class CaculateNumber {
    // 48*((70-65)-43)+8*1
    public static void main(String[] args) {
        System.out.println(getValue("8*((9-5)-3)+8*1"));
        System.out.println(getValue("48*((70-65)-43)+8*1"));
    }

    static Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");

    //        return pattern.matcher(str).matches();
    public static String getValue(String str) {
        Map<String, String> map = new HashMap<>();
        map.put("+", "");
        map.put("-", "");
        map.put("*", "");
        map.put("÷", "");
        if (str.length() < 1) return "";
        Stack<String> stack = new Stack<>();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                sb.append(chars[i]);
            } else if (map.containsKey(String.valueOf(chars[i]))) {
                if (sb.length() > 0) {
                    stack.push(sb.toString());
                }
                sb = new StringBuilder();
                stack.push(String.valueOf(chars[i]));
            } else if (chars[i] == '(') {
                index++;
            } else if (chars[i] == ')') {
                // 处理括号
                // 计算加减去括号
                if (sb.length() > 0) {
                    stack.push(sb.toString());
                }
                sb = new StringBuilder();

                index--;
                if (index == 0) {
                    // 没有括号了 占中内容全部计算出来
                    while (stack.size() >= 3) {
                        dealAddAndDel(stack, index);
                    }
                } else {
                    dealAddAndDel(stack, index);
                }

            } else {
                stack.push(String.valueOf(chars[i]));
            }
        }
        if (sb.length() > 0) {
            stack.push(sb.toString());
        }
        while (stack.size() >= 3) {
            dealAddAndDel(stack, 0);
        }
        return stack.peek();

    }


    private static String dealAddAndDel(Stack<String> stack, int index) {
        if (stack.size() < 3) {
            return stack.peek();
        }

//        if (stack.size() >= 3) {
        String a = stack.pop();
        String X = stack.pop();
        String b = stack.pop();
        if (X.equals("*")) {
            int result = Math.multiplyExact(Integer.valueOf(a), Integer.valueOf(b));
            stack.push(result + "");
        } else if (X.equals("÷")) {
            int result = Integer.valueOf(b) / Integer.valueOf(a);
            stack.push(result + "");
        } else if (X.equals("+")) {
            stack.push(Integer.valueOf(b) + Integer.valueOf(a) + "");
        } else if (X.equals("-")) {
            stack.push(Integer.valueOf(b) - Integer.valueOf(a) + "");
        }
        // 把乘消除掉
//        }

        return stack.peek();
    }
}
