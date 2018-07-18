package poj.no1519;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		char[] c;
		while (true) {
			// inputs
			c = scanner.next().toCharArray();
			if (c.length == 1 && c[0] == '0') {
				break;
			}
			System.out.printf("%d\n", digitRoot(c));
		}
	}

	private static int digitRoot(char[] c) {
		int v = 0;
		for (int i = 0; i < c.length; i++) {
			v = v + (c[i] - '0');
		}
		return digitRoot(v);
	}

	private static int digitRoot(int n) {
		if (n >= 10) {
			int v = 0;
			int t = n;
			while (t > 0) {
				v = v + t % 10;
				t = t / 10;
			}
			return digitRoot(v);
		} else {
			return n;
		}
	}
}