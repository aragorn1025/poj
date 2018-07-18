package poj.no3262;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// inputs
		int n = scanner.nextInt();
		Cow[] cows = new Cow[n];
		for (int i = 0; i < n; i++) {
			cows[i] = new Cow(scanner.nextInt(), scanner.nextInt());
		}
		Arrays.sort(cows);

		// output
		int temp = 0;
		for (int i = 0; i < n; i++) {
			temp = temp + cows[i].d;
		}
		long output = 0;
		for (int i = 0; i < n; i++) {
			temp = temp - cows[i].d;
			output = output + temp * cows[i].t;
		}
		System.out.printf("%d\n", output * 2);
	}
}

class Cow implements Comparable<Cow> {
	public int	t;
	public int	d;

	public Cow(int t, int d) {
		super();
		this.t = t;
		this.d = d;
	}

	private double getOrder() {
		return (double) d / (double) t;
	}

	@Override
	public int compareTo(Cow compareCow) {
		if (this.getOrder() <= compareCow.getOrder()) {
			return 1;
		} else {
			return -1;
		}
	}
}