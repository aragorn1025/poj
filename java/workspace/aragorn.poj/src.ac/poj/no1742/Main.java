package poj.no1742;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			// inputs
			int n = scanner.nextInt(); // 1 <= n <= 100
			int m = scanner.nextInt(); // 1 <= m <= 100000
			if (n == 0 && m == 0) {
				break;
			}
			int[][] coins = new int[2][n];
			for (int i = 0; i < 2 * n; i++) {
				// coins[0]: 1 <= a <= 100000
				// coins[1]: 1 <= c <= 1000
				coins[i / n][i % n] = scanner.nextInt();
			}
			int[] dp = new int[m + 1];
			dp[0] = 0;
			Arrays.fill(dp, 1, m + 1, -1);

			// output
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= m; j++) {
					if (dp[j] >= 0) {
						dp[j] = coins[1][i];
					} else if (j < coins[0][i] || dp[j - coins[0][i]] <= 0) {
						dp[j] = -1;
					} else {
						dp[j] = dp[j - coins[0][i]] - 1;
					}
				}
			}
			int output = 0;
			for (int i = 1; i < dp.length; i++) {
				if (dp[i] >= 0) {
					output++;
				}
			}
			System.out.printf("%d\n", output);
		}
	}
}