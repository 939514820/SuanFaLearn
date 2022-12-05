package string;

import javax.print.DocFlavor;
import java.util.*;
import java.util.regex.Pattern;

public class CaculateNumber {
    // 48*((70-65)-43)+8*1
    public static void main(String[] args) {
        System.out.println(getValue("8*((9-5)-3)+8*1"));
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
        int index = 0;
        int pre = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                index++;
                continue;
            } else if (chars[i] == ')') {
                // 处理括号
                if (stack.size() >= 3) {
                    // 计算加减去括号
                    dealAddAndDel(stack);
                    index--;
                    dealMulti(map, stack, index);
                }
                continue;
            }
//            if (pre != 0 && chars[i] > '0' && chars[i] < '9') {
//                pre = pre * 10 + chars[i] - '0';
//                stack.push(String.valueOf(chars[i]));
//            } else {
//                pre = 0;
//            }
            stack.push(String.valueOf(chars[i]));
        }
        // 计算所有加减的操作数
        dealMulti(map, stack, index);
        return stack.peek();

    }

    private static void dealMulti(Map<String, String> map, Stack<String> stack, int index) {
        // 去除完括号&&栈顶是操作数&&可计算
        while (index == 0 && !map.containsKey(stack.peek()) && stack.size() >= 3) {
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
                int result = Integer.valueOf(b) + Integer.valueOf(a);
                stack.push(result + "");
                index--;
            } else if (X.equals("-")) {
                int result = Integer.valueOf(b) - Integer.valueOf(a);
                stack.push(result + "");
                index--;
            }
        }
    }

    private static String dealAddAndDel(Stack<String> stack) {
        String a = stack.pop();
        String X = stack.pop();
        String b = stack.pop();
        if (X.equals("+")) {
            int result = Integer.valueOf(b) + Integer.valueOf(a);
            stack.push(result + "");
        }
        if (X.equals("-")) {
            int result = Integer.valueOf(b) - Integer.valueOf(a);
            stack.push(result + "");
        }
        return stack.peek();
    }
}
