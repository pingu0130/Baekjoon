import java.util.Scanner;

public class Main {
	static int[][] arr, land;
	static int N, high, max, cnt;
	static int[][] dx = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		arr = new int[N + 2][N + 2];
		high = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = sc.nextInt();
				// 물의 수위를 알아뵈기위해 가장 높은땅을 찾는다.
				high = Math.max(arr[i][j], high);
			}
		}
		// 비가 0부터 온다
		max = 0;
		rain(0);
		System.out.println(max);
		sc.close();
	}

	// 비오면 땅찾는 함수
	public static void rain(int r) {
		// 비가 high만큼 오면 다 잠기니까
		if (r == high) {
			return;
		}
		// 비온다
		water(r);

		// 땅 찾기
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (land[i][j] != 0) {
					cnt++;
					land(i, j);
				}
			}
		}
		// 최대땅 저장
		max = Math.max(cnt, max);
		cnt = 0;
		rain(r + 1);
	}

	// 침수중..
	public static void water(int w) {
		land = new int[N + 2][N + 2];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				// 수위만큼 빼준다.
				land[i][j] = arr[i][j] - w;
				if (land[i][j] < 0) {
					land[i][j] = 0;
				}
			}
		}
	}

	// 인접한 땅 검사하기
	public static void land(int x, int y) {
		land[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			if (land[x + dx[i][0]][y + dx[i][1]] != 0) {
				land(x + dx[i][0], y + dx[i][1]);
			}
		}
	}
}