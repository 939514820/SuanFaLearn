package string;

public class ReverseNumber {
    // 反转一个数字 123 321
    public static int reverseNumber(int number) {
        int res = 0;
        while (number!=0) {
            res = res * 10 + number % 10;
            number /= 10;
        }
        return (int)res==res? (int)res:0;
    }
    public static int reverse(int x) {
        int  n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        // 强转成int 看是否与原来相等 判断是否超过表数范围
        return (int)n==n? (int)n:0;
    }
    public static void main(String[] args) {
//        System.out.println(reverseNumber(-123));
//        System.out.println(reverse(-123));
        System.out.println(myAtoi("   -42"));
    }
    // 将一个string字符串转换成int类型数字
        public static int myAtoi(String str) {
            char[] chars = str.toCharArray();
            int n = chars.length;
            int idx = 0;
            while (idx < n && chars[idx] == ' ') {
                // 去掉前导空格
                idx++;
            }
            if (idx == n) {
                //去掉前导空格以后到了末尾了
                return 0;
            }
            boolean negative = false;
            if (chars[idx] == '-') {
                //遇到负号
                negative = true;
                idx++;
            } else if (chars[idx] == '+') {
                // 遇到正号
                idx++;
            } else if (!Character.isDigit(chars[idx])) {
                // 其他符号
                return 0;
            }
            int ans = 0;
            while (idx < n && Character.isDigit(chars[idx])) {
                int digit = chars[idx] - '0';
                if (ans > (Integer.MAX_VALUE - digit) / 10) {
                    // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                    // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                    return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = ans * 10 + digit;
                idx++;
            }
            return negative? -ans : ans;
        }

}
