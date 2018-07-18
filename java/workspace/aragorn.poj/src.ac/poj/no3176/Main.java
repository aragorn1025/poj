package poj.no3176;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// inputs
		int n = scanner.nextInt();
		int[][] dp = new int[n][];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = new int[i + 1];
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = scanner.nextInt();
			}
		}

		// output
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = dp[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
			}
		}
		System.out.printf("%d\n", dp[0][0]);
	}
}