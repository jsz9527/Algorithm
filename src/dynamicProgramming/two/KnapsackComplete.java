package dynamicProgramming.two;

import java.util.Scanner;

//完全背包问题： 给定 n 个物品，每个物品有 重量 w[i] 和 价值 v[i]。有一个容量为 C 的背包，每种物品可以选取无限次，求解能够放入的最大总价值
//状态： dp[i][j] 表示 前 i 个物品 在 容量 j 时的最大价值
public class KnapsackComplete {
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
        int[][] dp = new int[n + 1][C + 1];

        for (int i = 1; i <= n; i++) {  // 遍历物品
            for (int j = 0; j <= C; j++) { // 遍历背包容量
                dp[i][j] = dp[i - 1][j]; // 不选该物品
                if (w[i - 1] <= j ) { // 选该物品（可选多次）
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - w[i - 1]] + v[i - 1]);
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

        for (int i = 0; i < n; i++) {  // 先遍历物品
            for (int j = w[i]; j <= C; j++) { // 再遍历容量（从小到大）
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }

        return dp[C];
    }

}

/*
4
1 2 3 4
2 3 4 5
5

 */


