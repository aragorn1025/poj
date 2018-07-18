package poj.no2000;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int temp;
		int input;
		int output;

		while (true) {
			input = scanner.nextInt();
			if (input == 0) {
				break;
			}
			System.out.printf("%d ", input);

			temp = 0;
			output = 0;
			while (input > 0) {
				temp++;
				input = input - temp;
				output = output + temp * Math.min(temp, input + temp);
			}
			System.out.printf("%d\n", output);
		}
	}
}