import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt;
	static int[][] arr;
	static String s;

	public static int pipe(int x, int y) {
		if (x == N && y == N) {
			cnt++;
			return cnt;
		}
		// 이동
		switch (s) {
		case "garo":
			// 가로로 된 경우 가로/대각선 갈 수 있음
			// 가로로 가기
			if (arr[x][y + 1] == 0) {
				s = "garo";
				pipe(x, y + 1);
			}
			// 대각선으로 가기
			if (arr[x + 1][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x][y + 1] == 0) {
				s = "dea";
				pipe(x + 1, y + 1);
			}
			break;
		case "rero":
			// 세로, 대각선
			if (arr[x + 1][y] == 0) {
				s = "rero";
				pipe(x + 1, y);
			}
			if (arr[x + 1][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x][y + 1] == 0) {
				s = "dea";
				pipe(x + 1, y + 1);
			}
			break;
		case "dea":
			if (arr[x][y + 1] == 0) {
				s = "garo";
				pipe(x, y + 1);
			}
			if (arr[x + 1][y] == 0) {
				s = "rero";
				pipe(x + 1, y);
			}
			if (arr[x + 1][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x][y + 1] == 0) {
				s = "dea";
				pipe(x + 1, y + 1);
			}
			break;
		}
		return 0;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 2][N + 2];
		// 테두리 1로 하기
		for (int j = 0; j < N + 2; j++) {
			arr[0][j] = 1;
			arr[N + 1][j] = 1;
		}
		for (int i = 0; i < N + 2; i++) {
			arr[i][0] = 1;
			arr[i][N + 1] = 1;
		}
		// 배열에 입력
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 맨 처음은 가로로 시작
		s = "garo";
		pipe(1, 2);
		System.out.println(cnt);
	}
}