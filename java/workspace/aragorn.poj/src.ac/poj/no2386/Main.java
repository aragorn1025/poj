package poj.no2386;

import java.util.Scanner;

public class Main {
	private static Scanner		scanner	= new Scanner(System.in);

	// data
	private static int			n;
	private static int			m;
	private static boolean[][]	field;

	public static void main(String[] args) {
		// inputs
		n = scanner.nextInt();
		m = scanner.nextInt();
		field = new boolean[n][m];
		char[] temp;
		for (int i = 0; i < n; i++) {
			temp = scanner.next().toCharArray();
			for (int j = 0; j < m; j++) {
				if (temp[j] == 'W') {
					field[i][j] = true;
				} else {
					field[i][j] = false;
				}
			}
		}
		
		// output
		int output = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (field[i][j]) {
					depthFirstSearch(i, j);
					output++;
				}
			}
		}
		System.out.printf("%d\n", output);
	}

	private static void depthFirstSearch(int x, int y) {
		field[x][y] = false;
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				int nx = x + dx;
				if (nx < 0 || nx >= n) {
					continue;
				}
				int ny = y + dy;
				if (ny < 0 || ny >= m) {
					continue;
				}
				if (field[nx][ny]) {
					depthFirstSearch(nx, ny);
				}
			}
		}
	}
}