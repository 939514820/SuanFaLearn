package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Window {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k < 1 || nums.length < k) {
            return null;
        }

        int[] res = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.add(i);
            //队列头为当前最大值
            // 维护事件窗口
            if (queue.peekFirst() == i - k) {
                queue.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[queue.peekFirst()];
            }

        }
        return res;
    }
}
