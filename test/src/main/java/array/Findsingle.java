package array;

import com.sun.org.apache.xerces.internal.impl.xs.util.XInt;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.xml.ws.BindingType;
import java.util.*;

public class Findsingle {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 0, 3, 0};
        int[] b = new int[]{2, 5, 6};
        int[] c = new int[]{1, 2, 4};
        int[] d = new int[]{2, 5, 6};
//        System.out.println(singleNumber(a));
//        System.out.println((Arrays.toString(merge(a, 6, b, 3)).toString()));
        System.out.println((Arrays.toString(merge1(c, d)).toString()));
//        System.out.println(Arrays.toString(longestPalindrome2("aab").toArray()));
//        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
//        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

    // 找数组中的重复数 异或 0 不同1 同0
    // 同自己求异或运算为0，同0求异或运算结果为自己, 如:a ^ a=0; a ^ 0 =a
//    自反性，A^ B^ B=A^ 0=A (本题解题的关键)
    public static int singleNumber(int[] nums) {
        int flag = 0;
        if (nums.length == 0) {
            return flag;
        }
        for (int num : nums) {
            flag ^= num;
        }
        return flag;
    }

    /**
     * 搜索二维矩阵
     *
     * @param matrix
     * @param target
     * @return 从左下开始
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = 0, row = matrix.length - 1;
        while (row >= 0 && col < matrix[0].length) {
            if (target > matrix[row][col]) {
                col++;
            } else if (target < matrix[row][col]) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 合并一个数组到另一个数组中
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = 0;
        int i2 = 0;
        int nums[] = new int[m];
        int index = 0;
        int min1;
        int min2;
        int N = m - n;
        while (i1 < N || i2 < n) {
            min1 = i1 >= N ? Integer.MAX_VALUE : nums1[i1];

            while (i2 < n && nums2[i2] <= min1) {
                nums[index++] = nums2[i2];
                i2++;
            }
            min2 = i2 >= n ? Integer.MAX_VALUE : nums2[i2];
            while (i1 < N && nums1[i1] <= min2) {
                nums[index++] = nums1[i1];
                i1++;
            }
        }
        nums1 = nums;
        return nums1;
    }

    /**
     * @param nums1
     * @param nums2 两个数组合并成一个数组
     * @return
     */
    public static int[] merge1(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int[] nums = new int[nums1.length + nums2.length];
        int index = 0;
        while ((i < nums1.length) || (j < nums2.length)) {
            // 边界条件的处理
            if (i >= nums1.length) {
                nums[index++] = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                nums[index++] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                nums[index++] = nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                nums[index++] = nums2[j];
                j++;
            } else {
                nums[index++] = nums2[j];
                nums[index++] = nums1[i];
                i++;
                j++;
            }
        }
        return nums;
    }

    public static List<String> longestPalindrome2(String s) {
        List list = new ArrayList();
        if (s.length() < 2) {
            list.add(s);
            return list;
        }
        int maxLen = 1;
        int index = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            list.add(s.charAt(i));
        }
        //开始计算
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    // 三个字符 两边相等的情况
                    if (j - i < 3) {
                        dp[i][j] = true;
                        list.add(s.substring(index, index + maxLen));
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 记录最长子串
                if (dp[i][j] && (j - i + 1 > maxLen)) {
                    index = i;
                    maxLen = j - i + 1;
                }
            }
        }
//        return s.substring(index, index + maxLen);
        return list;
    }


    // 第K小的 维护一个小顶堆
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int column = row == 0 ? 0 : matrix[0].length;

        //int[] a,b
        //a represents the number ,b is the index for (row, col)
        //nums[0] --> number nums[1] nums[2]
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));

        for (int i = 0; i < row; i++)
            pq.add(new int[]{matrix[i][0], i, 0});
        // 维护一个大小为K的优先队列
        while (k != 0) {
            int[] cur = pq.poll();  //  当前所能拿到的最小值
            k--;

            int curNumber = cur[0];
            if (k == 0) {
                return curNumber;
            }

            if (cur[2] < column - 1) {
                //cur[1] == OldX
                //cur[2] = OldY
                int index = cur[2] + 1;
                pq.add(new int[]{matrix[cur[1]][index], cur[1], index});
            }
        }
        return -1;
    }

    public static class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }


    //前 K 个高频元素
    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        if (nums.length == 0) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer aDefault = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++aDefault);
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> (o2.count - o1.count));

        map.forEach((key, value) -> {
            pq.add(new Node(key, value));
        });
        int i = 0;
        while (i < k && !pq.isEmpty()) {
            result[i] = pq.poll().num;
            i++;
        }
        return result;
    }


}
