package poj.no1017;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] p = new int[6];
		int output;
		while (true) {
			// inputs
			for (int i = 0; i < 6; i++) {
				p[i] = scanner.nextInt();
			}
			if (p[5] == 0 && p[4] == 0 && p[3] == 0 && p[2] == 0 && p[1] == 0 && p[0] == 0) {
				break;
			}

			// 6 * 6
			output = p[5];
			p[5] = 0;
			
			// 5* 5
			output = p[4] + output;
			p[0] = p[0] - p[4] * 11;
			p[4] = 0;
			
			// 4 * 4
			output = p[3] + output;
			p[1] = p[1] - p[3] * 5;
			p[3] = 0;
			
			// 3 * 3
			output = p[2] / 4 + output;
			if (p[2] % 4 == 1) {
				output++;
				p[0] = p[0] - 7;
				p[1] = p[1] - 5;
			} else if (p[2] % 4 == 2) {
				output++;
				p[0] = p[0] - 6;
				p[1] = p[1] - 3;
			} else if (p[2] % 4 == 3) {
				output++;
				p[0] = p[0] - 5;
				p[1] = p[1] - 1;
			}
			p[2] = 0;
			
			// 2 * 2
			if (p[1] <= 0) {
				p[0] = p[0] + p[1] * 4;
			} else {
				output = p[1] / 9 + output;
				if (p[1] % 9 != 0) {
					output++;
					p[0] = p[0] - (9 - p[1] % 9) * 4;
				}
			}
			p[1] = 0;
			
			// 1 * 1
			if (p[0] > 0) {
				output = p[0] / 36 + output;
				if (p[0] % 36 != 0) {
					output++;
				}
			}
			p[0] = 0;
			
			// output
			System.out.printf("%d\n", output);
		}
	}
}