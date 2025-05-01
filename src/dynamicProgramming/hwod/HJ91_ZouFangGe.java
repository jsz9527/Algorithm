package dynamicProgramming.hwod;

import java.util.*;

//走方格
public class HJ91_ZouFangGe {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] dp = new int[n][m];
        dp[0][0] = 2;
        for (int i = 1; i <= m-1; i++) {
            dp[0][i] = dp[0][i-1] + 1;
        }
        for (int i = 1; i <= n-1; i++) {
            dp[i][0] = dp[i-1][0] + 1;
            for (int j = 1; j <= m-1; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];//动态规划
            }
        }

        System.out.println(dp[n-1][m-1]);
    }

	
}
