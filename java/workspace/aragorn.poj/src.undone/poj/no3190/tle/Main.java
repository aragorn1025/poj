package poj.no3190.tle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	private static Scanner	scanner	= new Scanner(System.in);
	private static long[]	times	= new long[8];

	public static void main(String[] args) {
		// inputs
		int n = scanner.nextInt();
		Cow[] cows = new Cow[n];
		for (int i = 0; i < n; i++) {
			int a = (int) (Math.random() * 99) + 1;
			int b = (int) (Math.random() * 99) + 1;
			if (a == b) {
				b++;
			}
			cows[i] = new Cow(i, Math.min(a, b), Math.max(a, b));
			// cows[i] = new Cow(i, scanner.nextInt(), scanner.nextInt());
		}

		// output
		times[0] = System.currentTimeMillis();
		int output = 0;
		Arrays.sort(cows, Cow.SORT_BY_A);
		Arrays.sort(cows, Cow.SORT_BY_B);
		int stallL;
		int stallR;
		int stallP;
		Stall[] stalls = new Stall[n];
		for (int i = 0; i < n; i++) {
			stalls[i] = new Stall(i + 1);
		}
		times[1] = System.currentTimeMillis();
		for (int i = 0; i < cows.length; i++) {
			stallL = 0;
			stallR = output;
			while (stallR > stallL) {
				stallP = (stallL + stallR) / 2;
				if (cows[i].a <= stalls[stallP].timePointer) {
					stallL = stallP + 1;
				} else {
					stallR = stallP;
				}
				if (cows[i].a == stalls[stallL].timePointer) {
					break;
				}
			}
			output = Math.max(output, stalls[stallL].id);
			cows[i].stall = stalls[stallL].id;
			stalls[stallL].timePointer = cows[i].b;
			times[6] = System.currentTimeMillis();
			Stall.sort(stalls, stallL);
			times[7] = System.currentTimeMillis();
			times[2] = times[2] + times[7] - times[6];
		}
		times[3] = System.currentTimeMillis();
		Arrays.sort(cows);
		times[4] = System.currentTimeMillis();
		System.out.printf("%d\n", output);
		for (Cow cow : cows) {
			System.out.printf("%d\n", cow.stall);
		}
		times[5] = System.currentTimeMillis();
		System.out.printf("N = %d, output = %d\n", n, output);
		System.out.printf("Used %5d milliseconds at loop.      \n", times[3] - times[1]);
		System.out.printf("Used %5d milliseconds at inner sort.\n", times[2]);
		System.out.printf("Used %5d milliseconds at print.     \n", times[5] - times[4]);
		System.out.printf("Used %5d milliseconds.              \n", times[5] - times[0]);
	}
}

class Cow implements Comparable<Cow> {
	public static final Comparator<Cow>	SORT_BY_A	= new SortByAAscendOrder();
	public static final Comparator<Cow>	SORT_BY_B	= new SortByBAscendOrder();

	public int							id;
	public int							a;
	public int							b;
	public int							stall;

	public Cow(int id, int a, int b) {
		super();
		this.id = id;
		this.a = a;
		this.b = b;
		this.stall = 0;
	}

	public int compareTo(Cow compareCow) {
		return this.id - compareCow.id;
	}

	private static class SortByAAscendOrder implements Comparator<Cow> {
		public int compare(Cow cow1, Cow cow2) {
			return cow1.a - cow2.a;
		}
	}

	private static class SortByBAscendOrder implements Comparator<Cow> {
		public int compare(Cow cow1, Cow cow2) {
			return cow1.b - cow2.b;
		}
	}
}

class Stall {
	public int	id;
	public int	timePointer;

	public Stall(int id) {
		this.id = id;
		this.timePointer = 0;
	}

	public static void sort(Stall[] stalls, int insertedIndex) {
		int l = 0;
		int r = insertedIndex - 1;
		int p;
		while (r > l) {
			p = (l + r) / 2;
			if (stalls[insertedIndex].timePointer > stalls[p].timePointer) {
				r = p - 1;
			} else {
				l = p;
			}
			if (stalls[insertedIndex].timePointer == stalls[l].timePointer) {
				break;
			}
		}
		Stall temp = stalls[insertedIndex];
		for (int i = insertedIndex; i > l; i--) {
			stalls[i] = stalls[i - 1];
		}
		stalls[l] = temp;
	}
}