import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] memo;
	static int[][] cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 0; tc < TC; tc++) {
			N = sc.nextInt();
			memo = new int[41];
			cnt = new int[41][2];
			Arrays.fill(memo, -1);
			memo[0] = 0;
			memo[1] = 1;
			cnt[0][0] = 1;
			cnt[1][1] = 1;
			fibo(N);
			System.out.println(cnt[N][0] + " " + cnt[N][1]);
		}
		sc.close();
	}

	private static int fibo(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (memo[n] == -1) {
			memo[n] = fibo(n - 1) + fibo(n - 2);
			cnt[n][0] = cnt[n - 1][0] + cnt[n - 2][0];
			cnt[n][1] = cnt[n - 1][1] + cnt[n - 2][1];
		}
		return memo[n];
	}
}