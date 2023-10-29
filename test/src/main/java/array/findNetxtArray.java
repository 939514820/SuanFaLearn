package array;

import java.util.*;

public class findNetxtArray {
    public static void main(String[] args) {

    }

    //    算法推导
//    如何得到这样的排列顺序？这是本文的重点。我们可以这样来分析：
//
//    我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
//    我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
//    在尽可能靠右的低位进行交换，需要从后向前查找
//    将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
//    将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
//
//    作者：Imageslr
//    链接：https://leetcode.cn/problems/next-permutation/solutions/80560/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public void nextPermutation(int[] nums) {
        int min = nums[nums.length - 1];
        int max = nums[nums.length - 1];
        Deque<Integer> stack = new LinkedList<>();
        stack.offer(nums[nums.length - 1]);
        int index = 0;
//        for (int i = nums.length - 1; i > 0; i--) {
//            Integer peek = stack.peek();
//            Integer lastPeek = stack.peekLast();
//            if (nums[i] > nums[peek]) {
//                stack.offerLast(i);
//            }else if(lastPeek) else {
//                // 找到小于的
//                stack.offerFirst(i);
//                if (!(stack.size() >= 2)) {
//                    int m = stack.pollFirst();
//                    int n = stack.pollFirst();
//                    swap(nums, m, n);
//                }
//            }
//        }n
        //反转
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");
        }
        System.out.println();
    }

    public void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
