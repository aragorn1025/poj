package poj.no1458;

import java.util.Scanner;

public class Main {
	private static int[][]	dp;
	private static Scanner	scanner	= new Scanner(System.in);

	public static void main(String[] args) {
		char[] x, y;
		while (scanner.hasNext()) {
			x = scanner.next().toCharArray();
			y = scanner.next().toCharArray();
			dp = new int[x.length + 1][y.length + 1];
			for (int i = 1; i <= x.length; i++) {
				for (int j = 1; j <= y.length; j++) {
					if (x[i - 1] == y[j - 1]) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
					}
				}
			}
			System.out.println(dp[x.length][y.length]);
		}
	}
}