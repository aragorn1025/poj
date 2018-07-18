package poj.no1001;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private final static BigInteger	ZERO	= BigInteger.ZERO;
	private final static BigInteger	TEN		= BigInteger.TEN;
	private static Scanner			scanner	= new Scanner(System.in);

	public static void main(String[] args) {
		while (scanner.hasNext()) {
			String r = scanner.next();
			int n = scanner.nextInt();

			int digitFractionalPart = r.contains(".") ? (r.length() - r.indexOf(".") - 1) : 0;
			BigInteger d = new BigInteger(r.replace(".", ""), 10);
			if (d.equals(ZERO)) {
				System.out.println("0");
			} else if (n == 0) {
				System.out.println("1");
			} else {
				while (digitFractionalPart > 0 && d.mod(TEN).equals(ZERO)) {
					d = d.divide(BigInteger.TEN);
					digitFractionalPart--;
				}
				d = d.pow(n);
				digitFractionalPart = digitFractionalPart * n;

				String integerPart = d.divide(TEN.pow(digitFractionalPart)).toString();
				String fractionalPart = null;
				if (digitFractionalPart != 0) {
					char[] c = new char[digitFractionalPart];
					Arrays.fill(c, '0');
					String s = d.mod(TEN.pow(digitFractionalPart)).toString();
					for (int i = 1; i <= s.length(); i++) {
						c[c.length - i] = s.charAt(s.length() - i);
					}
					fractionalPart = new String(c);
				}
				if (digitFractionalPart == 0) {
					System.out.printf("%s%n", integerPart);
				} else {
					System.out.printf("%s.%s%n", integerPart.equals("0") ? "" : integerPart, fractionalPart);
				}
			}
		}
	}
}