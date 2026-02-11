package other;

class L53_MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        int maxSubArray = 0;
        int result = nums[0];
        for(int i : nums) {
            maxSubArray = Math.max(maxSubArray, 0) + i;
            result = Math.max(maxSubArray, result);
        }
        return result;
    }
}