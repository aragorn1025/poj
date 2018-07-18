package poj.no3190.tle;

import java.io.IOException;
import java.io.PrintWriter;

public class TestData {
	public static void main(String[] args) throws IOException {
		PrintWriter output = new PrintWriter("data.txt");

		final int N = 50000;
		final int T_MAX = 1000000;
		output.printf("%d\n", N);
		int a, b;
		for (int i = 0; i < N; i++) {
			a = (int) (Math.random() * (T_MAX)) + 1;
			b = (int) (Math.random() * (T_MAX)) + 1;
			if (a == b) {
				b++;
			}
			output.printf("%d %d\n", Math.min(a, b), Math.max(a, b));
		}
		output.close();
	}
}