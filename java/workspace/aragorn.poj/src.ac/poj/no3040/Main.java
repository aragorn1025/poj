package poj.no3040;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// inputs
		int n = scanner.nextInt();
		int c = scanner.nextInt();
		Money[] coins = new Money[n];
		for (int i = 0; i < n; i++) {
			coins[i] = new Money(scanner.nextInt(), scanner.nextInt());
		}
		Arrays.sort(coins);

		// output
		int i, j, tc;
		int[] tn = new int[n];
		int output = 0;
		for (i = 0; i < n; i++) {
			if (coins[i].v >= c) {
				output = output + coins[i].b;
				coins[i].b = 0;
			} else {
				while (coins[i].b != 0) {
					tc = c;
					for (j = i; j < n; j++) {
						if (tc == 0) {
							break;
						}
						if (coins[j].b > 0) {
							tn[j] = Math.min(tc / coins[j].v, coins[j].b);
							tc = tc - tn[j] * coins[j].v;
						} else {
							tn[j] = 0;
						}
					}
					for (j = n - 1; j >= i && tc > 0; j--) {
						if (tn[j] < coins[j].b) {
							tn[j]++;
							tc = tc - coins[j].v;
						}
					}
					if (tc > 0) {
						i = n;
						break;
					}
					tc = coins[i].b / tn[i];
					for (j = i + 1; j < n; j++) {
						if (tn[j] != 0) {
							tc = Math.min(tc, coins[j].b / tn[j]);
						}
					}
					output = output + tc;
					for (j = i; j < n; j++) {
						coins[j].b = coins[j].b - tn[j] * tc;
					}
				}
			}
		}
		System.out.printf("%d\n", output);
	}
}

class Money implements Comparable<Money> {
	public int	v;	// the value of the denomination
	public int	b;	// the number of the coins

	public Money(int v, int b) {
		super();
		this.v = v;
		this.b = b;
	}

	@Override
	public int compareTo(Money compareMoney) {
		return (-1) * (this.v - compareMoney.v);
	}
}