package poj.no2121.uns;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Scanner				scanner	= new Scanner(System.in);
	private static Map<String, Integer>	list	= new HashMap<String, Integer>();

	public static void main(String[] args) {
		makeList();

		String[] s;
		int output;
		while (scanner.hasNext()) {
			s = scanner.nextLine().split(" ");
			output = 0;
			for (int i = s.length - 1; i >= 0; i--) {
				if (s[i].equals("hundred") || s[i].equals("thousand") || s[i].equals("million")) {

				}
				output = output + list.get(s[i]);
			}
		}
	}

	private static void makeList() {
		list.put("negative", -1);
		list.put("zero", 0);
		list.put("one", 1);
		list.put("two", 2);
		list.put("three", 3);
		list.put("four", 4);
		list.put("five", 5);
		list.put("six", 6);
		list.put("seven", 7);
		list.put("eight", 8);
		list.put("nine", 9);
		list.put("ten", 10);
		list.put("eleven", 11);
		list.put("twelve", 12);
		list.put("thirteen", 13);
		list.put("fourteen", 14);
		list.put("fifteen", 15);
		list.put("sixteen", 16);
		list.put("seventeen", 17);
		list.put("eighteen", 18);
		list.put("nineteen", 19);
		list.put("twenty", 20);
		list.put("thirty", 30);
		list.put("forty", 40);
		list.put("fifty", 50);
		list.put("sixty", 60);
		list.put("seventy", 70);
		list.put("eighty", 80);
		list.put("ninety", 90);
		list.put("hundred", 100);
		list.put("thousand", 1000);
		list.put("million", 1000000);
		// -666,666,666
		// negative six hundred sixty six million six hundred sixty six thousand six hundred sixty six
	}
}