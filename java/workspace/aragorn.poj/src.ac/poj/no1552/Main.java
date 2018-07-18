package poj.no1552;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		PriorityQueue<Short> list = new PriorityQueue<Short>();
		short temp;
		int output;
		while (true) {
			// inputs
			temp = scanner.nextShort();
			if (temp == -1) {
				break; // terminate the program
			}
			list.clear();
			while (temp != 0) {
				list.offer(temp);
				temp = scanner.nextShort();
			}

			// output
			output = 0;
			while (!list.isEmpty()) {
				temp = (short) (list.poll() * 2);
				if (temp >= 100) {
					break;
				}
				if (list.contains(temp)) {
					output++;
				}
			}
			System.out.printf("%d%n", output);
		}
	}
}