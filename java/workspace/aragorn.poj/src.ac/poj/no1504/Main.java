package poj.no1504;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int x, y;
		while (n-- > 0) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			System.out.printf("%d\n", reverse(reverse(x) + reverse(y)));
		}
	}

	private static long reverse(long x) {
		long returnValue = 0;
		while (x > 0) {
			returnValue = returnValue * 10 + x % 10;
			x = x / 10;
		}
		return returnValue;
	}
}