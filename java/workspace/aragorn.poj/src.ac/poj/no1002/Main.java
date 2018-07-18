package poj.no1002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int[] count = new int[10000000];
		ArrayList<Integer> outputList = new ArrayList<Integer>();
		while (n-- > 0) {
			char[] phone = scanner.next().replaceAll("-", "").toUpperCase().toCharArray();
			int number = 0;
			for (int i = 0; i < phone.length; i++) {
				if (phone[i] >= '0' && phone[i] <= '9') {
					number = number * 10 + phone[i] - '0';
				} else if (phone[i] >= 'A' && phone[i] <= 'Z') {
					int temp = phone[i];
					if (temp >= 'S' && temp < 'Z') {
						temp--;
					} else if (temp == 'Z') {
						temp -= 2;
					}
					number = number * 10 + ((temp - 'A') / 3 + 2);
				}
			}
			count[number]++;
			if (count[number] == 2) {
				outputList.add(number);
			}
		}
		if (outputList.isEmpty()) {
			System.out.println("No duplicates.");
		} else {
			Collections.sort(outputList);
			for (int i = 0; i < outputList.size(); i++) {
				int index = outputList.get(i);
				System.out.printf("%03d-%04d %d%n", index / 10000, index % 10000, count[index]);
			}
		}
	}
}