import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); // 피곤해
		int B = Integer.parseInt(st.nextToken()); // 일
		int C = Integer.parseInt(st.nextToken()); // 피로감소
		int M = Integer.parseInt(st.nextToken()); // 최대피로도
		int P = 0; // 피로
		int ans = 0; // 이만큼일했다
		for (int i = 0; i < 24; i++) {
			if (A > M) {
				break;
			} else {
				if (M - A < P) { // M을 넘는순간 파업해
					// 쉬기
					P -= C;
					if (P < 0) { // P가 음수로 내려가면 0으로바뀐다
						P = 0;
					}
				} else {
					P += A;
					ans += B;
				}
			}
		}
		System.out.println(ans);
	}
}