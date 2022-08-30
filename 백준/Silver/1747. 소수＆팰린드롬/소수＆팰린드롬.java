import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N + 1000000 <= 1)
			return;
		boolean[] arr = new boolean[N + 1000001];
		arr[0] = arr[1] = false;
		for (int i = 2; i <= N + 1000000; i++) { // 배열설정
			arr[i] = true;
		}
		for (int i = 2; i * i <= N + 1000000; i++) { // 1~B의 소수배열
			for (int j = i * i; j <= N + 1000000; j += i) {
				arr[j] = false;
			}
		}
		boolean ans = false;
		int a = N - 1;
		while (!ans) {
			a++;
			if (arr[a]) { // 소수인 경우에 검사
				String s = String.valueOf(a);
				char[] str = new char[s.length()];
				int j = 0;
				for (int i = s.length() - 1; i >= 0; i--) { // 배열에 거꾸로저장
					str[i] = s.charAt(j);
					j++;
				}
				boolean p = true;
				for (int i = 0; i < s.length(); i++) { // 거꾸로돌린것과 같으면 팰린드롬이야
					if (str[i] != s.charAt(i)) {
						p = false;
					}
				}
				if (p) { // 찾으면 끝
					ans = true;
				}
			}
		}
		System.out.println(a);
	}
}