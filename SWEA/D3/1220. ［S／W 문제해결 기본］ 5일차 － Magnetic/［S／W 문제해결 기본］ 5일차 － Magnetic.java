import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc < 11; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100]; // 앞뒤공백처리
			for (int i = 0; i < 100; i++) { // 배열채우기
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0; // 교착
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) { // 배열을 돌면서 검사
					if (arr[i][j] == 1) { // N극이면 밑으로 검사
						for (int x = i; x < 100; x++) {
							if (arr[x][j] == 1) { // 친구 만나면 합체
								arr[x][j] = 0;
							} else if (arr[x][j] == 2) { // 상대를 만나면 교착
								arr[x][j] = 0; // 상쇄시키기
								cnt++;
								break; // 더 밑으로 찾지않고 끝
							} // 상대를 못만나면 떨어짐
						}
						arr[i][j] = 0;
					} else if (arr[i][j] == 2) {
						for (int x = i; x >= 0; x--) { // S극이면 위로 검사
							if (arr[x][j] == 2) {
								arr[x][j] = 0;
							} else if (arr[x][j] == 1) {
								arr[x][j] = 0;
								cnt++;
								break;
							}
						}
						arr[i][j] = 0;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		} // 테케
	}
}
