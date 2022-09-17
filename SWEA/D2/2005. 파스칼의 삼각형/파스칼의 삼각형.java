import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) { // 맨 앞줄은 다 1로 채워준다.
				arr[i][0] = 1;
			}
			for (int a = 1; a < N; a++) { // 윗줄의 전칸과 내칸을 더하면 내 값
				for (int b = 1; b < a + 1; b++) {
					arr[a][b] = arr[a - 1][b - 1] + arr[a - 1][b];
				}
			}
			// 출력
			System.out.println("#" + tc);
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < x + 1; y++) {
					System.out.print(arr[x][y]+" ");
				}
				System.out.println();
			}
		}
	}
}
