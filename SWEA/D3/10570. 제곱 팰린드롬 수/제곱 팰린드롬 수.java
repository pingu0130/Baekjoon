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
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int cnt = 0;
			loop: for (int i = A; i <= B; i++) {
				String s = String.valueOf(i);
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) != s.charAt(s.length() - 1 - j)) {
						continue loop;
					}
				}
				// 일단 제곱근이 정수인지 판별
				if (Math.sqrt(i) == Math.floor(Math.sqrt(i))) {
					// 정수라면 펠린드롬인지 판별
					String sqrt = String.valueOf((int) Math.sqrt(i));
					for (int j = 0; j < sqrt.length(); j++) {
						if (sqrt.charAt(j) != sqrt.charAt(sqrt.length() - 1 - j)) {
							continue loop;
						}
					}
				} else {
					continue loop;
				}
				cnt++;
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
}