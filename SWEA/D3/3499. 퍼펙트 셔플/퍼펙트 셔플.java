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
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] arr = new String[N];
			String[] arr2 = new String[N];
			if (N % 2 == 0) { // 짝수면 반반
				for (int i = 0; i < N / 2; i++) { // 반나눠서 저장
					arr[i] = st.nextToken();
				}
			} else { // 홀수면 앞에 한장 더
				for (int i = 0; i <= N / 2; i++) {
					arr[i] = st.nextToken();
				}
			}
			for (int i = 0; i < N / 2; i++) {
				arr2[i] = st.nextToken();
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < N / 2 + 1; i++) {
				if (arr[i] != null)
					System.out.print(arr[i] + " ");
				if (arr2[i] != null)
					System.out.print(arr2[i] + " ");
			}
			System.out.println();
		} // 테케
	}
}
