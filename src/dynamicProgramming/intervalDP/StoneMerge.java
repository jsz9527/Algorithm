package dynamicProgramming.intervalDP;//区间DP

import java.util.Scanner;

//石子合并： 有 n 堆石子，每堆石子有一个重量 w[i]。 每次可以合并相邻的两堆，合并代价为两堆石子的总重量，合并后的新石堆重量为其和。 求最小合并代价。
//状态： dp[i][j] 表示合并 i 到 j 这段石堆的最小代价。
public class StoneMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 读取石子堆数量
        int n = scanner.nextInt();
        // 读取石子重量
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
        }
        scanner.close();

        // 计算最小合并代价
        int minCost = mergeStones(n, w);
        System.out.println(minCost);
    }

    public static int mergeStones(int n, int[] w) {
        int[][] dp = new int[n + 1][n + 1];
        int[] sum = new int[n + 1];

        // 计算前缀和
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + w[i];
        }

        // 区间 DP
        for (int len = 2; len <= n; len++) { // 枚举区间长度
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) { // 枚举最后合并位置
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1]);
                }
            }
        }

        return dp[1][n];
    }



}
