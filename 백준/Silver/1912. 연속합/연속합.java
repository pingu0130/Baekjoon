import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[N + 1];
		dp[0] = arr[0];
		int max = arr[0];
		for (int i = 1; i < N; i++) {
			//
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			// 최댓값갱신
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		sc.close();
	}

}