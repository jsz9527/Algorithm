package dynamicProgramming.hwod;

import java.util.Arrays;
import java.util.Scanner;

//外卖员爬楼
public class DeliveryManPaLou {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		if (N >= M) {
			System.out.println(0);
			return;
		}
		int[] dp = new int[M + 1];  // dp[i]表示到达第i层的最短时间
		Arrays.fill(dp, 0);
		for (int i = 0; i <= N; i++) {  // 初始化到N层以下需要的时间
			dp[i] = N - i;
		}
		for (int i = N + 1; i <= M; i++) {  // 计算从N层到M层的最短时间
			// 计算走步行梯和坐电梯的最短时间
			if (i % 2 == 0) {  // 偶数层可以直接到2*i，时间加1
				dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
			} else { // 奇数层需要先上或者先下，再到2*(i+1)，时间加2
				dp[i] = Math.min(dp[i - 1] + 1, dp[(i + 1) / 2] + 2);
			}
		}
		System.out.println(dp[M]);
	}
}
