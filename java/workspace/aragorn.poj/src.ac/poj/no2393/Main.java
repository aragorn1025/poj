package poj.no2393;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// inputs
		int n = scanner.nextInt();
		int s = scanner.nextInt();
		int[] c = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = scanner.nextInt();
			y[i] = scanner.nextInt();
		}

		// output
		for (int i = 1; i < n; i++) {
			c[i] = Math.min(c[i], c[i - 1] + s);
		}
		long output = 0;
		for (int i = 0; i < n; i++) {
			output = output + c[i] * y[i];
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