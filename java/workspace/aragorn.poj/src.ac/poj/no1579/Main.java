package poj.no1579;

import java.util.Scanner;

public class Main {
	private static Scanner		scanner	= new Scanner(System.in);
	private static int[][][]	dp		= new int[21][21][21];

	public static void main(String[] args) {
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 21; j++) {
				for (int k = 0; k < 21; k++) {
					if (i == 0 || j == 0 || k == 0) {
						dp[i][j][k] = 1;
					} else if (i < j && j < k) {
						dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
					} else {
						dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1]
								- dp[i - 1][j - 1][k - 1];
					}
				}
			}
		}
		int a, b, c;
		while (true) {
			// inputs
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();
			if (a == -1 && b == -1 && c == -1) {
				break;
			}

			// output
			System.out.printf("w(%d, %d, %d) = %d%n", a, b, c, w(a, b, c));
		}
	}

	private static int w(int a, int b, int c) {
		if (a < 0 || b < 0 || c < 0) {
			return 1;
		} else if (a > 20 || b > 20 || c > 20) {
			return dp[20][20][20];
		} else {
			return dp[a][b][c];
		}
	}
}