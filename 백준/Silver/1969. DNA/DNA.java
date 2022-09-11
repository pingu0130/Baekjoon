import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		char[] ans = new char[M];
		int ansIdx = 0;
		// 한글자씩 비교해서 빈출단어 저장
		// T G C A 사전순으로 출력하려면 가장 뒤에 검사하는것으로 갱신되어야함
		for (int i = 0; i < M; i++) {
			int[] cnt = new int[4];
			for (int x = 0; x < N; x++) {
				switch (arr[x].charAt(i)) { // x의 i번째단어
				case 'T':
					cnt[0]++;
					break;
				case 'G':
					cnt[1]++;
					break;
				case 'C':
					cnt[2]++;
					break;
				case 'A':
					cnt[3]++;
					break;
				}
			} // for
			int max = 0;
			int idx = 0;
			for (int k = 0; k < 4; k++) { // 최빈값 구하기
				if (cnt[k] >= max) {
					max = cnt[k];
					idx = k;
				}
			}
			switch (idx) { // ans배열에 정답넣기
			case 0:
				ans[ansIdx] = 'T';
				break;
			case 1:
				ans[ansIdx] = 'G';
				break;
			case 2:
				ans[ansIdx] = 'C';
				break;
			case 3:
				ans[ansIdx] = 'A';
				break;
			}
			ansIdx++;
		}
		int hd = 0;
		for (int i = 0; i < N; i++) {
			for (int x = 0; x < M; x++) {
				if (arr[i].charAt(x) != ans[x]) { // 다른글자면 카운트
					hd++;
				}
			}
		}
		for (char a : ans) {
			System.out.print(a);
		}
		System.out.println();
		System.out.println(hd);
	}
}
