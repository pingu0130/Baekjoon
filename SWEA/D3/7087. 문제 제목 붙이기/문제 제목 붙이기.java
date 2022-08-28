import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
//			System.out.print("#" + tc + " ");
			int N = Integer.parseInt(br.readLine());
			HashSet<Character> set = new HashSet<>();
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				set.add(s.charAt(0)); // 맨앞글자 넣기
			}
			int cnt = 0;
			for (int i = 0; i < set.size(); i++) {
				int a = 65 + i;
				char A = (char) a;
				if (set.contains(A)) {
					cnt++;
				} else {
					break;
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);

		} // 테케
	}
}