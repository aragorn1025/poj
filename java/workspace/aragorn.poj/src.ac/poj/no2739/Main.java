package poj.no2739;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner				scanner	= new Scanner(System.in);
	private static final int			MAX		= 10000;
	private static ArrayList<Integer>	p		= new ArrayList<Integer>();

	public static void main(String[] args) {
		// make the prime list
		for (int i = 2; i <= MAX; i++) {
			if (isPrime(i)) {
				p.add(i);
			}
		}

		int x, s, output;
		while (true) {
			// input
			x = scanner.nextInt();
			if (x < 2 || x > 10000) {
				break;
			}

			// output
			output = 0;
			for (int i = 0; i < p.size() && p.get(i) <= x; i++) {
				s = 0;
				for (int j = i; j < p.size() && s < x; j++) {
					s = s + p.get(j);
					if (s == x) {
						output++;
					}
				}
			}
			System.out.printf("%d%n", output);
		}
	}

	private static boolean isPrime(long n) {
		if (n == 2) {
			return true;
		} else if (n > 2) {
			for (int i = 0; i < p.size(); i++) {
				if (n % p.get(i) == 0) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
}