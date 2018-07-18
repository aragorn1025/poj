package poj.no3187;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int sum = scanner.nextInt();

		int[] d = new int[n];
		for (int i = 0; i < d.length; i++) {
			d[i] = i + 1;
		}

		int[] t;
		do {
			t = Arrays.copyOf(d, d.length);
			while (t.length > 1 && t[1] != 0) {
				for (int i = 0; i < t.length; i++) {
					if (i + 1 >= t.length || t[i + 1] == 0) {
						t[i] = 0;
						break;
					} else {
						t[i] = t[i] + t[i + 1];
					}
				}
			}
			if (t[0] == sum) {
				System.out.print(d[0]);
				for (int i = 1; i < d.length; i++) {
					System.out.print(" " + d[i]);
				}
				System.out.println();
				break;
			}
		} while (nextPermutation(d));
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