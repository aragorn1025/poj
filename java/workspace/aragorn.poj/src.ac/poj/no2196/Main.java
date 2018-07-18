package poj.no2196;

public class Main {
	private static final int	MIN	= 1000;
	private static final int	MAX	= 9999;

	public static void main(String[] args) {
		int[] b = new int[] { 10, 12, 16 };
		int[] d = new int[b.length];
		for (int i = MIN; i <= MAX; i++) {
			for (int j = 0; j < b.length; j++) {
				d[j] = getDigitSum(i, b[j]);
			}
			if (d[0] == d[1] && d[1] == d[2]) {
				System.out.printf("%d%n", i);
			}
		}
	}

	private static int getDigitSum(int n, int b) {
		int val = 0;
		while (n > 0) {
			val = val + n % b;
			n = n / b;
		}
		return val;
	}
}