import java.util.*;

public class dd {
    // 1 2 3
    // n 台阶 1 1 2 3
    // 输出每一种 路径
    static List<List<String>> res = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        s(2);
        System.out.println(Arrays.asList(res.toArray()).toString());
//        System.out.println(map.toString());
    }

    public static int get(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return n;
        } else if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = get(n - 1) + get(n - 2);
            map.put(n, value);
            return value;
        }
    }

    // 当前 n -step while(差>0)
    // 走楼梯的路径
    public static void s(int n) {
        int step = n;
        int cur = n;
        while (step > 0) {
            List list = new ArrayList();
            while (cur > 0) {
                cur -= step;
                if (cur != 0) {
                    list.add(cur);
                } else {
                    list.add(cur + step);
                }
            }

            if (cur == 0) {
                res.add(list);
                step--;
                cur = n;
            }
        }


    }
}
