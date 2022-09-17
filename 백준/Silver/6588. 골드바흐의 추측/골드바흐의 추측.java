import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 소수구하기
		boolean[] prime = new boolean[1000001];
		prime[0] = prime[1] = true;
		for (int i = 2; i * i < 1000001; i++) {
			if (!prime[i]) {
				for (int j = i * i; j < 1000001; j += i)
					prime[j] = true;
			}
		}
		int N = 0;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			int a = 0;
			int b = 0;
			// i와 N-i 의 합만이 N이 될 수 있으므로 두 수가 모두 소수인경우만 찾으면 돼!
			for (int i = 3; i < N; i += 2) {
				if (!prime[i] && !prime[N - i]) {
					a = i;
					b = N - i;
					break;
				}
			}
			if (a == 0 && b == 0) { // 답이없으면
				System.out.println("Goldbach's conjecture is wrong.");
			} else {
				System.out.printf("%d = %d + %d\n", N, a, b);
			}
		}
	}
}
