import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			int sum = 0;
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { // 입력
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum = 0;
					if (i + M <= N && j + M <= N) {
						for (int a = i; a < i + M; a++) {
							for (int b = j; b < j + M; b++) {
								sum += arr[a][b];
							}
						}
					}
					max = Math.max(sum, max);
				}
			} // 탐색
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
