package poj.no3050;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] g = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				g[i][j] = scanner.nextInt();
			}
		}

		HashSet<Integer> set = new HashSet<Integer>();
		final int depth = 5;
		final int[] di = new int[] { 1, 0, -1, 0 };
		final int[] dj = new int[] { 0, 1, 0, -1 };
		int[] dp = new int[depth];
		int[] ni = new int[depth + 1];
		int[] nj = new int[depth + 1];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Arrays.fill(dp, 0);
				NextStatic: do {
					ni[0] = i;
					nj[0] = j;
					for (int k = 1; k <= depth; k++) {
						ni[k] = ni[k - 1] + di[dp[k - 1]];
						if (ni[k] < 0 || ni[k] >= g.length) {
							continue NextStatic;
						}
						nj[k] = nj[k - 1] + dj[dp[k - 1]];
						if (nj[k] < 0 || nj[k] >= g.length) {
							continue NextStatic;
						}
					}
					set.add(getValue(g, ni, nj));
				} while (nextStatic(dp, di.length));
			}
		}
		System.out.println(set.size());
	}

	private static int getValue(int[][] g, int[] ni, int[] nj) {
		int val = 0;
		for (int i = 0; i < ni.length; i++) {
			val = val * 10 + g[ni[i]][nj[i]];
		}
		return val;
	}

	private static boolean nextStatic(int[] nums, int max) {
		if (nums == null || nums.length < 1) {
			return false;
		}
		nums[0]++;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] >= max) {
				nums[i - 1] %= max;
				nums[i]++;
			} else {
				break;
			}
		}
		if (nums[nums.length - 1] >= max) {
			nums[nums.length - 1] %= max;
			return false;
		}
		return true;
	}
}