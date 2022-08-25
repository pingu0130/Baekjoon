import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			for (int i = 0; i < N; i++) { // 오목판만들기
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			int cnt = 0;
			boolean flag = false;
			loop: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 'o') {
						for (int k = 0; k < 5 && j + k < N; k++) { // 오른쪽
							if (arr[i][j + k] == 'o') {
								cnt++;
							}
							if (cnt == 5) {
								flag = true;
								break loop;
							}
						}
						cnt = 0;
						for (int k = 0; k < 5 && i + k < N; k++) { // 아래
							if (arr[i + k][j] == 'o') {
								cnt++;
							}
							if (cnt == 5) {
								flag = true;
								break loop;
							}
						}
						cnt = 0;
						for (int k = 0; k < 5 && i + k < N && j + k < N; k++) { // 오른쪽대각선
							if (arr[i + k][j + k] == 'o') {
								cnt++;
							}
							if (cnt == 5) {
								flag = true;
								break loop;
							}
						}
						cnt = 0;
						for (int k = 0; k < 5 && i + k < N && j - k >= 0; k++) { // 왼쪽대각선
							if (arr[i + k][j - k] == 'o') {
								cnt++;
							}
							if (cnt == 5) {
								flag = true;
								break loop;
							}
						}
						cnt = 0;
					}
				}
			}
			String ans = "YES";
			if (flag == false) {
				ans = "NO";
			}
			System.out.printf("#%d %s\n", tc, ans);
		}
	}
}
