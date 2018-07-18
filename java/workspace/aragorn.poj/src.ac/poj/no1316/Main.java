package poj.no1316;

public class Main {
	private static final int	MAX	= (int) Math.pow(10, 4);
	private static boolean[]	dp	= new boolean[MAX + 1];

	public static void main(String[] args) {
		int temp;
		for (int i = 1; i <= MAX; i++) {
			if (!dp[i]) {
				System.out.printf("%d\n", i);
			}
			temp = i;
			for (int j = i; j > 0; j = j / 10) {
				temp = temp + j % 10;
				if (temp > MAX) {
					break;
				}
			}
			if (temp <= MAX) {
				dp[temp] = true;
			}
		}
	}
}