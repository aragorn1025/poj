package poj.no2010;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt(); // 1 <= n <= 19,999
		int c = scanner.nextInt(); // n <= c <= 100,000
		int f = scanner.nextInt(); // 0 <= f <= 2,000,000,000
		Calf[] calfs = new Calf[c];
		for (int i = 0; i < c; i++) {
			calfs[i] = new Calf(scanner.nextInt(), scanner.nextInt());
		}

		int output = -1;
		Arrays.sort(calfs);
		if (n == 1) {
			for (int i = 0; i < c; i++) {
				if (calfs[i].f_aid <= f) {
					output = calfs[i].score;
					break;
				}
			}
		} else {
			int[] hf = new int[c];
			int[] lf = new int[c];
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			for (int i = 0, sum = 0; i < c; i++) {
				if (pq.size() < n / 2) {
					sum += calfs[i].f_aid;
					pq.add((-1) * calfs[i].f_aid);
					hf[i] = (pq.size() < n / 2) ? -1 : sum;
				} else {
					if (pq.peek() + calfs[i].f_aid < 0) {
						sum += pq.remove() + calfs[i].f_aid;
						pq.add((-1) * calfs[i].f_aid);
					}
					hf[i] = sum;
				}
			}
			pq.clear();
			for (int i = c - 1, sum = 0; i >= 0; i--) {
				if (pq.size() < n / 2) {
					sum += calfs[i].f_aid;
					pq.add((-1) * calfs[i].f_aid);
					lf[i] = (pq.size() < n / 2) ? -1 : sum;
				} else {
					if (pq.peek() + calfs[i].f_aid < 0) {
						sum += pq.remove() + calfs[i].f_aid;
						pq.add((-1) * calfs[i].f_aid);
					}
					lf[i] = sum;
				}
			}

			for (int i = 1; i < c - 1; i++) {
				if (hf[i - 1] <= 0 || lf[i + 1] <= 0) {
					continue;
				} else if (hf[i - 1] + lf[i + 1] + calfs[i].f_aid <= f) {
					output = calfs[i].score;
					break;
				}
			}
		}
		System.out.println(output);
	}
}

class Calf implements Comparable<Calf> {
	int	score;
	int	f_aid;

	Calf(int score, int f_aid) {
		this.score = score;
		this.f_aid = f_aid;
	}

	public int compareTo(Calf c) {
		return (-1) * (this.score - c.score);
	}
}