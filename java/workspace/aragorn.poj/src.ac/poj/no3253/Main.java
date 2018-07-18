package poj.no3253;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// inputs
		int n = scanner.nextInt();
		long[] l = new long[n];
		for (int i = 0; i < n; i++) {
			l[i] = scanner.nextInt();
		}
		Arrays.sort(l);

		long output = 0;
		long temp;
		int front = 0;
		int p;
		while (front < n - 2) {
			front++;
			p = front + 1;
			temp = l[front - 1] + l[front];
			while (p < n && temp > l[p]) {
				l[p - 1] = l[p];
				p++;
			}
			l[p - 1] = temp;
			output = output + temp;
		}
		output = output + l[n - 2] + l[n - 1];
		System.out.printf("%d\n", output);
	}
}