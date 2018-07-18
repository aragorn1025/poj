package poj.no3641;

import java.util.Scanner;

public class Main {
	private static Scanner	scanner	= new Scanner(System.in);
	private static String[]	output	= new String[] { "no", "yes" };

	public static void main(String[] args) {
		int p, a, outputIndex = 0; // 1 < a < p <= MAX

		while ((p = scanner.nextInt()) != 0 && (a = scanner.nextInt()) != 0) {
			if (!isPrime(p) && a == modPower(a, p, p)) {
				outputIndex = 1;
			} else {
				outputIndex = 0;
			}
			System.out.println(output[outputIndex]);
		}
	}

	private static boolean isPrime(int p) {
		if (p <= 3) {
			return true;
		}
		if (p % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= p; i += 2) {
			if (p % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int modPower(int base, int power, int modulus) {
		long val = 1;
		long n = base;
		for (int i = power; i > 0; i >>= 1) {
			val = (i % 2 == 1) ? (val * n % modulus) : val;
			n = n * n % modulus;
		}
		return (int) val;
	}
}