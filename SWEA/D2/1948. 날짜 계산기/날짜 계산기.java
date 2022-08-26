import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int M1 = sc.nextInt();
			int D1 = sc.nextInt();
			int M2 = sc.nextInt();
			int D2 = sc.nextInt();
			// 365일중 몇번째 날인지 계산하면 되지않을까?
			int[] arr = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			int day1 = D1;
			for (int i = 1; i < M1; i++) {
				day1 += arr[i];
			}
			int day2 = D2;
			for (int i = 1; i < M2; i++) {
				day2 += arr[i];
			}
			int ans = day2 - day1 + 1;

			System.out.printf("#%d %d\n", tc, ans);
		} // 테케
		sc.close();
	}
}
