package poj.no3126;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		final int PRIME_MIN = 1000;
		final int PRIME_MAX = 9999;
		ArrayList<Integer> primeList = getPrimeList(PRIME_MIN, PRIME_MAX);

		int n = scanner.nextInt();
		int originPrime, newPrime, counter, i, j, m;
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> nextQueue = new LinkedList<Integer>();
		ArrayList<Integer> usedList = new ArrayList<Integer>();
		while (n-- > 0) {
			originPrime = scanner.nextInt();
			newPrime = scanner.nextInt();
			counter = 0;
			if (originPrime != newPrime) {
				queue.clear();
				nextQueue.clear();
				usedList.clear();
				nextQueue.add(originPrime);
				usedList.add(originPrime);
				while (!nextQueue.isEmpty() && !nextQueue.contains(newPrime)) {
					while (!nextQueue.isEmpty()) {
						m = nextQueue.poll();
						queue.add(m);
						usedList.add(m);
					}
					while (!queue.isEmpty()) {
						for (i = 0; i < 4; i++) {
							m = queue.peek();
							for (j = 0; j < 9; j++) {
								m = changeSpecificDecimalDigit(m, i);
								if (!primeList.contains(m) || usedList.contains(m) || nextQueue.contains(m)) {
									continue;
								}
								if (m == newPrime) {
									i = 4;
									j = 9;
									queue.clear();
									nextQueue.clear();
								}
								nextQueue.add(m);
							}
						}
						queue.poll();
					}
					counter++;
				}
			}
			System.out.printf("%d%n", counter);
		}
	}

	private static ArrayList<Integer> getPrimeList(int min, int max) {
		boolean[] isPrime = new boolean[max + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 0; i < isPrime.length; i++) {
			if (isPrime[i]) {
				for (int j = 2 * i; j <= max; j += i) {
					isPrime[j] = false;
				}
			}
		}
		ArrayList<Integer> val = new ArrayList<Integer>();
		for (int i = min; i <= max; i++) {
			if (isPrime[i]) {
				val.add(i);
			}
		}
		return val;
	}

	private static int changeSpecificDecimalDigit(int number, int changedDigitWeight) {
		int d = (int) Math.pow(10, changedDigitWeight);
		int val = number;
		while (true) {
			val = val / (d * 10) * (d * 10) + val % d + (val / d + 1) % 10 * d;
			if (Integer.toString(val).length() == Integer.toString(number).length()) {
				return val;
			}
		}
	}
}