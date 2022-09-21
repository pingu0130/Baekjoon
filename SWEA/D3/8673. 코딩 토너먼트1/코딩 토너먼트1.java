import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			int k = Integer.parseInt(br.readLine());
			k = (int) Math.pow(2, k);
			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++)
				list.add(Integer.parseInt(st.nextToken()));
			// 토너먼트 게임 수 : 참여자수 -1
			int ans = 0;
			int idx = 1;
			for (int i = 1; i < k; i++) {
				// 지루함 계산
				ans += Math.abs(list.get(idx) - list.get(idx - 1));
				// 이긴사람 계산
				if (list.get(idx) == Math.max(list.get(idx), list.get(idx - 1))) {
					list.remove(idx - 1); // 작은 것은 지우고
				} else {
					list.remove(idx);
				}
				idx++;
				// 범위밖으로 나가면 재설정
				if (idx > list.size() - 1) {
					idx = 1;
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
