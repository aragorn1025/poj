package poj.no1979;

import java.util.Scanner;

public class Main {
	private static Scanner	scanner	= new Scanner(System.in);

	// data
	private static int		w;
	private static int		h;
	private static char[][]	tiles;
	private static int		output;

	public static void main(String[] args) {
		while (true) {
			// inputs
			w = scanner.nextInt();
			h = scanner.nextInt();
			if (w == 0 || h == 0) {
				break;
			}
			tiles = new char[h][];
			for (int i = 0; i < h; i++) {
				tiles[i] = scanner.next().toCharArray();
			}

			// output
			output = 0;
			int x = 0;
			int y = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (tiles[i][j] == '@') {
						x = i;
						y = j;
						i = h;
						j = w;
					}
				}
			}
			depthFirstSearch(x, y);
			System.out.printf("%d\n", output);
		}
	}

	private static void depthFirstSearch(int x, int y) {
		output++;
		tiles[x][y] = '@';
		for (int dx = -1; dx <= 1; dx++) {
			int nx = x + dx;
			if (nx < 0 || nx >= h) {
				continue;
			}
			if (tiles[nx][y] == '.') {
				depthFirstSearch(nx, y);
			}
		}
		for (int dy = -1; dy <= 1; dy++) {
			int ny = y + dy;
			if (ny < 0 || ny >= w) {
				continue;
			}
			if (tiles[x][ny] == '.') {
				depthFirstSearch(x, ny);
			}
		}
	}
}