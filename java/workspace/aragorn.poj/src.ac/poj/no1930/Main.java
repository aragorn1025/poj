package poj.no1930;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String line, number;
		long n, p, q, r, s, t, numerator = 0, denominator, gcd;
		int i;
		while (true) {
			line = scanner.nextLine();
			if (line.equals("0")) {
				break;
			}
			number = line.replaceFirst("0", "").replace(".", "");
			n = toDecimal(number.toCharArray());
			r = (long) Math.pow(10, number.length()); // 10 ^ l
			s = 1;
			t = r;
			denominator = Long.MAX_VALUE;
			for (i = 1; i <= number.length(); i++) {
				s *= 10;
				t /= 10;
				p = n - n / s;
				q = r - t;
				gcd = gcd(p, q);
				if (denominator > q / gcd) {
					numerator = p / gcd;
					denominator = q / gcd;
				}
			}
			System.out.printf("%d/%d%n", numerator, denominator);
		}
	}

	private static long toDecimal(char[] number) {
		long val = 0;
		for (int i = 0; i < number.length; i++) {
			val = val * 10 + (number[i] - '0');
		}
		return val;
	}

	private static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
}