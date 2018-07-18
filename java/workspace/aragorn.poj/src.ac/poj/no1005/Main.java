package poj.no1005;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		final double pi = Math.PI;
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			double x = scanner.nextDouble();
			double y = scanner.nextDouble();
			int year = (int) Math.ceil((x * x + y * y) * pi / 2.0d / 50.0d);
			System.out.printf("Property %d: This property will begin eroding in year %d.%n", i, year);
		}
		System.out.println("END OF OUTPUT.");
	}
}