import java.util.Scanner;

public class Main {
	/*
	 * 순열로 제일 큰 조합을 찾는다.
	 */
	static int[] arr, ans;
	static int N, max;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		max = 0;
		ans = new int[N];
		check = new boolean[N];
		per(0);
		System.out.println(max);
		sc.close();
	}

	private static void per(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int k = 0; k < N - 1; k++) {
				sum += Math.abs(ans[k] - ans[k + 1]);
			}
			max = Math.max(max, sum);
			return;
		}
		for (int j = 0; j < N; j++) {
			if (!check[j]) {
				ans[idx] = arr[j];
				check[j] = true;
				per(idx + 1);
				check[j] = false;
			}
		}

	}
}