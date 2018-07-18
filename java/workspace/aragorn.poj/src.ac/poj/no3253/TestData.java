package poj.no3253;

import java.io.IOException;
import java.io.PrintWriter;

public class TestData {
	public static void main(String[] args) throws IOException {
		PrintWriter output = new PrintWriter("data.txt");

		int n = 20000;
		output.printf("%d\n", n);
		for (int i = 0; i < n; i++) {
			output.printf("%d\n", 20000 - i);
		}
		output.close();
	}
}