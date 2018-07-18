package poj.no1423;

import java.util.Scanner;

public class Main {
	private static int		MAX_M	= (int) 1e7;
	private static int[]	dp		= new int[MAX_M + 1];
	private static Scanner	scanner	= new Scanner(System.in);

	public static void main(String[] args) {
		double temp = 1;
		dp[0] = 1;
		for (int i = 1; i <= MAX_M; i++) {
			temp = temp + Math.log10(i);
			dp[i] = (int) temp;
		}
		int n = scanner.nextInt();
		int m;
		while (n-- > 0) {
			m = scanner.nextInt();
			System.out.printf("%d\n", dp[m]);
		}
	}
}