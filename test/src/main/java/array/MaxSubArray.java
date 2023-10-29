package array;

public class MaxSubArray {
    /**
     * @param nums
     * @return 最大自序和。
     */
    public static int maxSubArray1(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // 到当前为止的连续最大累加值
        int max  =nums[0];
        // 从第一个开始
        int beforeSum =nums[0];
        for (int i = 1; i < nums.length; i++) {
                if (beforeSum + nums[i] >nums[i]) {
                    beforeSum =beforeSum + nums[i];
                } else {
                    // 从当前开始
                    beforeSum =nums[i];
                }
                max = Math.max(max, beforeSum);
                System.out.println("bf="+beforeSum);

        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(a));
    }
}
