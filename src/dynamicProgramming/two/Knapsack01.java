package dynamicProgramming.two;

import java.util.Scanner;

//01背包问题： 给定 n 个物品，每个物品有 重量 w[i] 和 价值 v[i]。有一个容量为 C 的背包，求解能够放入的最大总价值
//状态： dp[i][j] 表示 前 i 个物品 在 容量 j 时的最大价值
public class Knapsack01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 读取物品数量
        int n = scanner.nextInt();
        // 读取物品重量
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        // 读取物品价值
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        // 读取背包容量
        int C = scanner.nextInt();
        scanner.close();

        // 计算最大价值
        int maxValue = knapsack(n, weights, values, C);
        System.out.println(maxValue);
    }

    public static int knapsack(int n, int[] w, int[] v, int C) {
        int[][] dp = new int[n+1][C+1];
        int max = 0;
        for(int i = 1; i <= n ; i++){
            for(int j = 0; j <= C ; j++){
                if( w[i-1] > j ){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j -w[i-1] ] + v[i-1] );
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        return dp[n][C];

    }

    //可以使用滚动数组优化空间复杂度 dp[i][j] 到 O(C)
    public static int knapsackOptimized(int n, int[] w, int[] v, int C) {
        int[] dp = new int[C + 1];

        for (int i = 0; i < n; i++) {
            for (int j = C; j >= w[i]; j--) { // 逆序遍历，防止覆盖
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }

        return dp[C];
    }



}
