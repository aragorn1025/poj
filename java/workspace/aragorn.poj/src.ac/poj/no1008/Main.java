package poj.no1008;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		System.out.println(n);
		while (n-- > 0) {
			MayaCalendar calendar = new MayaCalendar((int) scanner.nextDouble(), scanner.next(), scanner.nextInt());
			System.out.println(calendar.toString());
		}
	}
}

class MayaCalendar {
	private static final String[]	HABB_MONTH					= new String[] { "pop", "no", "zip", "zotz", "tzec",
			"xul", "yoxkin", "mol", "chen", "yax", "zac", "ceh", "mac", "kankin", "muan", "pax", "koyab", "cumhu",
			"uayet" };
	private static final String[]	TZOLKIN_NAME				= new String[] { "imix", "ik", "akbal", "kan",
			"chicchan", "cimi", "manik", "lamat", "muluk", "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban",
			"eznab", "canac", "ahau" };
	private static final int		DAYS_IN_A_NORMAL_HABB_MONTH	= 20;
	private static final int		DAYS_IN_A_HABB_YEAR			= 365;
	private static final int		CYCLE_OF_TZOLKIN_NUMBER		= 13;
	private static final int		DAYS_IN_A_TZOLKIN_YEAR		= LEAST_COMMON_MULTIPLE(CYCLE_OF_TZOLKIN_NUMBER,
			TZOLKIN_NAME.length);

	private int						dayFromTheBeginningOfTheWorld;

	public MayaCalendar(int habbNumberOfTheDay, String habbMonth, int habbYear) {
		for (int i = 0; i < HABB_MONTH.length; i++) {
			if (habbMonth.toLowerCase().equals(HABB_MONTH[i])) {
				dayFromTheBeginningOfTheWorld = habbNumberOfTheDay + DAYS_IN_A_NORMAL_HABB_MONTH * i
						+ habbYear * DAYS_IN_A_HABB_YEAR;
				break;
			}
		}
	}

	private static int LEAST_COMMON_MULTIPLE(int a, int b) {
		return a * b / GREATEST_COMMON_DIVISOR(a, b);
	}

	private static int GREATEST_COMMON_DIVISOR(int a, int b) {
		if (a % b == 0) {
			return b;
		} else {
			return GREATEST_COMMON_DIVISOR(b, a % b);
		}
	}

	@Override
	public String toString() {
		int tzolkinNumber = 1 + dayFromTheBeginningOfTheWorld % CYCLE_OF_TZOLKIN_NUMBER;
		int tzolkinNameofTheDay = dayFromTheBeginningOfTheWorld % TZOLKIN_NAME.length;
		int tzolkinYear = dayFromTheBeginningOfTheWorld / DAYS_IN_A_TZOLKIN_YEAR;
		return String.format("%d %s %d", tzolkinNumber, TZOLKIN_NAME[tzolkinNameofTheDay], tzolkinYear);
	}
}