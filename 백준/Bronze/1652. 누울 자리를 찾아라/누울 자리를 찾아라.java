import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 방크기
		char[][] arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		int cntR = 0;
		int cntC = 0;
		int cnt = 0;
		// 가로
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == '.') { // X가 나오면 cnt값을 확인한다
					cnt++; // X가 나올때까지 cnt를 센다
				} else {
					if (cnt >= 2) { // 누울자리있으면
						cntC++;
					}
					cnt = 0;
				}
			}
			if (cnt >= 2) { // 한줄을 다 돌았는데 X가 안나옴. 근데 2칸이상있을때 눕자
				cntC++;
			}
			cnt = 0;
		}

		// 세로
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[j][i] == '.') { // X가 나오면 cnt값을 확인한다
					cnt++; // X가 나올때까지 cnt를 센다
				} else {
					if (cnt >= 2) { // 누울자리있으면
						cntR++;
					}
					cnt = 0;
				}
			}
			if (cnt >= 2) { // 한줄을 다 돌았는데 X가 안나옴. 근데 2칸이상있을때 눕자
				cntR++;
			}
			cnt = 0;
		}
		System.out.printf("%d %d", cntC, cntR);

	}
}