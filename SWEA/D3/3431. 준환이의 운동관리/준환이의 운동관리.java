import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int ans = 0;
			if (L > X) { // 운동부족
				ans = L - X;
			} else if (U < X) {
				ans = -1;
			} else {
				ans = 0;
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}