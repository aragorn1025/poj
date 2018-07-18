package poj.no3421;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		final int MAX_ROOT = 1 << 10; // Math.sqrt(Math.pow(2, 20))
		ArrayList<Integer> primeList = getPrimeList(MAX_ROOT);
		int x, m, n, radix, power, i, j;
		int[] primeFactor = new int[primeList.size() + 2];
		int[] primeFactorPower = new int[primeList.size() + 2];
		while (scanner.hasNext()) {
			x = scanner.nextInt();
			for (i = 0, j = 0; x != 1 && i < primeList.size(); i++) {
				radix = primeList.get(i);
				power = 0;
				m = 1;
				while (x % (m * radix) == 0) {
					power++;
					m *= radix;
				}
				if (power != 0) {
					primeFactor[j] = radix;
					primeFactorPower[j] = power;
					x /= m;
					j++;
				}
				if (radix * radix > x) {
					break;
				}
			}
			if (x > 1) {
				primeFactor[j] = x;
				primeFactorPower[j] = 1;
				x = 1;
				j++;
			}
			primeFactor[j] = 0;
			primeFactorPower[j] = 0;

			m = 0;
			for (i = 0; i < primeList.size() && primeFactorPower[i] != 0; i++) {
				m += primeFactorPower[i];
			}
			System.out.printf("%d ", m);
			n = 1;
			for (i = 0; i < primeList.size() && m > 0; i++) {
				for (j = 1; j <= primeFactorPower[i]; j++, m--) {
					n = n * m / j;
				}
			}
			System.out.printf("%d%n", n);
		}
	}

	private static ArrayList<Integer> getPrimeList(int max) {
		ArrayList<Integer> val = new ArrayList<Integer>();
		boolean[] isPrime = new boolean[max + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i <= max; i++) {
			if (isPrime[i]) {
				val.add(i);
				if (i * i <= max) {
					for (int j = i * 2; j <= max; j += i) {
						isPrime[j] = false;
					}
				}
			}
		}
		return val;
	}
}