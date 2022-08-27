import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			int ans = 0; // 이동거리
			int N = Integer.parseInt(br.readLine());
			int speed = 0;
			int now = speed; // 현재속도
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int com = Integer.parseInt(st.nextToken());
				switch (com) {
				case 0:
					ans += now;
					break;
				case 1:
					speed = Integer.parseInt(st.nextToken()); // 입력받아서
					now += speed;
					ans += now;
					break;
				case 2:
					speed = Integer.parseInt(st.nextToken());
					if (now - speed < 0) {
						now = 0;
					} else {
						now -= speed;
					}
					ans += now;
					break;
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		} // 테케
	}
}
