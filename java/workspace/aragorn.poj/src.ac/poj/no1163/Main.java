package poj.no1163;

import java.util.Scanner;

public class Main {
	private static Scanner	scanner	= new Scanner(System.in);
	private static int		n;
	private static int[][]	inputs;
	private static int[][]	output;

	public static void main(String[] args) {
		n = scanner.nextInt();
		inputs = new int[n][];
		output = new int[n][];
		for (int i = 0; i < n; i++) {
			inputs[i] = new int[i + 1];
			output[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				inputs[i][j] = scanner.nextInt();
				output[i][j] = -1;
			}
		}
		System.out.printf("%d\n", getMaxRoute(0, 0));
	}

	private static int getMaxRoute(int layerNumber, int nodeNumber) {
		if (layerNumber >= n || layerNumber < nodeNumber) {
			return 0;
		} else if (output[layerNumber][nodeNumber] < 0) {
			output[layerNumber][nodeNumber] = inputs[layerNumber][nodeNumber] + Math.max(getMaxRoute(layerNumber + 1, nodeNumber), getMaxRoute(layerNumber + 1, nodeNumber + 1));
			return output[layerNumber][nodeNumber];
		} else {
			return output[layerNumber][nodeNumber];
		}
	}
}