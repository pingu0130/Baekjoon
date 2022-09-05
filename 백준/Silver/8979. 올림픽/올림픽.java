import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] n = new int[N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			n[i][0] = Integer.parseInt(st.nextToken());
			n[i][1] = Integer.parseInt(st.nextToken());
			n[i][2] = Integer.parseInt(st.nextToken());
			n[i][3] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(n, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1]) {
					return o2[1] - o1[1];
				} else {
					if (o1[2] != o2[2])
						return o2[2] - o1[2];
					else
						return o2[3] - o1[3];
				}
			}
		});
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (n[i][0] == K) {
				idx = i;
			}
		}
		int ans = 1;
		for (int i = 0; i < N; i++) {
			if (n[idx][1] < n[i][1]) { // 금메달이 더 많으면 등수 내려주기
				ans++;
			} else if (n[idx][1] == n[i][1] && n[idx][2] < n[i][2]) { // 금 같고 은이 많을때 내려주기
				ans++;
			} else if (n[idx][1] == n[i][1] && n[idx][2] == n[i][2] && n[idx][3] < n[i][3]) { // 금은 같고 동이 많으면 내려주기
				ans++;
			}
		}
		System.out.println(ans);
	}
}
