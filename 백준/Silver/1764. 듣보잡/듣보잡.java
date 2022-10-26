import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 한 배열을 기준으로 다른 배열에서 같은 것을 찾는다. 같은것이 있으면 교집합
 * 근데 이렇게 arr두개쓰니까 시간초과남. Hashset을 써야만 초과안난대 왜일까?
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (set.contains(s)) {
				ans.add(s);
			}

		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}

	}

}