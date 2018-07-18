package poj.no2431;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// inputs
		int n = scanner.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(n, new DiscendOrder());
		FuelStop[] fuelStops = new FuelStop[n];
		for (int i = 0; i < n; i++) {
			fuelStops[i] = new FuelStop(scanner.nextInt(), scanner.nextInt());
		}
		int l = scanner.nextInt();
		int p = scanner.nextInt();
		Arrays.sort(fuelStops);
		FuelStop.setL(l);

		// output
		int i = 0;
		int output = 0;
		while (p < l) {
			if (i < n && fuelStops[i].d() <= p) {
				queue.offer(fuelStops[i].a);
				i++;
			} else if (i < n && fuelStops[i].d() > p && queue.isEmpty()) {
				break;
			} else if (i >= n && queue.isEmpty()) {
				break;
			} else {
				output++;
				p = p + queue.poll();
			}
		}
		if (p < l) {
			output = -1;
		}
		System.out.printf("%d\n", output);
	}
}

class FuelStop implements Comparable<FuelStop> {
	private static int	l;
	private int			x;	// the distance from the town to the stop
	public int			a;	// the amount of fuel available at that stop

	public FuelStop(int x, int a) {
		this.x = x;
		this.a = a;
	}

	public static void setL(int l) {
		FuelStop.l = l;
	}

	public int d() {
		// return the distance from the start
		return l - x;
	}

	@Override
	public int compareTo(FuelStop o) {
		return this.d() - o.d();
	}
}

class DiscendOrder implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return -o1 + o2;
	}
}