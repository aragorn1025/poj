package poj.no1064;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// final int MIN_N = 1;
		final int MAX_N = 10000;
		// final int MIN_K = 1;
		// final int MAX_K = 10000;
		// final int MIN_L = 1000;
		final int MAX_L = 100000000; // is recorded with a millimeter precision

		int[] l = new int[MAX_N];
		int n, k, lowerBound, upperBound, mid = 0, cableNumber, i;

		while (scanner.hasNext()) {
			// inputs
			n = scanner.nextInt();
			k = scanner.nextInt();
			for (i = 0; i < n; i++) {
				l[i] = (int) (scanner.nextDouble() * 1000);
			}

			// processing
			lowerBound = 0;
			upperBound = MAX_L + 1;
			while (upperBound - lowerBound > 1) {
				mid = (lowerBound + upperBound) / 2;
				cableNumber = 0;
				for (i = 0; i < n; i++) {
					cableNumber += l[i] / mid;
				}
				if (cableNumber >= k) {
					lowerBound = mid;
				} else {
					upperBound = mid;
				}
			}

			// output
			System.out.printf("%d.%02d%n", lowerBound / 1000, lowerBound / 10 % 100);
		}
	}
}