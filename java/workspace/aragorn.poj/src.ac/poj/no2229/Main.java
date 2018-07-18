package poj.no2229;

import java.util.Scanner;

public class Main {
	private static Scanner		scanner	= new Scanner(System.in);
	private static long[]		dp;

	public static void main(String[] args) {
		int n = scanner.nextInt();
		System.out.printf("%d", output(n));
	}

	private static long output(int n) {
		dp = new long[n / 2 + 1];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i / 2];
			dp[i] = dp[i] % 1000000000;
		}
		return dp[n / 2];
	}
}