import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc < 11; tc++) {
			sb.append("#" + tc + " ");
			int len = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 명령어 받기
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int order = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < order; i++) {
				String string = st.nextToken();
				// 명령수행
				switch (string) {
				case "I":
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						int s = Integer.parseInt(st.nextToken());
						list.add(x + j, s);
					}
					break;
				case "D":
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
					break;
				case "A":
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						int s = Integer.parseInt(st.nextToken());
						list.add(s);
					}
					break;
				}
			}
			for (int k = 0; k < 10; k++) {
				sb.append(list.get(k) + " ");
			}
			System.out.println(sb);
			sb.setLength(0);
		} // 테케
	}
}