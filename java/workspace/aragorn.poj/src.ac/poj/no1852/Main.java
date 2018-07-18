package poj.no1852;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int caseNumber = scanner.nextInt();
		int l;
		int n;
		int[] ants;
		int minTime;
		int maxTime;
		while (caseNumber > 0) {
			// input data
			l = scanner.nextInt();
			n = scanner.nextInt();
			ants = new int[n];
			for (int i = 0; i < n; i++) {
				ants[i] = scanner.nextInt();
			}
			Arrays.sort(ants);

			// get outputs
			minTime = 0;
			maxTime = 0;
			for (int i = 0; i < n; i++) {
				minTime = Math.max(Math.min(ants[i], l - ants[i]), minTime);
				maxTime = Math.max(Math.max(ants[i], l - ants[i]), maxTime);
			}
			System.out.printf("%d %d\n", minTime, maxTime);

			// the next loop
			caseNumber--;
		}
	}
}