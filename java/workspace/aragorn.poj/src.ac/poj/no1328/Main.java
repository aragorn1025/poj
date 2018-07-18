package poj.no1328;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int caseID = 0;
		int n, d;
		Island[] islands;
		double x;
		int p, output;
		while (true) {
			// inputs
			n = scanner.nextInt();
			d = scanner.nextInt();
			if (n == 0 && d == 0) {
				break;
			}
			islands = new Island[n];
			for (int i = 0; i < n; i++) {
				islands[i] = new Island(scanner.nextInt(), scanner.nextInt());
			}

			// output
			Arrays.sort(islands, Island.SORT_BY_Y_DESCEND);
			Arrays.sort(islands);
			output = 0;
			for (Island island : islands) {
				if (island.y > d) {
					output = -1;
					break;
				}
			}
			if (output >= 0) {
				p = 0;
				while (p < n) {
					x = islands[p].x + Math.sqrt(Math.pow(d, 2) - Math.pow(islands[p].y, 2));
					do {
						islands[p].isInRange = true;
						p++;
					} while (p < n && islands[p].getDistance(x, 0) <= d);
					if (p < n && x > islands[p].x + Math.sqrt(Math.pow(d, 2) - Math.pow(islands[p].y, 2))) {
						continue;
					}
					output++;
				}
			}
			System.out.printf("Case %d: %d\n", ++caseID, output);
		}
	}
}

class Island implements Comparable<Island> {
	public static Comparator<Island>	SORT_BY_Y_DESCEND	= new SortByYDescend();
	int									x;
	int									y;
	boolean								isInRange;

	public Island(int x, int y) {
		this.x = x;
		this.y = y;
		isInRange = false;
	}

	public double getDistance(double x, double y) {
		if (x == this.x) {
			return Math.abs(this.y - y);
		}
		if (y == this.y) {
			return Math.abs(this.x - x);
		}
		return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
	}

	@Override
	public int compareTo(Island compareIsland) {
		return this.x - compareIsland.x;
	}

	@Override
	public String toString() {
		return "Island [x=" + x + ", y=" + y + "]";
	}

	private static class SortByYDescend implements Comparator<Island> {
		@Override
		public int compare(Island island1, Island island2) {
			return island2.y - island1.y;
		}

	}
}