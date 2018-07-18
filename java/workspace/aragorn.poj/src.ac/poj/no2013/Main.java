package poj.no2013;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = 0;
		int inputsNumber;
		String temp;
		String[] lists;

		while (true) {
			inputsNumber = scanner.nextInt();
			if (inputsNumber == 0) {
				break;
			}
			n++;
			System.out.printf("SET %d\n", n);
			lists = new String[inputsNumber / 2];
			for (int i = 0; i < inputsNumber; i++) {
				temp = scanner.next();
				if (i % 2 == 0) {
					System.out.printf("%s\n", temp);
				} else {
					lists[i / 2] = new String(temp);
				}
			}
			for (int i = 0; i < lists.length; i++) {
				System.out.printf("%s\n", lists[lists.length - i - 1]);
			}
		}
	}
}