package poj.no3614;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// inputs
		int cn = scanner.nextInt();
		int ln = scanner.nextInt();
		PriorityQueue<Cow> pq = new PriorityQueue<Cow>(cn);
		for (int i = 0; i < cn; i++) {
			pq.add(new Cow(scanner.nextInt(), scanner.nextInt()));
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0, spf; i < ln; i++) {
			spf = scanner.nextInt();
			map.put(spf, (map.containsKey(spf) ? map.get(spf) : 0) + scanner.nextInt());
		}

		// output
		int output = 0;
		while (!pq.isEmpty()) {
			Cow cow = pq.remove();
			for (int i = cow.min_spf; i <= cow.max_spf; i++) {
				if (map.containsKey(i)) {
					if (map.get(i) == 1) {
						map.remove(i);
					} else {
						map.put(i, map.get(i) - 1);
					}
					output++;
					break;
				}
			}
		}
		System.out.println(output);
	}
}

class Cow implements Comparable<Cow> {
	int	min_spf;	// 1 <= min_spf <= max_spf
	int	max_spf;	// min_spf <= max_spf <= 1000

	Cow(int min_spf, int max_spf) {
		this.min_spf = min_spf;
		this.max_spf = max_spf;
	}

	public int compareTo(Cow o) {
		return this.max_spf - o.max_spf;
	}
}