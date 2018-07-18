package poj.no3589;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		char[] x, y;
		int a, b;
		while (n-- > 0) {
			x = scanner.next().toCharArray();
			y = scanner.next().toCharArray();
			a = 0;
			b = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (x[i] == y[j]) {
						if (i == j) {
							a++;
						} else {
							b++;
						}
					}
				}
			}
			System.out.printf("%dA%dB%n", a, b);
		}
	}
}