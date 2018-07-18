package poj.no1011.uns;

import java.util.Arrays;
import java.util.Scanner;

// ERROR CASE 1: 8 48 48 47 47 14 14 5 5
public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		final int MAX_N = 64;
		// final int MAX_LENGTH = 50;

		int[] sticks = new int[MAX_N];
		int[] concate = new int[MAX_N];
		int sum, max;
		while (true) {
			int n = scanner.nextInt(); // sticks number
			if (n == 0) {
				break;
			}
			sum = 0;
			for (int i = 0; i < n; i++) {
				sticks[i] =scanner.nextInt(); // (int) (Math.random() * MAX_LENGTH); // 
				sum += sticks[i];
				System.out.print(sticks[i] + " ");
			}
			System.out.println();
			Arrays.sort(sticks, 0, n);
			max = sticks[n - 1];
			for (int p = max; p <= sum; p++) {
				if (sum % p == 0) {
					Arrays.fill(concate, 0);
					for (int i = n - 1; i >= 0; i--) {
						for (int j = 0; j < n; j++) {
							if (concate[j] + sticks[i] <= p) {
								concate[j] += sticks[i];
								break;
							}
						}
					}
					if (concate[sum / p] == 0) {
						System.out.printf("sum = %d%n", sum);
						System.out.printf("ans = %d%n", p);
						break;
					}
				}
			}
		}
	}
}