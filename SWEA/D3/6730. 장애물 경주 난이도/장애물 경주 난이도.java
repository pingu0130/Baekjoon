import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 배열에 계단담기
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int H = 0;
			int L = 0;
			for (int i = 1; i < N; i++) {
				if (arr[i - 1] > arr[i]) { // 내려가요
					L = Math.max(arr[i - 1] - arr[i], L);
				} else if (arr[i - 1] < arr[i]) { // 올라가요
					H = Math.max(arr[i] - arr[i - 1], H);
				}
			}
			System.out.printf("#%d %d %d\n", tc, H, L);
		}
	}
}