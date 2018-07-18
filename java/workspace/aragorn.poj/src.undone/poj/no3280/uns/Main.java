package poj.no3280.uns;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// initial
		int[][] alphabets = new int[26][2];
		for (int i = 0; i < alphabets.length; i++) {
			alphabets[i][0] = -1;
			alphabets[i][1] = -1;
		}

		// inputs
		int n = scanner.nextInt(); // 1 <= n <= 26
		@SuppressWarnings("unused")
		int m = scanner.nextInt(); // 1 <= m <= 2000
		char[] string = scanner.next().toCharArray();
		while (n-- > 0) {
			int temp = (int) (Character.toLowerCase(scanner.next().charAt(0)) - 'a');
			alphabets[temp][0] = scanner.nextInt();
			alphabets[temp][1] = scanner.nextInt();
		}

		for (int i = 0; i < string.length; i++) {
			
		}
	}
}