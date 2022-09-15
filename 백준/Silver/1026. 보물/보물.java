import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// A를 리스트에 받아서 sort
		List<Integer> Alist = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			Alist.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(Alist);
		// B를 배열에 담기
		st = new StringTokenizer(br.readLine());
		int[] arrB = new int[N];
		for (int i = 0; i < N; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrB);
		// 작은A를 큰 B에 매칭
		int ans = 0;
		for (int b = N - 1; b >= 0; b--) {
			ans += Alist.get(0) * arrB[b]; // 계산 후
			Alist.remove(0); // A를 지워 항상 idx0을 유지해준다.
		}
		System.out.println(ans);
	}
}