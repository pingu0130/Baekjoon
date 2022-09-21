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
			int max = 0;
			int min = 9999999;
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				int N = Integer.parseInt(st.nextToken());
				while (N != 0) {
					sum += N % 10;
					N /= 10;
				}
				max = Math.max(max, sum);
				min = Math.min(min, sum);
				sum = 0;
			}
			System.out.printf("#%d %d %d\n", tc, max, min);
		}
	}
}