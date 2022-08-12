import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[102][102];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int a = x + 1; a < x + 11; a++) { // 좌표를 기준으로 색칠하기
				for (int b = y + 1; b < y + 11; b++) {
					arr[a][b] = 1;
				}
			}
		}
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int cnt = 0;
		for (int a = 1; a < 101; a++) {
			for (int b = 1; b < 101; b++) {
				if (arr[a][b] == 1) { // 색칠칸이면 탐색시작
					for (int k = 0; k < dr.length; k++) { // 사방탐색을 해서
						int q = a + dr[k];
						int w = b + dc[k];
						if (arr[q][w] == 0) { // 주변이 0이니?
							cnt++;
						} else {
							continue;
						}
					} // 탐색
				}
			}
		}
		System.out.println(cnt);
	}
}
