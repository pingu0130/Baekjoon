import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int M, N, cnt, ans;
	static int[][] dx = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		sc.nextLine();
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		cnt = 0;
		ans = 0;
		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 익은토마토 다 찾기
				if (arr[i][j] == 1) {
					// 2=익었따
					arr[i][j] = 2;
					queue.add(new Node(i, j));
				}
			}
		}
		// queue에 모든 1토마토 들어있음
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size != 0) {
				Node n = queue.poll();
				for (int x = 0; x < 4; x++) {
					if (n.r + dx[x][0] >= 0 && n.r + dx[x][0] < N && n.c + dx[x][1] >= 0 && n.c + dx[x][1] < M)
						if (arr[n.r + dx[x][0]][n.c + dx[x][1]] == 0) {
							arr[n.r + dx[x][0]][n.c + dx[x][1]] = 2;
							queue.add(new Node(n.r + dx[x][0], n.c + dx[x][1]));
						}
				}
				// while문을 한바퀴 돌면 하루..
				size--;
			}
			cnt++;
		}
		// 다익었는지 검사
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					flag = false;
					break;
				}
			}
		}
		if (!flag) {
			// 안익은 ㅌㅁㅌ가 있으면
			ans = -1;
		} else if (cnt == N * M) {
			// 모든 ㅌㅁㅌ가 다 익어있었으면
			ans = 0;
		} else {
			ans = cnt - 1;
		}

		System.out.println(ans);
		sc.close();

	}
}