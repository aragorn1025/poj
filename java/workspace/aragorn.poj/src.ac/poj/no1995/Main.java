package poj.no1995;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int z, m, h, a, b, k;
		z = scanner.nextInt();
		while (z-- > 0) {
			k = 0;
			m = scanner.nextInt();
			for (h = scanner.nextInt(); h > 0; h--) {
				a = scanner.nextInt();
				b = scanner.nextInt();
				k = (k + modPower(a, b, m)) % m;
			}
			System.out.println(k);
		}
	}

	private static int modPower(int a, int b, int m) {
		long val = 1;
		long n = a % m;
		for (int i = b; i > 0; i >>= 1) {
			val = (i % 2 == 1) ? (val * n % m) : val;
			n = n * n % m;
		}
		return (int) val;
	}
}