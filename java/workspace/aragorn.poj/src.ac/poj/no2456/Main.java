package poj.no2456;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	// private static final int MIN_N = 2;
	private static final int	MAX_N	= 100000;
	private static final int	MIN_X	= 0;
	private static final int	MAX_X	= 1000000000;
	private static int[]		x		= new int[MAX_N];
	private static int			n, c;

	public static void main(String[] args) {
		int lb, ub, d = 0;
		while (scanner.hasNext()) {
			// inputs
			n = scanner.nextInt();
			c = scanner.nextInt();
			for (int i = 0; i < n; i++) {
				x[i] = scanner.nextInt();
			}

			// processing
			Arrays.sort(x, 0, n);
			lb = MIN_X;
			ub = MAX_X + 1;
			while (ub - lb > 1) {
				d = (lb + ub) / 2;
				if (c(d)) {
					lb = d;
				} else {
					ub = d;
				}
			}

			// output
			System.out.printf("%d%n", lb);
		}
	}

	/** Return true if satisfy the condition. */
	private static boolean c(int d) {
		for (int i = 1, j, k = 0; i < c; i++) {
			// i: the number of the cows in the stall
			// j: the current index of the stall
			// k: the index of the last stall within a cow
			j = k + 1;
			while (j < n && x[j] < x[k] + d) {
				j++;
			}
			if (j >= n) {
				return false;
			}
			k = j;
		}
		return true;
	}
}