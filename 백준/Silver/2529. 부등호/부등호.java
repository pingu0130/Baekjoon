import java.util.Scanner;

public class Main {
	/*
	 * 순열만들어서 부등호조건 검사하고 최대최소 찾기
	 */
	static int[] ans;
	static String[] boo;
	static int N;
	static long max, min;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		boo = new String[N];
		for (int i = 0; i < N; i++) {
			boo[i] = sc.next();
		}
		max = 0;
		min = Long.MAX_VALUE;
		ans = new int[N + 1];
		check = new boolean[10];
		per(0);
		long[] maxans = new long[N + 1];
		long[] minans = new long[N + 1];
		for (int i = 0; i < N + 1; i++) {
			maxans[i] = max % 10;
			minans[i] = min % 10;
			max /= 10;
			min /= 10;
		}
		for (int i = N; i >= 0; i--) {
			System.out.print(maxans[i]);
		}
		System.out.println();
		for (int i = N; i >= 0; i--) {
			System.out.print(minans[i]);
		}

		sc.close();
	}

	private static void per(int idx) {
		if (idx == N + 1) {
			boolean flag = true;
			long num = 0;
			loop: for (int a = 0; a < N; a++) {
				switch (boo[a]) {
				case "<":
					if (ans[a] >= ans[a + 1]) {
						flag = false;
						break loop;
					}
					num += ans[a] * Math.pow(10, N - a);
					break;
				case ">":
					if (ans[a] <= ans[a + 1]) {
						flag = false;
						break loop;
					}
					num += ans[a] * Math.pow(10, N - a);
					break;
				}
			}
			// 최대최소찾기
			if (flag) {
				num += ans[N];
				max = Math.max(num, max);
				min = Math.min(num, min);
			}
			return;
		}
		for (int j = 9; j >= 0; j--) {
			if (!check[j]) {
				ans[idx] = j;
				check[j] = true;
				per(idx + 1);
				check[j] = false;
			}
		}

	}
}