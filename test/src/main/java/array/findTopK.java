package array;

import sun.security.ssl.HandshakeInStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class findTopK {
    public static int[] getTop(int[] a, int k) {
        int[] result = new int[k];
        // 快排找到index=k;
        quickSort(a, 0, a.length - 1, k);
        System.out.println(Arrays.toString(a));
        return result;
    }

    public static int getMiddle(int[] a, int low, int high) {
        int temp = a[low];
        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    public static void quickSort(int[] a, int low, int high, int k) {

        if (low < k) {
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1, k);
            quickSort(a, middle + 1, high, k);
        }
    }

    // 递归的方法
    public static int getMiddle1(int[] a, int low, int high, int k) {
        int s = low;
        int e = high;
        if (s < e) {
            int temp = a[low];
            while (low < high) {
                while (low < high && a[high] <= temp) {
                    high--;
                }
                a[low] = a[high];
                while (low < high && a[low] >= temp) {
                    low++;
                }
                a[high] = a[low];
            }
            a[low] = temp;
            if (low == k - 1) {
                System.out.println(Arrays.toString(a));
                return a[low];
            } else if (low < k - 1) {
                return getMiddle1(a, low + 1, e, k);
            } else {
                return getMiddle1(a, s, low - 1, k);
            }
        } else if (s == e && s == k - 1)  //区间内只有一个元素，且为 nums[k - 1]
            return a[k - 1];


        return -1;
    }

    /**默认是小顶堆 topK大用小顶堆
     * 构造
     * PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        // low==k-1 则 nums[low]是第K大
        if (nums.length < k) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue(k);
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            } else {
                if (nums[i] > queue.peek()) {
                    queue.poll();//移除堆顶
                    queue.offer(nums[i]);// 放入当前元素
                }
            }

        }
        return queue.peek();
    }

    public static void main(String[] args) {
//        System.out.println(getTop(new int[]{10, 4, 3, 8, 2, 0}, 3));
        int[] a = new int[]{10, 4, 3, 8, 2, 0};
//        System.out.println(getMiddle1(a, 0, a.length - 1, 6));
//        System.out.println(findKthLargest(a, 5));
    }
}
