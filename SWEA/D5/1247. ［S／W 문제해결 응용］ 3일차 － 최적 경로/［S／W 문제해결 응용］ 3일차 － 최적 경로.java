import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] dot;
	static boolean[] cheak;
	static int[][] result;
	static int N, ans, min;

	public static void sal(int idx) {
		if (idx == N + 1) {
			// 거리구하기
			for (int i = 0; i < N + 1; i++) {
				ans += Math.abs(result[i][0] - result[i + 1][0]) + Math.abs(result[i][1] - result[i + 1][1]);
			}
			min = Math.min(ans, min);
			ans = 0;
//			System.out.println(min);
			return;
		}
		for (int i = 1; i < N + 1; i++) {
			if (cheak[i]) {
				continue;
			}
			result[idx][0] = dot[i][0];
			result[idx][1] = dot[i][1];
//			System.out.println(Arrays.deepToString(result));
			cheak[i] = true;
			sal(idx + 1);
			cheak[i] = false;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			dot = new int[N + 2][2];
			// 0은 회사 N+1은 집
			dot[0][0] = Integer.parseInt(st.nextToken());
			dot[0][1] = Integer.parseInt(st.nextToken());
			dot[N + 1][0] = Integer.parseInt(st.nextToken());
			dot[N + 1][1] = Integer.parseInt(st.nextToken());
			// 가운데는 고객
			for (int i = 1; i < N + 1; i++) {
				dot[i][0] = Integer.parseInt(st.nextToken());
				dot[i][1] = Integer.parseInt(st.nextToken());
			}
			min = 999999999;
			result = new int[N + 2][2];
			// 앞뒤에 회사 집 채워주기
			result[0][0] = dot[0][0];
			result[0][1] = dot[0][1];
			result[N + 1][0] = dot[N + 1][0];
			result[N + 1][1] = dot[N + 1][1];
			cheak = new boolean[N + 2];
			sal(1);
			System.out.print("#" + tc + " " + min + "\n");
		} // 테케
	}
}