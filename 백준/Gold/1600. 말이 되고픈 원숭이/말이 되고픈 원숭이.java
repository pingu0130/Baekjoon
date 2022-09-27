import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int r, c, cnt, j;

		public Node(int r, int c, int cnt, int j) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M, K;
		int[][] arr;
		boolean[][][] cheak;
		int[][] dx = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int[][] jump = { { -1, 2 }, { -2, -1 }, { -2, 1 }, { -1, -2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } };
		K = sc.nextInt();
		M = sc.nextInt();
		N = sc.nextInt();
		sc.nextLine();
		cheak = new boolean[N][M][K + 1];
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// BFS
		int ans = -1;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 0, 0));
		cheak[0][0][0] = true;
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			if (n.r == N - 1 && n.c == M - 1) {
				ans = n.cnt;
				break;
			}
			// 점프불가
			if (n.j >= K) {
				for (int i = 0; i < 4; i++) {
					if (n.r + dx[i][0] >= 0 && n.r + dx[i][0] < N && n.c + dx[i][1] >= 0 && n.c + dx[i][1] < M)
						if (arr[n.r + dx[i][0]][n.c + dx[i][1]] == 0 && !cheak[n.r + dx[i][0]][n.c + dx[i][1]][n.j]) {
							cheak[n.r + dx[i][0]][n.c + dx[i][1]][n.j] = true;
							queue.add(new Node(n.r + dx[i][0], n.c + dx[i][1], n.cnt + 1, n.j));
						}
				}
			} else {
				// k번 아래면 점프가능
				// 점프하거나, 안하거나
				for (int i = 0; i < 8; i++) {
					if (n.r + jump[i][0] >= 0 && n.r + jump[i][0] < N && n.c + jump[i][1] >= 0 && n.c + jump[i][1] < M)
						if (arr[n.r + jump[i][0]][n.c + jump[i][1]] == 0
								&& !cheak[n.r + jump[i][0]][n.c + jump[i][1]][n.j + 1]) {
							cheak[n.r + jump[i][0]][n.c + jump[i][1]][n.j + 1] = true;
							queue.add(new Node(n.r + jump[i][0], n.c + jump[i][1], n.cnt + 1, n.j + 1));
						}
				}
				for (int i = 0; i < 4; i++) {
					if (n.r + dx[i][0] >= 0 && n.r + dx[i][0] < N && n.c + dx[i][1] >= 0 && n.c + dx[i][1] < M)
						if (arr[n.r + dx[i][0]][n.c + dx[i][1]] == 0 && !cheak[n.r + dx[i][0]][n.c + dx[i][1]][n.j]) {
							cheak[n.r + dx[i][0]][n.c + dx[i][1]][n.j] = true;
							queue.add(new Node(n.r + dx[i][0], n.c + dx[i][1], n.cnt + 1, n.j));
						}
				}
			}
		}
		System.out.println(ans);

		sc.close();
	}
}