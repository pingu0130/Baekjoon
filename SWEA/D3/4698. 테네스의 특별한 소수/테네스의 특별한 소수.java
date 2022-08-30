import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// 소수를 먼저 찾으면 시간이 너무 오래걸려. D중에서 소수를 찾자
			// 시간 초과어쩔거야.. 에라토스테네스의 체를 이용하래..!
			if (B <= 1)
				return;
			boolean[] arr = new boolean[B + 1];
			arr[0] = arr[1] = false;
			for (int i = 2; i <= B; i++) { // 배열설정
				arr[i] = true;
			}
			for (int i = 2; i * i <= B; i++) { // 1~B의 소수배열
				for (int j = i * i; j <= B; j += i) {
					arr[j] = false;
				}
			}

			int cnt = 0;
			for (int i = A; i < arr.length; i++) {
				if (arr[i] == true) { // 소수이면서
					String s = String.valueOf(i);
					if (s.contains(D)) { // D를포함하고 있으면
						cnt++;
					}
				}

			}
			System.out.printf("#%d %d\n", tc, cnt);
		} // 테케
	}
}
