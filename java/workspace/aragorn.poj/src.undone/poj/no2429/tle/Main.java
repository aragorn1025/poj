package poj.no2429.tle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int i, j, k;
		long gcd, lcm, factor, a = 0, b = 0, ta, tb, m, n;
		long[] primeFactorPowerValue = new long[16];
		Arrays.fill(primeFactorPowerValue, 1);
		/*-
		gcd	|	a		  b
			+-----------------
			  a/gcd		b/gcd
		
		lcm = a/gcd * b/gcd * gcd
		gcd(a/gcd, b/gcd) = 1
		 */

		while (scanner.hasNext()) {
			gcd = scanner.nextLong();
			lcm = scanner.nextLong();
			// 1 3403827853068126439: time limit exceed
			// System.out.printf("%d %d%n", gcd, lcm);
			m = lcm / gcd; // a / gcd * b / gcd
			factor = 2;
			n = 1;
			k = 0;
			while (m % factor == 0) {
				m /= factor;
				n *= factor;
			}
			if (n != 1) {
				primeFactorPowerValue[k] = n;
				System.out.printf("factor: %d%n", n);
				k++;
				n = 1;
			}
			factor++;
			for (; factor * factor <= m; factor += 2) {
				while (m % factor == 0) {
					m /= factor;
					n *= factor;
				}
				if (n != 1) {
					primeFactorPowerValue[k] = n;
					System.out.printf("factor: %d%n", n);
					k++;
					n = 1;
				}
			}
			if (m != 1) {
				primeFactorPowerValue[k] = m;
				k++;
			}

			m = Long.MAX_VALUE;
			for (i = 0; i < (1 << (k - 1)); i++) {
				ta = 1;
				for (j = 0; (i >> j) > 0; j++) {
					if ((i >> j) % 2 == 1) {
						ta *= primeFactorPowerValue[j];
					}
				}
				tb = lcm / gcd / ta;
				if (m > ta + tb) {
					m = ta + tb;
					a = ta;
					b = tb;
				}
			}
			System.out.printf("%d %d%n", Math.min(a, b) * gcd, Math.max(a, b) * gcd);
		}
	}
}