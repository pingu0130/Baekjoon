import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			String s = br.readLine();
			int cnt = s.charAt(0) - '0';
			int peo = 0;
			int ans = 0;
			for (int i = 1; i < s.length(); i++) {
				if (i <= cnt) { // 박수치고있는 사람이 나보다 많으면
					cnt += s.charAt(i) - '0'; // 박수쳐
				} else { // 더 적으면
					peo = i - cnt; // 부족한 수많큼 용역불러
					cnt += peo + s.charAt(i) - '0';
				}
				ans += peo;
				peo = 0;
			}
			System.out.printf("#%d %d\n", tc, ans);
		} // 테케
	}
}
