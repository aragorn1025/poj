package poj.no1061.ce;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		long x = scanner.nextInt();
		long y = scanner.nextInt();
		long m = scanner.nextInt();
		long n = scanner.nextInt();
		long l = scanner.nextInt();
		long a, b, g;

		if (x == y) {
			System.out.println("" + 0);
		} else { // x != y
			if (m == n) {
				System.out.println("Impossible");
			} else { // m != n
				// (x + m * i) % l = (y + n * i) % l where i is an integer
				// -> ((m - n) * i) % l = (y - x) % l
				// -> (((m - n) % l) * i) % l = (y - x) % l
				// Let a = (m - n) % l and b = (y - x) % l
				// then (a * i) % l = b
				a = Math.floorMod(m - n, l);
				b = Math.floorMod(y - x, l);

				g = gcd(a, l);
				if (b % g != 0) {
					System.out.println("Impossible");
				} else {
					// Let g be the great common divisor of a and l
					// If b is divided by g
					// then ((a / g) * i) % (l / g) = b / g
					a /= g;
					b /= g;
					l /= g;

					// (a' * i) % l' = b' where a' and l' are relatively prime
					System.out.println((modInverse(a, l) * b) % l);
				}
			}
		}
	}

	private static long gcd(long a, long b) {
		if (a < 0 || b < 0) {
			return -1;
		} else {
			if (b == 0) {
				return a;
			} else {
				return gcd(b, a % b);
			}
		}
	}

	private static long xgcd(long a, long b, long[] x, long[] y) {
		if (a < 0 || b < 0 || x.length != 1 || y.length != 1) {
			return -1;
		} else {
			if (b == 0) {
				x[0] = 1;
				y[0] = 0;
				return a;
			} else {
				long gcd = xgcd(b, a % b, y, x);
				y[0] -= a / b * x[0];
				return gcd;
			}
		}
	}

	private static long modInverse(long a, long m) {
		long[] x = new long[1];
		long[] y = new long[1];
		long gcd = xgcd(a, m, x, y);
		if (gcd != 1) {
			return -1;
		} else {
			return Math.floorMod(x[0], m);
		}
	}
}