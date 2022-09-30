import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			sc.nextLine();
			String word = sc.nextLine();
			String line = sc.nextLine();
			int cnt = 0;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == word.charAt(0)) {
					int cntword = 1;
					for (int j = 1; j < word.length(); j++) {
						if (i + j < line.length() && line.charAt(i + j) == word.charAt(j)) {
							cntword++;
						}
					}
					if (cntword == word.length()) {
						cnt++;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		} // 테케
		sc.close();
	}
}
