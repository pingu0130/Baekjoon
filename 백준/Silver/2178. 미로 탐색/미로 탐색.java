import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int r, c, cnt;
		
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M;
		int[][] arr;
		boolean[][] cheak;
		int[][] dx = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		cheak = new boolean[N + 2][M + 2];
		arr = new int[N + 2][M + 2];
		for (int i = 1; i < N + 1; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < M; j++) {
				arr[i][j + 1] = s.charAt(j) - '0';
			}
		}
		// BFS
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 1, 1));
		cheak[1][1] = true;
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			// 끝까지 왔으니까 끝
			if (n.r == N && n.c == M) {
				System.out.println(n.cnt);
				break;
			}
			boolean flag = false;
			// 사방탐색으로 길찾기
			for (int i = 0; i < 4; i++) {
				// 옆칸이 1이면 이동하기
				if (!cheak[n.r + dx[i][0]][n.c + dx[i][1]] && arr[n.r + dx[i][0]][n.c + dx[i][1]] == 1) {
					cheak[n.r + dx[i][0]][n.c + dx[i][1]] = true;
					flag = true;
					queue.add(new Node(n.r + dx[i][0], n.c + dx[i][1], n.cnt + 1));
				}
			}
		}
		System.out.println();

		sc.close();
	}
}