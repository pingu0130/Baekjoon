import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static List<Integer> list;
	static int N, cnt;
	static int[][] dx = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		arr = new int[N + 2][N + 2];
		// 정답 저장 list
		list = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			String s = sc.nextLine();
			int idx = 0;
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = s.charAt(idx) - '0';
				idx++;
			}
		}
		apt(1, 1);

		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	// DFS
	// 아파트를 찾는 함수
	public static void apt(int x, int y) {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (arr[i][j] == 1) {
					cnt++;
					cntapt(i, j);
					list.add(cnt);
					cnt = 0;
				}
			}
		}
	}

	// 거점아파트 근처의 아파트를 찾는 함수
	public static void cntapt(int x, int y) {
		arr[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			if (arr[x + dx[i][0]][y + dx[i][1]] == 1) {
				cnt++;
				cntapt(x + dx[i][0], y + dx[i][1]);
			}
		}
	}
}