package poj.no1007;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		int n = scanner.nextInt(); // the length of the string
		int m = scanner.nextInt(); // the number of the strings
		DNA[] dna = new DNA[m];
		for (int i = 0; i < m; i++) {
			dna[i] = new DNA(scanner.next());
		}
		Arrays.sort(dna);
		for (int i = 0; i < m; i++) {
			System.out.println(dna[i].getSequence());
		}
	}
}

class DNA implements Comparable<DNA> {
	private char[]	letters	= new char[] { 'A', 'C', 'G', 'T' };
	private String	sequence;
	private int		unsortedness;

	private DNA() {
		Arrays.sort(letters);
	}

	public DNA(String sequence) {
		this();
		this.setSequence(sequence);
	}

	public String getSequence() {
		return sequence;
	}

	@Override
	public int compareTo(DNA another) {
		return this.unsortedness - another.unsortedness;
	}

	private void setSequence(String sequence) {
		this.sequence = sequence;
		this.unsortedness = 0;
		int[] counter = new int[letters.length];
		for (int i = 0; i < sequence.length(); i++) {
			for (int j = 0; j < letters.length; j++) {
				if (sequence.charAt(i) == letters[j]) {
					counter[j]++;
					while (++j < letters.length) {
						unsortedness += counter[j];
					}
					break;
				}
			}
		}
	}
}