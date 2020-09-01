package array;

public class MaxSubArray {
    /**
     *
     * @param nums
     * @return 最大自序和。
     */
    public int maxSubArray(int[] nums) {

        int len = nums.length;
        if (len == 0){
            return 0;
        }
        int currentsum = nums[0];
        int greatsetsum = nums[0];
        // 从第一个开始
        for(int i=1;i<nums.length;i++){
            // 和大于0 就继续相加
            if(currentsum > 0){
                currentsum += nums[i];
            }else{
                // 小于0 和等于当前数字
                currentsum = nums[i];
            }
            // 记录最大和
            if(currentsum > greatsetsum){
                greatsetsum  = currentsum;
            }

        }
        return greatsetsum;
    }
}
