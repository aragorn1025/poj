package poj.no3292;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner		scanner			= new Scanner(System.in);
	private static final int	MAX				= 1000000 + 1;
	private static boolean[]	isHPrime		= new boolean[MAX / 4 + 1];
	private static boolean[]	isSemiHPrime	= new boolean[MAX / 4 + 1];
	private static int[]		output			= new int[MAX / 4 + 1];

	public static void main(String[] args) {
		int i, j, k;
		Arrays.fill(isHPrime, true);
		Arrays.fill(isSemiHPrime, false);
		isHPrime[0] = false; // The first h-number, 1, is not a h-prime. It's an unit.
		for (i = 1; i < isHPrime.length; i++) {
			if (isHPrime[i]) {
				for (j = i; 4l * i * j + i + j < isHPrime.length; j++) {
					// (4i+1)(4j+1) is not a h-prime for all i*j!=0
					// (4i+1)(4j+1) = 16ij+4i+4j+1 = 4(4ij+i+j)+1
					isHPrime[4 * i * j + i + j] = false;
				}
			}
		}

		for (i = 1; i < isHPrime.length; i++) {
			if (isHPrime[i]) {
				for (j = i; 4l * i * j + i + j < isHPrime.length; j++) {
					// (4i+1)(4j+1) is a semi-h-prime for all 4i+1 and 4j+1 are h-primes
					// (4i+1)(4j+1) = 16ij+4i+4j+1 = 4(4ij+i+j)+1
					if (isHPrime[j]) {
						isSemiHPrime[4 * i * j + i + j] = true;
					}
				}
			}
		}

		output[0] = 0;
		for (i = 1; i < isHPrime.length; i++) {
			output[i] = output[i - 1] + (isSemiHPrime[i] ? 1 : 0);
		}

		while ((k = scanner.nextInt()) != 0) {
			System.out.printf("%d %d%n", k, output[(k - 1) / 4]);
		}
	}
}