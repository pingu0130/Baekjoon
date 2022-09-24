import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;
		int[][] arr = new int[K][2];
		boolean[] cheak = new boolean[N + 1];
		cheak[1] = true;
		for (int i = 0; i < K; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		// BFS
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			if (arr[i][0] == 1) {
				queue.add(arr[i][1]);
				cnt++;
				cheak[arr[i][1]] = true;
			}
			if (arr[i][1] == 1) {
				queue.add(arr[i][0]);
				cnt++;
				cheak[arr[i][0]] = true;
			}
		}
		int x = 0;
		while (!queue.isEmpty()) {
			x = queue.poll();
			for (int i = 0; i < K; i++) {
				if (arr[i][0] == x && !cheak[arr[i][1]]) {
					queue.add(arr[i][1]);
					cnt++;
					cheak[arr[i][1]] = true;
				}
				if (arr[i][1] == x && !cheak[arr[i][0]]) {
					queue.add(arr[i][0]);
					cnt++;
					cheak[arr[i][0]] = true;
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}