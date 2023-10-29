package dynamic;

public class Money {
    //换钱的最少张数 钱数排序 从最大的开始组合
    public int test(int[] a, int aim) {
        int index = 0;
        int res = 0;
        while (aim > 0) {
            int a1 = aim / a[index];
            if (aim < a[index]) {
                // 不滿足要回退
                aim = aim % a[index] + a[index];
                res--;
            } else {

                res += a1;
                aim = aim % a[index];
            }
            index++;
        }
        System.out.println(aim);
        System.out.println(res);
        return res;

    }

    // 换钱的方法数 回溯算法+记忆化搜索
    public int test1(int[] a, int i, int aim, int[][] map) {
        int res = 0;
        if (i == a.length) {
            return aim == 0 ? 1 : 0;
        } else {
            int cache = 0;
            for (int j = 0; a[i] * j <= aim; j++) {
                cache = map[i + 1][aim - a[i] * j];
                if (cache != 0) {
                    res += cache == -1 ? 0 : cache;
                } else {
                    res += test1(a, i + 1, aim - a[i] * j, map);
                }
            }
        }
        map[i][aim] = res == 0 ? -1 : res;

        return res;
    }

    public int testFen(int[] a, int aim) {
        int[][] map = new int[a.length+1][aim + 1];

        return test1(a, 0, aim, map);
    }

    public static void main(String[] args) {
        int[] a = new int[]{25, 10, 5, 1};
//        new Money().test(a, 25);
        System.out.println(new Money().testFen(a, 15));
        ;
    }
}
