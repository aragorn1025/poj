package poj.no1350;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n, max, min, b, counter;
		PriorityQueue<Integer> d = new PriorityQueue<Integer>(4);
		while (true) {
			n = scanner.nextInt();
			if (n == -1) {
				break;
			} else {
				System.out.printf("N=%d:%n", n);
				if (n < 1000 || n > 9999 || n % 1111 == 0) {
					System.out.printf("No!!%n");
					continue;
				}
				counter = 0;
				while (n != 0 && n != 6174) {
					counter++;
					d.clear();
					while (n > 0) {
						d.add(n % 10);
						n = n / 10;
					}
					b = (int) Math.pow(10, d.size() - 1);
					max = d.peek() * b;
					min = d.poll();
					while (!d.isEmpty()) {
						max = max / 10 + d.peek() * b;
						min = min * 10 + d.poll();
					}
					n = max - min;
					System.out.printf("%d-%d=%d%n", max, min, n);
				}
				System.out.printf("Ok!! %d times%n", counter);
			}
		}
	}
}