package poj.no1068;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		int n;
		int[] input;
		int[] output;
		while (t > 0) {
			// input
			n = scanner.nextInt();
			input = new int[n];
			for (int i = 0; i < n; i++) {
				input[i] = scanner.nextInt();
			}

			// processing
			for (int i = n - 1; i > 0; i--) {
				input[i] = input[i] - input[i - 1];
			}
			output = new int[n];
			for (int i = 0; i < n; i++) {
				input[i] = input[i] - 1;
				output[i] = 1;
			}
			
			for (int i = 0; i < n; i++) {
				if (input[i] < 0) {
					for (int j = 1; j <= i; j++) {
						if (input[i - j] > 0) {
							output[i] = output[i] + j;
							input[i]++;
							input[i - j]--;
							break;
						}
					}
				}
			}

			// output
			for (int i = 0; i < n; i++) {
				System.out.printf("%d%c", output[i], i != n - 1 ? ' ' : '\n');
			}

			// the next loop
			t--;
		}
	}
}