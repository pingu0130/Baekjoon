import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			boolean flag = true;
			HashSet<Integer> set = new HashSet<>();
			// 가로
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					set.add(arr[i][j]);
				}
				if (set.size() != 9) {
					flag = false;
				}
				set.clear();
			}
			// 세로
			for (int j = 0; j < 9; j++) {
				for (int i = 0; i < 9; i++) {
					set.add(arr[i][j]);
				}
				if (set.size() != 9) {
					flag = false;
				}
				set.clear();
			}

			// 네모
			int[] dc = { -1, 0, 1 };
			int[] dr = { -1, 0, 1 };
			for (int i = 1; i < 9; i += 3) { // 원점 이동
				for (int j = 1; j < 9; j += 3) {
					for (int x = 0; x < 3; x++) {
						for (int y = 0; y < 3; y++) {
							set.add(arr[i + dc[x]][j + dr[y]]);
						}
					}
					if (set.size() != 9) {
						flag = false;
					}
					set.clear();
				}
			}
			int ans = 0;
			if (flag) {
				ans = 1;
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}
