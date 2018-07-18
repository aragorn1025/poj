package poj.no2718;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// input cases number
		int n = scanner.nextInt();
		scanner.nextLine();

		String line;
		ArrayList<Integer> digits = new ArrayList<Integer>();
		int[] d;
		int x, y, output;
		for (int k = 0; k < n; k++) {
			// inputs
			line = scanner.nextLine();
			digits.clear();
			for (int i = 0; i < 10; i++) {
				if (line.indexOf('0' + i) != -1) {
					digits.add(i);
				}
			}
			d = new int[digits.size()];
			for (int i = 0; i < d.length; i++) {
				d[i] = digits.get(i);
			}
			Arrays.sort(d);
			if (d[0] == 0) {
				swap(d, 0, 1);
			}

			// get output
			if (d.length == 2) {
				output = Math.abs(d[0] - d[1]);
			} else {
				output = Integer.MAX_VALUE;
				do {
					if (d[0] != 0 && d[d.length / 2] != 0) {
						x = y = 0;
						for (int i = 0; i < d.length / 2; i++) {
							x = x * 10 + d[i];
						}
						for (int i = d.length / 2; i < d.length; i++) {
							y = y * 10 + d[i];
						}
						output = Math.min(output, Math.abs(x - y));
					}
				} while (nextPermutation(d));
			}
			System.out.println(output);
		}
	}

	private static boolean nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2) {
			return false;
		}

		int p = 0, q = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				p = i;
				break;
			}
		}
		for (int i = nums.length - 1; i > p; i--) {
			if (nums[i] > nums[p]) {
				q = i;
				break;
			}
		}

		if (p == 0 && q == 0) {
			reverse(nums, 0, nums.length - 1);
			return false;
		}

		swap(nums, p, q);
		if (p < nums.length - 1) {
			reverse(nums, p + 1, nums.length - 1);
		}
		return true;
	}

	private static void reverse(int[] nums, int l, int r) {
		while (l < r) {
			swap(nums, l++, r--);
		}
	}

	private static void swap(int[] nums, int p, int q) {
		nums[p] ^= nums[q];
		nums[q] ^= nums[p];
		nums[p] ^= nums[q];
	}
}