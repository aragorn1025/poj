package poj.no2376;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// inputs
		int n = scanner.nextInt();
		int t = scanner.nextInt();
		Cow[] cows = new Cow[n];
		for (int i = 0; i < n; i++) {
			cows[i] = new Cow(scanner.nextInt(), scanner.nextInt());
		}
		Arrays.sort(cows);

		// output
		int output;
		if (cows[0].a == 1) {
			int tl;
			int tr = cows[0].b;
			int cp = 1;
			output = 1;
			while (true) {
				tl = tr;
				if (tl >= t) {
					break;
				}
				while (cp < n && cows[cp].a <= tl + 1) {
					tr = Math.max(tr, cows[cp].b);
					cp++;
				}
				if (tr > tl) {
					output++;
				} else {
					output = -1;
					break;
				}
			}
		} else {
			output = -1;
		}
		System.out.printf("%d\n", output);
	}
}

class Cow implements Comparable<Cow> {
	public int	a;
	public int	b;

	public Cow(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Cow compareCow) {
		return this.a - compareCow.a;
	}
}