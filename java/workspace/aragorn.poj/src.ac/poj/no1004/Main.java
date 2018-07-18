package poj.no1004;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		double sum = 0;
		for (int i = 0; i < 12; i++) {
			sum += scanner.nextDouble();
		}

		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("$" + df.format(sum / 12.0));
	}
}