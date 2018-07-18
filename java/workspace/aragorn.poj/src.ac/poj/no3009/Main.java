package poj.no3009;

import java.util.Scanner;

public class Main {
	private static Scanner		scanner		= new Scanner(System.in);

	// data
	private static final int	MAX_MOVE	= 10;
	private static int			w;
	private static int			h;
	private static int[][][]	board;
	private static int[]		x			= new int[MAX_MOVE + 1];
	private static int[]		y			= new int[MAX_MOVE + 1];
	private static int			output		= MAX_MOVE + 1;

	public static void main(String[] args) {
		while (true) {
			// inputs
			w = scanner.nextInt();
			h = scanner.nextInt();
			if (w == 0 || h == 0) {
				break;
			}
			board = new int[MAX_MOVE + 1][h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					board[0][i][j] = scanner.nextInt();
					if (board[0][i][j] == 2) {
						x[0] = j;
						y[0] = i;
					}
				}
			}

			// output
			output = MAX_MOVE + 1;
			depthFirstSearch(0);
			System.out.printf("%d\n", output <= MAX_MOVE ? output : -1);
		}
	}

	private static void depthFirstSearch(int movingNumber) {
		if (movingNumber >= 0 && movingNumber < MAX_MOVE && movingNumber < output) {
			int nx, ny;
			// throw the stone to the left
			nx = x[movingNumber];
			ny = y[movingNumber];
			while (true) {
				nx--;
				if (nx < 0) {
					// the stone gets out of the board
					break;
				} else {
					if (board[movingNumber][ny][nx] == 1) {
						// the stone is at the right side of the block
						if (nx == x[movingNumber] - 1) {
							break;
						}

						// the stone hits a block
						for (int i = 0; i < h; i++) {
							for (int j = 0; j < w; j++) {
								board[movingNumber + 1][i][j] = board[movingNumber][i][j];
							}
						}
						board[movingNumber + 1][y[movingNumber]][x[movingNumber]] = 0;
						board[movingNumber + 1][ny][nx] = 0;
						board[movingNumber + 1][ny][nx + 1] = 2;
						x[movingNumber + 1] = nx + 1;
						y[movingNumber + 1] = ny;
						depthFirstSearch(movingNumber + 1);
						break;
					} else if (board[movingNumber][ny][nx] == 3) {
						// the stone reaches the goal square
						output = Math.min(output, movingNumber + 1);
						break;
					} else {
						continue;
					}
				}
			}

			// throw the stone to the right
			nx = x[movingNumber];
			ny = y[movingNumber];
			while (true) {
				nx++;
				if (nx >= w) {
					// the stone gets out of the board
					break;
				} else {
					if (board[movingNumber][ny][nx] == 1) {
						// the stone is at the left side of the block
						if (nx == x[movingNumber] + 1) {
							break;
						}

						// the stone hits a block
						for (int i = 0; i < h; i++) {
							for (int j = 0; j < w; j++) {
								board[movingNumber + 1][i][j] = board[movingNumber][i][j];
							}
						}
						board[movingNumber + 1][y[movingNumber]][x[movingNumber]] = 0;
						board[movingNumber + 1][ny][nx] = 0;
						board[movingNumber + 1][ny][nx - 1] = 2;
						x[movingNumber + 1] = nx - 1;
						y[movingNumber + 1] = ny;
						depthFirstSearch(movingNumber + 1);
						break;
					} else if (board[movingNumber][ny][nx] == 3) {
						// the stone reaches the goal square
						output = Math.min(output, movingNumber + 1);
						break;
					} else {
						continue;
					}
				}
			}

			// throw the stone to the top
			nx = x[movingNumber];
			ny = y[movingNumber];
			while (true) {
				ny--;
				if (ny < 0) {
					// the stone gets out of the board
					break;
				} else {
					if (board[movingNumber][ny][nx] == 1) {
						// the stone is at the bottom of the block
						if (ny == y[movingNumber] - 1) {
							break;
						}

						// the stone hits a block
						for (int i = 0; i < h; i++) {
							for (int j = 0; j < w; j++) {
								board[movingNumber + 1][i][j] = board[movingNumber][i][j];
							}
						}
						board[movingNumber + 1][y[movingNumber]][x[movingNumber]] = 0;
						board[movingNumber + 1][ny][nx] = 0;
						board[movingNumber + 1][ny + 1][nx] = 2;
						x[movingNumber + 1] = nx;
						y[movingNumber + 1] = ny + 1;
						depthFirstSearch(movingNumber + 1);
						break;
					} else if (board[movingNumber][ny][nx] == 3) {
						// the stone reaches the goal square
						output = Math.min(output, movingNumber + 1);
						break;
					} else {
						continue;
					}
				}
			}

			// throw the stone to the bottom
			nx = x[movingNumber];
			ny = y[movingNumber];
			while (true) {
				ny++;
				if (ny >= h) {
					// the stone gets out of the board
					break;
				} else {
					if (board[movingNumber][ny][nx] == 1) {
						// the stone is at the top of the block
						if (ny == y[movingNumber] + 1) {
							break;
						}

						// the stone hits a block
						for (int i = 0; i < h; i++) {
							for (int j = 0; j < w; j++) {
								board[movingNumber + 1][i][j] = board[movingNumber][i][j];
							}
						}
						board[movingNumber + 1][y[movingNumber]][x[movingNumber]] = 0;
						board[movingNumber + 1][ny][nx] = 0;
						board[movingNumber + 1][ny - 1][nx] = 2;
						x[movingNumber + 1] = nx;
						y[movingNumber + 1] = ny - 1;
						depthFirstSearch(movingNumber + 1);
						break;
					} else if (board[movingNumber][ny][nx] == 3) {
						// the stone reaches the goal square
						output = Math.min(output, movingNumber + 1);
						break;
					} else {
						continue;
					}
				}
			}
		}
	}
}