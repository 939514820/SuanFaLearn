public class findMiddle {
    //给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
    //
    //请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    //
    //你可以假设 nums1 和 nums2 不会同时为空。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    // 思路一 先排序重新组成一个新的数组 然后找中位数 注意的地方：转double的运算
    // 思路二 明确要找数组中的拿几个数，用两个指针
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int len = nums1.length + nums2.length;
        int[] sum = new int[len];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                sum[index++] = nums1[i];
                i++;
            } else {
                sum[index++] = nums2[j];
                j++;
            }
        }
        while (i < nums1.length) {

            sum[index++] = nums1[i];
            i++;
        }
        while (j < nums2.length) {

            sum[index++] = nums2[j];
            j++;
        }


        if (sum.length % 2 == 0) {
            // 如果是偶数
            return (double) (sum[len / 2 - 1] + sum[len / 2]) / 2;
        } else {
            return (double) sum[len / 2];
        }
    }
}
