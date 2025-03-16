package dynamicProgramming.one;

import java.util.Scanner;

//最长增长子序列，不连续
//状态：dp[i] 代表以 nums[i] 结尾的最长增长子序列的元素个数
//状态转移方程：if(j<i && nums[j] < nums[i] )   dp[i] = max(dp[i], dp[j]+ 1)
public class LongestGrowthSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i<n ; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(result(nums));
    }

    static int result(int[] nums){

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}


