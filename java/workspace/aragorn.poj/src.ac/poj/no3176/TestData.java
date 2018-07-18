package poj.no3176;

import java.io.IOException;
import java.io.PrintWriter;

public class TestData {
	public static void main(String[] args) throws IOException {
		PrintWriter output = new PrintWriter("data.txt");

		final int N = 350;
		output.printf("%d\n", N);
		final int MAX = 99;
		for (int i = 0; i < N; i++) {
			output.printf("%d", (int) (Math.random() * MAX));
			for (int j = 0; j < i; j++) {
				output.printf(" %d", (int) (Math.random() * MAX));
			}
			output.printf("\n");
		}
		output.close();
	}
}