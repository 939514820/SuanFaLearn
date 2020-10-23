package string;

import java.util.HashSet;

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
        convert("LEETCODEISHIRING", 4);
    }
}
