import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			sb.append("#" + tc + " ");
			String s = br.readLine();
			// 모음이면 건너뛰고 자음이면 출력
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'o' || s.charAt(i) == 'i'
						|| s.charAt(i) == 'u') {
					continue;
				} else {
					sb.append(s.charAt(i));
				}
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}