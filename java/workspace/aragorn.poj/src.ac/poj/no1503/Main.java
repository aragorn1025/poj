package poj.no1503;

// import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String line;
		// BigInteger bigInteger = new BigInteger("0");
		VeryLongInteger output = new VeryLongInteger("0");
		while (true) {
			line = scanner.next();
			if (line.equals("0")) {
				break;
			}
			// bigInteger = output.add(new BigInteger(line));
			output.add(new VeryLongInteger(line));
		}
		// System.out.println(bigInteger.toString());
		System.out.println(output.toString());
	}
}

class VeryLongInteger {
	/*-
	 * VeryLongInteger (s[0])(s[1] )(s[2] )(s[3] )(s[4] )( s[5] )
	 * Array: c_108    [0~17][18~35][36~53][54~71][72~89][90~107]
	 */
	private long[] s = new long[6];

	public VeryLongInteger(String val) {
		char[] c = val.toCharArray();
		char[] c_108 = new char[108];
		Arrays.fill(c_108, ' ');
		for (int i = 0; i < c.length; i++) {
			c_108[i + 108 - c.length] = c[i];
		}
		for (int i = 0; i < 6; i++) {
			if (c_108[i * 18 + 17] != ' ') {
				for (int j = 0; j < 18; j++) {
					if (c_108[i * 18 + j] != ' ') {
						s[i] = s[i] * 10 + (c_108[i * 18 + j] - '0');
					}
				}
			}
		}
	}

	public void add(VeryLongInteger b) {
		for (int i = 5; i >= 0; i--) {
			s[i] = s[i] + b.s[i];
			if (i > 0) {
				s[i - 1] = s[i - 1] + s[i] / (long) 1e18;
				s[i] = s[i] % (long) 1e18;
			}
		}
	}

	@Override
	public String toString() {
		String returnString = new String();
		for (int i = 0; i < s.length; i++) {
			if (!returnString.isEmpty()) {
				returnString = returnString.concat(String.format("%018d", s[i]));
			} else if (returnString.isEmpty() && s[i] != 0L) {
				returnString = returnString.concat(s[i] + "");
			}
		}
		return returnString;
	}
}