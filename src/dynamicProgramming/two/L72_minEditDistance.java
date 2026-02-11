package dynamicProgramming.two;

import java.util.Scanner;

//编辑距离（Levenshtein Distance）： 给定两个字符串 A 和 B，计算将 A 转换为 B 所需的最小操作次数。
//状态： dp[i][j] 表示 A 的前 i 个字符 变为 B 的前 j 个字符 的最小编辑距离。
public class L72_minEditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i< n+1; i++){
            dp[i][0] = i;
        }
        for(int j=0; j< m+1; j++){
            dp[0][j] = j;
        }

        for(int i=1; i< n+1; i++){
            for(int j=1; j< m+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i - 1][j - 1]; // 无需操作
                }else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j] + 1,   // 删除
                            Math.min(
                                dp[i][j - 1] + 1,   // 插入
                                dp[i - 1][j - 1]+1    // 替换
                            )
                    );
                }
            }
        }

        return dp[n][m];
    }
}
