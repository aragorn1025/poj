package poj.no1753;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// inputs
		String[] l = new String[4];
		for (int i = 0; i < 4; i++) {
			l[i] = scanner.next();
		}
		int input = binToDec((l[0] + l[1] + l[2] + l[3]).replace('b', '1').replace('w', '0'));

		int[] v = new int[16];
		v[0] = binToDec("1100100000000000");
		v[1] = binToDec("1110010000000000");
		v[2] = binToDec("0111001000000000");
		v[3] = binToDec("0011000100000000");
		v[4] = binToDec("1000110010000000");
		v[5] = binToDec("0100111001000000");
		v[6] = binToDec("0010011100100000");
		v[7] = binToDec("0001001100010000");
		v[8] = binToDec("0000100011001000");
		v[9] = binToDec("0000010011100100");
		v[10] = binToDec("0000001001110010");
		v[11] = binToDec("0000000100110001");
		v[12] = binToDec("0000000010001100");
		v[13] = binToDec("0000000001001110");
		v[14] = binToDec("0000000000100111");
		v[15] = binToDec("0000000000010011");

		int t, h;
		String s;
		int output = 17;
		for (int i = 0; i < 65536; i++) {
			h = hammingWeight(i);
			if (h >= output) {
				continue;
			}
			t = input;
			s = decToBin(i);
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '1') {
					t = t ^ v[16 - s.length() + j];
				}
			}
			if (t == 0 || t == 65535) {
				output = h;
			}
		}
		if (output <= 16) {
			System.out.printf("%d%n", output);
		} else {
			System.out.printf("%s%n", "Impossible");
		}
	}

	private static String decToBin(int dec) {
		return Integer.toBinaryString(dec);
	}

	private static int binToDec(String bin) {
		return Integer.parseInt(bin, 2);
	}

	private static int hammingWeight(int dec) {
		char[] c = Integer.toBinaryString(dec).toCharArray();
		int val = 0;
		for (int i = 0; i < c.length; i++) {
			val += (c[i] - '0');
		}
		return val;
	}
}