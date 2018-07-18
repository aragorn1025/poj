package poj.no1517;

import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) {
		int[] factorial = new int[13];
		factorial[0] = 1;
		for (int i = 1; i < factorial.length; i++) {
			factorial[i] = factorial[i - 1] * i;
		}

		System.out.printf("%s %s\n", "n", "e");
		System.out.printf("%s %s\n", "-", "-----------");
		double e = 0;
		DecimalFormat decimalFormat = new DecimalFormat("#.#########");
		for (int i = 0; i < 10; i++) {
			e = e + 1 / (double) factorial[i];
			System.out.printf("%d %s\n", i, decimalFormat.format(e));
		}
	}
}