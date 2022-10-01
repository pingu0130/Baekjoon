import java.util.Scanner;

public class Main {
	static String line, word;
	static int ans;
	static int[] table;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		line = sc.nextLine();
		word = sc.nextLine();
		ans = 0;
		makeTable(line);
		KMP();
		System.out.println(ans);
		sc.close();
	}

	private static void KMP() {
		int n1 = line.length(), n2 = word.length();
		int begin = 0, matched = 0;
		while (begin <= n1 - n2) {
			if (matched < n2 && line.charAt(begin + matched) == word.charAt(matched)) {
				++matched;
				if (matched == n2) {
					ans = 1;
				}
			} else {
				if (matched == 0) {
					++begin;
				} else {
					begin += matched - table[matched - 1];
					matched = table[matched - 1];
				}
			}

		}

	}

	private static void makeTable(String pattern) {
		int n = pattern.length();
		table = new int[n];

		int idx = 0;
		for (int i = 1; i < n; i++) {
			while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(idx)) {
				idx += 1;
				table[i] = idx;
			}
		}
	}
}