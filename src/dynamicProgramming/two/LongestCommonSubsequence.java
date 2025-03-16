package dynamicProgramming.two;

import java.util.Scanner;

//最长公共子序列（LCS, Longest Common Subsequence），不连续
//abcde和ace的最长公共子序列是ace
//状态：dp[i][j] 表示 text1 前 i 个字符 和 text2 前 j 个字符 的 最长公共子序列长度。对应字符的数组下标为i-1和j-1
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.next();
        String text2 = scanner.next();
        scanner.close();

        int lcsLength = longestCommonSubsequence(text1, text2);
        System.out.println("最长公共子序列长度: " + lcsLength);
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1]; // dp[i][j] 表示 text1[0:i] 和 text2[0:j] 的 LCS 长度

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
