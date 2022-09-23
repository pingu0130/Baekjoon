import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int h, w, ans;
	static int[][] dx = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void landing(int x, int y) {
		// 땅이면 0으로 바꾸기위한 함수
		arr[x][y] = 0;
		for (int i = 0; i < 8; i++) {
			if (arr[x + dx[i][0]][y + dx[i][1]] == 1) {
				// 인접한 1을 모두 0으로 바꿔준다.
				landing(x + dx[i][0], y + dx[i][1]);
			}
		}
	}

	public static void island(int x, int y) {
		// 땅이면 건너갈 수 있는지 검사
		if (x >= h + 1 || y >= w + 1) {
			return;
		}
		for (int i = 0; i < h + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				if (arr[i][j] == 1) {
					ans++;
					// 0바꾸기
					landing(i, j);
				}
			}
		}
		if (y == w) {
			island(x + 1, 1);
		} else {
			island(x, y + 1);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			arr = new int[h + 2][w + 2];
			for (int i = 1; i < h + 1; i++) {
				for (int j = 1; j < w + 1; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			island(1, 1);
			System.out.println(ans);
			ans = 0;
		}
		sc.close();
	}
}