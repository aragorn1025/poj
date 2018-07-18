package poj.no3252.uns;

/* must be time limit exceeded */

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		long min = scanner.nextLong();
		long max = scanner.nextLong();
		long output = 0L;
		for (long i = min; i <= max; i++) {
			if (isRoundNumber(i)) {
				output++;
			}
			System.out.println("Processing: " + i);
		}
		System.out.printf("%d%n", output);
	}

	private static boolean isRoundNumber(long n) {
		long t = n;
		int[] d = new int[2];
		while (t > 0L) {
			d[(int) (t % 2)]++;
			t = t / 2;
		}
		return d[0] >= d[1];
	}
}