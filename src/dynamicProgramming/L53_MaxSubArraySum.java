package dynamicProgramming;

class L53_MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int result = nums[0];
        dp[0] = nums[0];
        for(int i =1 ; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i] , nums[i]);
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}