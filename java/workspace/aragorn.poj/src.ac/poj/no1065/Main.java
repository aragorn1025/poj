package poj.no1065;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		for (int testcase = scanner.nextInt(); testcase > 0; testcase--) {
			Stick[] sticks = new Stick[scanner.nextInt()];
			for (int i = 0; i < sticks.length; i++) {
				sticks[i] = new Stick(scanner.nextInt(), scanner.nextInt());
			}
			Arrays.sort(sticks);
			Queue<Stick> queue = new LinkedList<Stick>();
			for (int i = 0; i < sticks.length; i++) {
				queue.offer(sticks[i]);
			}

			int wt, size, output;
			output = 0;
			while (!queue.isEmpty()) {
				wt = 0;
				size = queue.size();
				output++;
				for (int i = 0; i < size; i++) {
					if (wt <= queue.peek().getW()) {
						wt = queue.poll().getW();
					} else {
						queue.offer(queue.poll());
					}
				}
			}
			System.out.println(output);
		}
	}
}

class Stick implements Comparable<Stick> {
	private int v;

	Stick(int l, int w) {
		v = l * 0x4000 + w;
	}

	int getL() {
		return v / 0x4000;
	}

	int getW() {
		return v % 0x4000;
	}

	@Override
	public int compareTo(Stick s2) {
		return v - s2.v;
	}
}