import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] p = new int[1001][1001]; // 배열만들고
		for (int i = 1; i < N + 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int garo = sc.nextInt();
			int sero = sc.nextInt();
			for (int j = x; j < x + garo; j++) { // x부터 가로까지
				for (int k = y; k < y + sero; k++) { // y부터세로까지
					p[j][k] = i; // i번째색종이면 i로칠해
				}
			}
		} // 색칠끝
		for (int t = 1; t < N + 1; t++) { // n번째색종이
			int cnt = 0;
			for (int i = 0; i < 1001; i++) { // 전체에서 찾아
				for (int j = 0; j < 1001; j++) {
					if (p[i][j] == t) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

		sc.close();
	}
}