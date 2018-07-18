package poj.no3069;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner	scanner	= new Scanner(System.in);

	// data
	private static int		r;
	private static int		n;
	private static int[]	x;									// the location of each troop
	private static int		output;

	public static void main(String[] args) {
		while (true) {
			// inputs
			r = scanner.nextInt();
			n = scanner.nextInt();
			if (r == -1 && n == -1) {
				break;
			}
			x = new int[n];
			for (int i = 0; i < n; i++) {
				x[i] = scanner.nextInt();
			}
			Arrays.sort(x);

			// output
			output = 0;
			int cp = 0; // the pointer of the center troop which might hold a palantir
			int np = 0; // the number of the in-range troops
			while (np < n) {
				cp = np;
				while (true) {
					if (cp + 1 >= n) {
						break;
					}
					if (Math.abs(x[np] - x[cp + 1]) > r) {
						break;
					}
					cp++;
				}
				output++;
				np = cp + 1;
				while (true) {
					if (np >= n) {
						break;
					}
					if (Math.abs(x[np] - x[cp]) > r) {
						break;
					}
					np++;
				}
			}
			System.out.printf("%d\n", output);
		}
	}
}