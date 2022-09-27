import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int r, c, cnt;
		boolean wall;

		public Node(int r, int c, int cnt, boolean wall) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.wall = wall;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M;
		int[][] arr;
		boolean[][] cheakno;
		boolean[][] cheakyes;

		int[][] dx = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		cheakno = new boolean[N + 2][M + 2];
		cheakyes = new boolean[N + 2][M + 2];
		arr = new int[N + 2][M + 2];
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M + 2; j++) {
				arr[0][j] = 2;
				arr[N + 1][j] = 2;
				arr[i][0] = 2;
				arr[i][M + 1] = 2;
			}
		}
		for (int i = 1; i < N + 1; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < M; j++) {
				arr[i][j + 1] = s.charAt(j) - '0';
			}
		}
		// BFS
		int ans = -1;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 1, 1, false));
		cheakno[1][1] = true;
		cheakyes[1][1] = true;
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			// 끝까지 왔으니까 끝
			if (n.r == N && n.c == M) {
				ans = n.cnt;
				break;
			}
			// 사방탐색으로 길찾기
			for (int i = 0; i < 4; i++) {
				if (arr[n.r + dx[i][0]][n.c + dx[i][1]] == 0) {
					// 가본적 없으면서 벽 뿌숨
					if (!cheakyes[n.r + dx[i][0]][n.c + dx[i][1]] && n.wall) {
						cheakyes[n.r + dx[i][0]][n.c + dx[i][1]] = true;
						// n.wall로 내 상태를 계속 유지할 수 있다.
						queue.add(new Node(n.r + dx[i][0], n.c + dx[i][1], n.cnt + 1, n.wall));
					}
				}
				// 벽 부순적이 없으면
				if (!n.wall) {
					// 안가본 1이면 벽부수면서
					if (arr[n.r + dx[i][0]][n.c + dx[i][1]] == 1 && !cheakyes[n.r + dx[i][0]][n.c + dx[i][1]]) {
						cheakyes[n.r + dx[i][0]][n.c + dx[i][1]] = true;
						// 벽을 부셨으면 true로 바꿔준다.
						queue.add(new Node(n.r + dx[i][0], n.c + dx[i][1], n.cnt + 1, true));
					} else {
						// 가본적 없으면서 벽 안부순자식
						if (arr[n.r + dx[i][0]][n.c + dx[i][1]] == 0 && !cheakno[n.r + dx[i][0]][n.c + dx[i][1]]) {
							cheakno[n.r + dx[i][0]][n.c + dx[i][1]] = true;
							// n.wall로 내 상태를 계속 유지할 수 있다.
							queue.add(new Node(n.r + dx[i][0], n.c + dx[i][1], n.cnt + 1, n.wall));
						}
					}
				}
			}
		}
		System.out.println(ans);

		sc.close();
	}
}