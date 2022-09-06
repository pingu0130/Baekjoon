import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = String.valueOf(N);
		int len = s.length();
		int tmp = N - len * 10; // 최대로 뺄 수 있는 경우는 각 자리수*10
		int ans = tmp;
		int n = tmp; // N-30값으로 시작
		boolean flag = false;
		for (int i = 0; i < len * 10; i++) { // 숫자를 한자리씩 올려가면서 확인
			int m = n;
			for (int j = 0; j < len; j++) { // 각 자리수 더하기
				m += n % 10;
				n /= 10;
			}
			n = ans; // n값이 바뀌기때문에 다시 조정
			if (m == N) {
				flag = true;
			} else {
				ans++;
				n++;
			}
		}
		// 작은수부터 탐색해서 제일 먼저 찾은게 제일 작은것
		if (flag) {
			System.out.println(ans);
		} else { // 생성자 없으면 0출력
			System.out.println("0");
		}
	}
}