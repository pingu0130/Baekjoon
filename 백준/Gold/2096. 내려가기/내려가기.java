import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][3];
		// 점수판입력
		for (int i = 0; i < N; i++)
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		int[][] max = new int[N][3];
		int[][] min = new int[N][3];
		for (int j = 0; j < 3; j++) {
			max[0][j] = map[0][j];
			min[0][j] = map[0][j];
		}
		for (int i = 0; i < N - 1; i++) {
			max[i + 1][0] = Math.max(max[i][0], max[i][1]) + map[i + 1][0];
			max[i + 1][1] = Math.max(max[i][2], Math.max(max[i][0], max[i][1])) + map[i + 1][1];
			max[i + 1][2] = Math.max(max[i][1], max[i][2]) + map[i + 1][2];
			min[i + 1][0] = Math.min(min[i][0], min[i][1]) + map[i + 1][0];
			min[i + 1][1] = Math.min(min[i][2], Math.min(min[i][0], min[i][1])) + map[i + 1][1];
			min[i + 1][2] = Math.min(min[i][1], min[i][2]) + map[i + 1][2];
		}
		int high = Math.max(max[N - 1][2], Math.max(max[N - 1][0], max[N - 1][1]));
		int low = Math.min(min[N - 1][2], Math.min(min[N - 1][0], min[N - 1][1]));
		System.out.println(high + " " + low);
		sc.close();
	}
}