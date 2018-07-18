package poj.no2247;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner		scanner		= new Scanner(System.in);
	private static final int[]	p			= new int[] { 2, 3, 5, 7 };
	private static final long	MAX_VALUE	= 2000000000L;
	private static long[]		dp			= new long[5842 + 1];

	public static void main(String[] args) {
		int counter = 0;
		long temp;
		for (int h = 0; h < 31; h++) {
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 14; j++) {
					for (int k = 0; k < 12; k++) {
						if (h + i + j * 2 + k * 2 >= 32) {
							break;
						}
						temp = n(h, i, j, k);
						if (temp <= 0) {
							break;
						}
						dp[++counter] = temp;
					}
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
			System.out.printf("The %d%s humble number is %d.%n", n, suffix(n), dp[n]);
		}
	}

	private static long n(int m2, int m3, int m5, int m7) {
		long temp = 1;
		int[] m = new int[] { m2, m3, m5, m7 };
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i]; j++) {
				temp = temp * p[i];
				if (temp > MAX_VALUE) {
					return 0;
				}
			}
		}
		return temp;
	}

	private static String suffix(int n) {
		int t = n % 100;
		if (t % 10 == 1 && t != 11) {
			return "st";
		} else if (t % 10 == 2 && t != 12) {
			return "nd";
		} else if (t % 10 == 3 && t != 13) {
			return "rd";
		} else {
			return "th";
		}
	}
}