package poj.no1862;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// inputs
		int n = scanner.nextInt();
		int[] stripies = new int[n];
		for (int i = 0; i < n; i++) {
			stripies[i] = scanner.nextInt();
		}

		// output
		Arrays.sort(stripies);
		double output = stripies[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			output = 2 * Math.sqrt(output * stripies[i]);
		}
		System.out.printf("%.3f\n", output);
	}
}