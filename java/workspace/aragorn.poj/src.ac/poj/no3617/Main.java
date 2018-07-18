package poj.no3617;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		char[] s = new char[n];
		for (int i = 0; i < n; i++) {
			s[i] = scanner.next().toCharArray()[0];
		}

		int front = 0;
		int rear = n - 1;
		int temp = 0;
		char[] t = new char[n];
		while (front <= rear) {
			if (putLeft(front, rear, s)) {
				t[temp] = s[front];
				front++;
			} else {
				t[temp] = s[rear];
				rear--;
			}
			temp++;
		}
		for (int i = 0; i < n; i++) {
			System.out.printf("%c", t[i]);
			if ((i + 1) % 80 == 0 && i+1 != n) {
				System.out.println();
			}
		}
	}

	private static boolean putLeft(int front, int rear, char[] s) {
		if (front >= rear) {
			return true;
		} else if (s[front] < s[rear]) {
			return true;
		} else if (s[front] > s[rear]) {
			return false;
		} else { // s[front] == s[rear]
			return putLeft(front + 1, rear - 1, s);
		}
	}
}