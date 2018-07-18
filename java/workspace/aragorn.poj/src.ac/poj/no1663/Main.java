package poj.no1663;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int x, y, output;
		while (n-- > 0) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			if (x == y || x == y + 2) {
				output = x * 2 - x % 2 - x + y;
				System.out.printf("%d%n", output);
			} else {
				System.out.printf("%s%n", "No Number");
			}
		}
	}
}