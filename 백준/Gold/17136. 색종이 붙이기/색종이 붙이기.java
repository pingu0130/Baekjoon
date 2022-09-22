import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int[] paper;
	static int ans = 30;

	public static boolean isok(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10) {
					return false;
				}
				if (arr[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	// 종이붙이기
	public static void att(int x, int y, int size, int state) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				arr[i][j] = state;
			}
		}
	}

	public static void DFS(int x, int y, int cnt) {
		if (x >= 9 && y > 9) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (ans <= cnt) {
			return;
		}
		if (y > 9) {
			DFS(x + 1, 0, cnt);
			return;
		}
		if (arr[x][y] == 1) {
			for (int i = 5; i >= 1; i--) {
				// isok 붙일 수 있으면 실행
				if (paper[i] > 0 && isok(x, y, i)) {
					// 상태 0으로 바꾼다: 붙이기
					att(x, y, i, 0);
					paper[i]--;
					DFS(x, y + 1, cnt + 1); // 옆칸으로 가기
					// 상태 1로 바꾼다: 떼기
					att(x, y, i, 1);
					paper[i]++;
				}
			}
		} else {
			DFS(x, y + 1, cnt); // 못붙여도 옆칸으로 가야해
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		paper = new int[6];
		for (int i = 1; i < 6; i++) {
			paper[i] = 5;
		}
		DFS(0, 0, 0);
		if (ans == 30) {
			ans = -1;
		}
		System.out.println(ans);
		sc.close();
	}
}
