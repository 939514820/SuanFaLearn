package dynamic;


import java.util.*;

public class DaQiQiu {


    public int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l - 1] * arr[l] * arr[r + 1];
        }
        // 最后打掉两边的
        int max = Math.max(arr[l - 1] * arr[l] * arr[r + 1] + process(arr, l + 1, r),
                arr[l - 1] * arr[r] * arr[r + 1] + process(arr, l, r - 1));
        // 打到中间任意位置
        for (int i = l + 1; i < r; i++) {
            max = Math.max(max,
                    arr[l - 1] * arr[i] * arr[r + 1] + process(arr, i + 1, r)
                            + process(arr, l, i - 1));
        }

        return max;
    }


    // 计算到start的距离
    private Map<String, Integer> getDistance(HashMap<String, List<String>> nextMap, String start) {
        Map<String, Integer> dis = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.add(start);
        LinkedList<String> root = new LinkedList<>();
        root.add(start);
        while (!root.isEmpty()) {
            String cur = root.poll();
            List<String> nextlist = nextMap.get(cur);
            for (String next : nextlist) {
                if (!set.contains(next)) {
                    //走到当前=上一步+1
                    dis.put(next, (dis.get(cur) + 1));
                    set.add(next);
                    root.add(next);
                }

            }
        }

        return dis;
    }

    // 从 start节点开始走 统计能到达to的路径
    public static String getPath(HashMap<String, List<String>> nextMap, List<String> res, String curList, String start, String to, int count) {
        if (count > to.length()) {
            return null;
        }
        curList = curList + start + ",";
        if (start.equals(to)) {
            res.add(curList);
            return curList;
        }

        List<String> list = nextMap.get(start);
        for (String cur : list) {
            getPath(nextMap, res, curList, cur, to, count + 1);
        }
        return null;
    }

    // 计算每个子串的next
    public static HashMap<String, List<String>> getNext(List<String> words) {
        HashMap<String, List<String>> nextMap = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            nextMap.put(words.get(i), new LinkedList<>());
        }
        Set<String> dict = new HashSet<String>(words);
        for (int i = 0; i < words.size(); i++) {
            nextMap.put(words.get(i), doGetNext(words.get(i), dict));
        }
        return nextMap;
    }

    /**
     * 获取每个字符串的next
     *
     * @param s
     * @param dict
     * @return
     */
    private static List<String> doGetNext(String s, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] array = s.toCharArray();
        for (char cur = 'a'; cur < 'z'; cur++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] != cur) {
                    char temp = array[j];
                    array[j] = cur;
                    if (dict.contains(String.valueOf(array))) {
                        res.add(String.valueOf(array));
                    }
                    array[j] = temp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String start = "abc";
        String end = "cab";

        String[] list = new String[]{"cab", "acc", "cbc", "ccc", "cac", "cbb", "aab", "abb", start};
        HashMap<String, List<String>> next = getNext(Arrays.asList(list));
        List<String> res = new ArrayList<>();
        getPath(next, res, "", start, end, 0);
        res.forEach(item -> {
            System.out.println(item);
        });
    }
}
