import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] time = new int[6];
		int ans = 0;
		for (int x = 0; x <= (N * 3600 + 59 * 60 + 59); x++) {
			if (time[5] == 10) { // 10진수
				time[5] = 0;
				time[4]++;
			}
			if (time[4] == 6) { // 6진수
				time[4] = 0;
				time[3]++;
			}
			if (time[3] == 10) {
				time[3] = 0;
				time[2]++;
			}
			if (time[2] == 6) {
				time[2] = 0;
				time[1]++;
			}
			if (time[1] == 10) {
				time[1] = 0;
				time[0]++;
			}
			for (int i = 5; i >= 0; i--) { // 같은글자 있는지 검사
				if (time[i] == K) {
					ans++;
					break;
				}
			}
			time[5]++; // 시간이 흘러요
		}
		System.out.println(ans);

	}
}