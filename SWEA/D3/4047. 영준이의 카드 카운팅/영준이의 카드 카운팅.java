import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			System.out.print("#" + tc + " ");
			String s = br.readLine();
			int[] arrs = new int[14];
			int[] arrd = new int[14];
			int[] arrh = new int[14];
			int[] arrc = new int[14];

			for (int i = 0; i < s.length(); i += 3) { // 3씩증가해서 모양확인
				switch (s.charAt(i)) {
				case 'S':
					if (s.charAt(i + 1) - '0' == 0) {
						arrs[s.charAt(i + 2) - '0']++;
					} else {
						arrs[10 + s.charAt(i + 2) - '0']++;
					}
					break;
				case 'D':
					if (s.charAt(i + 1) - '0' == 0) {
						arrd[s.charAt(i + 2) - '0']++;
					} else {
						arrd[10 + s.charAt(i + 2) - '0']++;
					}
					break;
				case 'H':
					if (s.charAt(i + 1) - '0' == 0) {
						arrh[s.charAt(i + 2) - '0']++;
					} else {
						arrh[10 + s.charAt(i + 2) - '0']++;
					}
					break;
				case 'C':
					if (s.charAt(i + 1) - '0' == 0) {
						arrc[s.charAt(i + 2) - '0']++;
					} else {
						arrc[10 + s.charAt(i + 2) - '0']++;
					}
					break;
				}
			}
			int cnts = 0;
			int cntd = 0;
			int cnth = 0;
			int cntc = 0;
			int ans = 0;
			for (int i = 1; i < 14; i++) {
				if (arrs[i] == 2 || arrd[i] == 2 || arrh[i] == 2 || arrc[i] == 2) {
					ans = 1;
					break;
				}
				if (arrs[i] == 0) {
					cnts++;
				}
				if (arrd[i] == 0) {
					cntd++;
				}
				if (arrh[i] == 0) {
					cnth++;
				}
				if (arrc[i] == 0) {
					cntc++;
				}
			}
			if (ans == 0) {
				System.out.printf("%d %d %d %d\n", cnts, cntd, cnth, cntc);
			} else {
				System.out.print("ERROR\n");
			}
		} // 테케
	}
}
