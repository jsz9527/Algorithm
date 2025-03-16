package dynamicProgramming.two;

import java.util.Scanner;

//编辑距离（Levenshtein Distance）： 给定两个字符串 A 和 B，计算将 A 转换为 B 所需的最小操作次数。
//状态： dp[i][j] 表示 A 的前 i 个字符 变为 B 的前 j 个字符 的最小编辑距离。
public class EditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 读取字符串 A
        int n = scanner.nextInt();
        String A = scanner.next();
        
        // 读取字符串 B
        int m = scanner.nextInt();
        String B = scanner.next();
        
        scanner.close();

        // 计算编辑距离
        int result = levenshteinDistance(A, B, n, m);
        System.out.println(result);
    }

    public static int levenshteinDistance(String A, String B, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        // 初始化边界情况
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i; // 删除操作
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j; // 插入操作
        }

        // 计算 DP 表
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // 无需操作
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,   // 删除
                                Math.min(dp[i][j - 1] + 1,   // 插入
                                         dp[i - 1][j - 1] + 1)); // 替换
                }
            }
        }

        return dp[n][m];
    }
}
