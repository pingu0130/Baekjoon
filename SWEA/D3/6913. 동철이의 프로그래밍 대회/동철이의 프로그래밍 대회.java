import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			int sol = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sol += arr[i][j];
				}
				if (max < sol) {
					max = sol;
					//max가 갱신되면 1등의 수도 바뀌기 때문에
					cnt = 0;
					cnt++;
				} else if (max == sol) {
					cnt++;
				}
				sol = 0;
			}

			System.out.print("#" + tc + " " + cnt + " " + max + "\n");
		} // 테케
	}
}