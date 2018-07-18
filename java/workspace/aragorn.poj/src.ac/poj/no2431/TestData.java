package poj.no2431;

import java.io.IOException;
import java.io.PrintWriter;

public class TestData {
	public static void main(String[] args) throws IOException {
		PrintWriter output = new PrintWriter("data.txt");

		final int n = 10;
		final int l = 100;
		final int p = (int) (Math.random() * l + 1);
		output.printf("%d\n", n);
		for (int i = 0; i < n; i++) {
			output.printf("%d %d\n", (int) (Math.random() * l + 1), (int) (Math.random() * 100 + 1));
		}
		output.printf("%d %d\n", l, p);
		output.close();
	}
}