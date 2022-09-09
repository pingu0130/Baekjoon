import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		// 배열채우기
		// 한 회차에 뻔, 데기는 /2번 나온다. 따라서 T*2가 전체개수
		int t = T * 2;
		int pattern = 0; // 몇개의 패턴이 있는지
		while (t > 0) {
			list.add(0);
			list.add(1);
			list.add(0);
			list.add(1);
			for (int i = 0; i < pattern + 2; i++) {
				list.add(0);
			}
			for (int i = 0; i < pattern + 2; i++) {
				list.add(1);
			}
			// 필요한 만큼 패턴을 다 만들었는지 검사
			t = t - (8 + (pattern * 2));
			pattern++;
		}

		int ans = 0;
		int cntT = T;
		if (B == 0) { // 뻔이면
			for (int k = 0; k < list.size(); k++) { // 배열을 돌면서 뻔 찾기
				if (list.get(k) == 0) {
					cntT--;
				}
				if (cntT == 0) {
					ans = k;
					break;
				}
			}
		} else {
			for (int k = 0; k < list.size(); k++) {
				if (list.get(k) == 1) {
					cntT--;
				}
				if (cntT == 0) {
					ans = k;
					break;
				}
			}
		}
		// T>A인 경우에 사람이 반복, 몇번반복되는지=몫 몇번째사람인지=나머지
		ans %= A;
		System.out.println(ans);
	}
}