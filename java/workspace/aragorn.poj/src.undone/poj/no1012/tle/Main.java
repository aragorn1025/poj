package poj.no1012.tle;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// final int MAX_K = 14;
		int prefix, mid, suffix, m, m_total, temp; // [bad][good][bad]
		while (true) {
			int k = scanner.nextInt();
			if (k == 0) {
				break;
			}
			m = k;
			while (true) {
				prefix = 0;
				mid = k;
				suffix = k;
				m++;
				while (prefix != 0 || suffix != 0) {
					m_total = (m - 1) % (prefix + mid + suffix) + 1;
					if (m_total <= prefix) {
						prefix = prefix - m_total;
						suffix = suffix + m_total - 1;
					} else if (m_total > prefix + mid) {
						temp = prefix; // for saving origin prefix
						prefix = prefix * 2 + mid + suffix - m_total;
						suffix = m_total - 1 - temp - mid;
					} else {
						mid--;
						break;
					}
				}
				if (mid == k) {
					System.out.println(m);
					break;
				}
			}
		}
	}
}