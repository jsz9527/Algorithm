package dynamicProgramming.one;

import java.util.Scanner;

//最大连续子数组和，并返回起始和结束索引
//状态：dp[i] 代表以 nums[i] 结尾的最大连续子数组和
//状态转移方程：dp[i] = max(nums[i], dp[i−1]+nums[i])
public class MaxSubarrayWithIndices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        int[] result = maxSubArrayWithIndices(nums);
        System.out.println("最大子数组和: " + result[0]);
        System.out.println("起始索引: " + result[1]);
        System.out.println("结束索引: " + result[2]);
    }

    public static int[] maxSubArrayWithIndices(int[] nums) {
        int maxSum = nums[0];     // 记录最大子数组和
        int currentSum = nums[0]; // 当前子数组和
        int start = 0, end = 0;   // 最大子数组的起始和结束索引
        int tempStart = 0;        // 可能的起始索引

        for (int i = 1; i < nums.length; i++) {
            // 如果当前元素比 currentSum + nums[i] 还大，说明应该从 i 重新开始
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                tempStart = i; // 记录新的起始索引
            } else {
                currentSum += nums[i]; // 继续扩展当前子数组
            }

            // 如果找到更大的子数组和，则更新最大和以及索引
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart; // 记录真正的起始索引
                end = i;           // 记录结束索引
            }
        }

        return new int[]{maxSum, start, end};
    }
}