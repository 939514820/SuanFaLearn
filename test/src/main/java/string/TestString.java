package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestString {
    public static void convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int len = s.length();
        int start = 0;
        boolean shuFlag = true;
        for (int i = 0; i < len; i++) {
            // 竖着
            if (shuFlag) {
                sb[start].append(s.charAt(i));
                if (start == numRows - 1) {
                    shuFlag = false;
                } else {
                    start++;
                }
            } else {
                start--;
                // 横着
                for (int j = 0; j < sb.length; j++) {
                    if (start != j) {
                        sb[j].append(" ");
                    }
                }
                sb[start].append(s.charAt(i));
                if (start == 1) {
                    start = 0;
                    shuFlag = true;
                }

            }
        }

        for (int i = 0; i < sb.length; i++) {
            System.out.println(sb[i].toString());
        }
    }

    public static void main(String[] args) {

//        convert("LEETCODEISHIRING", 4);
        String a = "1";
        String a2 = "1";
        String a3 = new String("1");
        String a4 = String.valueOf(1);
        System.out.println(a == a2);
        System.out.println(a == a3);
        System.out.println(a == a4);
        System.out.println(a.equals(a3));
        System.out.println(a.equals(a2));

        Integer b = 127;
        Integer b1 = new Integer(127);
        Integer b2 = Integer.valueOf(127);
        Integer b3 = Integer.valueOf(129);
        Integer b4 = 129;
        System.out.println(b == b1);
        System.out.println(b == b2);
        System.out.println(b3 == b4);
        //Integer类型 默认-128---127存储在方法区，之外数据存储在堆中

//        String a = new String("aw");
//        String b = new String("aw");
//        String c= "aa";
//        String d= "aa";
//
//        System.out.println(a==b);//false
//        System.out.println(c==d);//true


    }

    public boolean isValid(String s) {
        // write code here
        Map<Character, Character> map = new HashMap();
        Stack<Character> stack = new Stack();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        stack.push(s.charAt(0));
        int i = 1;
        while (i < s.length()) {
            Character top = stack.peek();
            Character cur = s.charAt(i);
            if (cur == map.get(top)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }
        return stack.isEmpty();
    }



    //N叉树深度优先搜索
//    private void DFS(String s, int start, int end, boolean[][] isPalindrome) {
//        if (start > end) {
//            List<String> l = new ArrayList<>();
//            l.addAll(path);
//            res.add(l);
//            return;
//        }
//        //N叉树分支遍历
//        for (int len = 1; len <= end - start + 1; len++) {
//
//            if (!isPalindrome[start][start + len - 1]) continue;
//            //路径添加本分段
//            path.add(s.substring(start, start + len));
//            //下层继续深度优先搜索
//            DFS(s, start + len, end, isPalindrome);
//            //路径删除本分段
//            path.remove(path.size() - 1);
//        }
//    }



}
