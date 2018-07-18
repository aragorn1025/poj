package poj.no1088;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		final int W = 100;
		int r, c;
		int[][] h = new int[W + 2][W + 2];
		int[][] l = new int[W + 2][W + 2];
		int i, j;
		boolean f;

		// read data
		r = scanner.nextInt();
		c = scanner.nextInt();
		for (i = 0; i < 1; i++) {
			for (j = 0; j <= c + 1; j++) {
				h[i][j] = -1;
				l[i][j] = -1;
			}
		}
		for (; i <= r; i++) {
			h[i][0] = -1;
			l[i][0] = -1;
			for (j = 1; j <= c; j++) {
				h[i][j] = scanner.nextInt();
				l[i][j] = 1;
			}
			h[i][c + 1] = -1;
			l[i][c + 1] = -1;
		}
		for (; i <= r + 1; i++) {
			for (j = 0; j <= c + 1; j++) {
				h[i][j] = -1;
				l[i][j] = -1;
			}
		}

		// processing
		f = false; // the flag to check if to break the while
		while (!f) {
			f = true;
			for (i = 1; i <= r; i++) {
				for (j = 1; j <= c; j++) {
					if (l[i][j] < l[i - 1][j] + 1 && h[i][j] < h[i - 1][j]) {
						l[i][j] = l[i - 1][j] + 1;
						f = false;
					}
					if (l[i][j] < l[i + 1][j] + 1 && h[i][j] < h[i + 1][j]) {
						l[i][j] = l[i + 1][j] + 1;
						f = false;
					}
					if (l[i][j] < l[i][j - 1] + 1 && h[i][j] < h[i][j - 1]) {
						l[i][j] = l[i][j - 1] + 1;
						f = false;
					}
					if (l[i][j] < l[i][j + 1] + 1 && h[i][j] < h[i][j + 1]) {
						l[i][j] = l[i][j + 1] + 1;
						f = false;
					}
				}
			}
		}

		// output
		int max = 0;
		for (i = 1; i <= r; i++) {
			for (j = 1; j <= c; j++) {
				if (max < l[i][j]) {
					max = l[i][j];
				}
			}
		}
		System.out.println(max);
	}
}