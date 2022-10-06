import java.util.Scanner;

public class Main {
	static int[][] paint;
	static int N, min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		paint = new int[N + 1][3];
		// 비용 배열
		for (int i = 1; i <= N; i++) {
			paint[i][0] = sc.nextInt();
			paint[i][1] = sc.nextInt();
			paint[i][2] = sc.nextInt();
		}
		// 1번집을 RGB로 각각 칠했을 때..
		// 다음 집은 남은 두 색중 작은 것+현재값
		for (int i = 1; i <= N; i++) {
			paint[i][0] = Math.min(paint[i - 1][1], paint[i - 1][2]) + paint[i][0];
			paint[i][1] = Math.min(paint[i - 1][0], paint[i - 1][2]) + paint[i][1];
			paint[i][2] = Math.min(paint[i - 1][1], paint[i - 1][0]) + paint[i][2];
		}
		System.out.println(Math.min(paint[N][2], Math.min(paint[N][0], paint[N][1])));

		sc.close();
	}
}