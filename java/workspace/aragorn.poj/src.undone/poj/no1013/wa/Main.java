package poj.no1013.wa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		final int ROUNDS_NUMBER = 3;
		final int COINS_NUMBER = 12;

		int[][] coins = new int[COINS_NUMBER][3];
		final int TRUEONE = 0, LIGHTER = 1, HEAVIER = 2;

		char[][] side = new char[2][];
		final int LEFT = 0, RIGHT = 1;

		Status status = Status.NULL;
		ArrayList<Integer> counterfiet = new ArrayList<Integer>();

		int n = scanner.nextInt(); // case number
		while (n-- > 0) {
			// initial
			for (int i = 0; i < coins.length; i++) {
				Arrays.fill(coins[i], 0);
			}
			for (int rounds = 0; rounds < ROUNDS_NUMBER; rounds++) {
				// inputs
				for (int i = 0; i < side.length; i++) {
					side[i] = scanner.next().toUpperCase().toCharArray();
					Arrays.sort(side[i]);
				}
				status = toStatus(scanner.next().toLowerCase());

				// count
				switch (status) {
				case RIGHT_DOWN:
					for (int i = 0, p = 0, q = 0; i < COINS_NUMBER; i++) {
						if (p < side[LEFT].length && side[LEFT][p] == 'A' + i) {
							coins[i][LIGHTER]++;
							p++;
						} else if (q < side[RIGHT].length && side[RIGHT][q] == 'A' + i) {
							coins[i][HEAVIER]++;
							q++;
						} else {
							coins[i][TRUEONE]++;
						}
					}
					break;
				case RIGHT_UP:
					for (int i = 0, p = 0, q = 0; i < COINS_NUMBER; i++) {
						if (p < side[LEFT].length && side[LEFT][p] == 'A' + i) {
							coins[i][HEAVIER]++;
							p++;
						} else if (q < side[RIGHT].length && side[RIGHT][q] == 'A' + i) {
							coins[i][LIGHTER]++;
							q++;
						} else {
							coins[i][TRUEONE]++;
						}
					}
					break;
				case EVEN:
					for (int i = 0; i < side[LEFT].length; i++) {
						coins[side[RIGHT][i] - 'A'][TRUEONE]++;
						coins[side[LEFT][i] - 'A'][TRUEONE]++;
					}
					break;
				default:
					break;
				}

				counterfiet.clear();
				for (int i = 0; i < COINS_NUMBER; i++) {
					if (coins[i][TRUEONE] == 0 && (coins[i][LIGHTER] == 0 || coins[i][HEAVIER] > 0)) {

					}
				}

				// output

			}
		}
	}

	private static enum Status {
		NULL, EVEN, RIGHT_DOWN, RIGHT_UP;
	}

	private static Status toStatus(String status) {
		if (status.equals("even")) {
			return Status.EVEN;
		} else if (status.equals("down")) {
			return Status.RIGHT_DOWN;
		} else if (status.equals("up")) {
			return Status.RIGHT_UP;
		}
		return Status.NULL;
	}
}