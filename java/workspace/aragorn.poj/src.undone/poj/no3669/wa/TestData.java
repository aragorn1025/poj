package poj.no3669.wa;

import java.io.IOException;
import java.io.PrintWriter;

public class TestData {
	public static void main(String[] args) throws IOException {
		PrintWriter output = new PrintWriter("data.txt");
		
		for (int i = 0; i < 300; i++) {
			for (int j = 0; j < 300; j++) {
				output.printf("%d %d %d\n", i, j, i + j + 2);
			}
		}
		output.close();
	}
}