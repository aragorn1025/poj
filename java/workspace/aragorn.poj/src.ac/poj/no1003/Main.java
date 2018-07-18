package poj.no1003;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		double temp;
		int output;
		while (true) {
			temp = scanner.nextDouble();
			if (temp == 0) {
				break;
			}
			
			output = 0;
			while (temp > 0) {
				output++;
				temp = temp - 1.0 / (output + 1.0);
			}
			System.out.printf("%d card(s)\n", output);
		}
	}
}