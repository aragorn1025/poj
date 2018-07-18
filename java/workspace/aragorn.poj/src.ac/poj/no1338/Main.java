package poj.no1338;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner		scanner	= new Scanner(System.in);
	private static final int[]	p		= new int[] { 2, 3, 5 };
	private static int[]		dp		= new int[1700];

	public static void main(String[] args) {
		int counter = 0;
		int temp;
		for (int i = 0; i < 31; i++) {
			for (int j = 0; j < 20; j++) {
				for (int k = 0; k < 14; k++) {
					if (i + j + k * 2 >= 32) {
						break;
					}
					temp = n(i, j, k);
					if (temp <= 0) {
						break;
					}
					dp[++counter] = temp;
				}
			}
		}
		Arrays.sort(dp, 1, counter + 1);
		int n;
		while (true) {
			n = scanner.nextInt();
			if (n == 0) {
				break;
			}
			System.out.println(dp[n]);
		}
	}

	private static int n(int m2, int m3, int m5) {
		long temp = 1;
		int[] m = new int[] { m2, m3, m5 };
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i]; j++) {
				temp = temp * p[i];
				if (temp - Integer.MAX_VALUE > 0) {
					return 0;
				}
			}
		}
		return (int) temp;
	}
}