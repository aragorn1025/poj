package poj.no1019.uns;

import java.util.Scanner;

public class Main {
	@SuppressWarnings("unused")
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		for (int i = 0; i < 32000; i++)
			System.out.println(i + ": " + BitSum(i));
		/*-
		int t = scanner.nextInt();
		int i, c, output;
		while (t-- > 0) {
			i = scanner.nextInt();
			int x = 1;
			int temp = 0;
			while (temp <= i) {
		
			}
			/*-
			c = 1;
			while (i - c * 9 * (int) Math.pow(10, c - 1) > 0) {
				i = i - c * 9 * (int) Math.pow(10, c - 1);
				c++;
			}
			output = (int) Math.pow(10, c - 1) + (i - 1) / c;
			c = c - (i - 1) % c - 1;
			// System.out.println(output + " " + c + " " + ((output / (int) Math.pow(10, c)) % 10));
			System.out.printf("%d%n", ((output / (int) Math.pow(10, c)) % 10));
			
		}
		*/
	}

	private static int BitSum(int n) {
		long val = 0;
		for (int i = 1; i <= n; i++) {
			val = val + (int) (Math.floor(Math.log10(i)) + 1) * (n - i + 1);
		}
		if (val - Integer.MAX_VALUE > 0) {
			return -1;
		} else {
			return (int) val;
		}
	}
}