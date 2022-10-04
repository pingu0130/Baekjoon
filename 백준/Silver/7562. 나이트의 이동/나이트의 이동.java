import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class Node {
		int r, c, cnt;

		Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int I = sc.nextInt();
			boolean[][] cheak = new boolean[I][I];
			int[][] night = { { -2, -1 }, { -1, -2 }, { -2, 1 }, { -1, 2 }, { 2, 1 }, { 1, 2 }, { 1, -2 }, { 2, -1 } };
			int startx = sc.nextInt();
			int starty = sc.nextInt();
			int endx = sc.nextInt();
			int endy = sc.nextInt();
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(startx, starty, 0));
			int min = Integer.MAX_VALUE;
			while (!q.isEmpty()) {
				Node n = q.poll();
				// 목적지에 도착했으면 최소값이니? 물어봄
				if (n.r == endx && n.c == endy) {
					min = Math.min(min, n.cnt);
				}
				for (int i = 0; i < 8; i++) {
					int x = n.r + night[i][0];
					int y = n.c + night[i][1];
					if (x >= 0 && y >= 0 && x < I && y < I && !cheak[x][y]) {
						cheak[x][y] = true; // 방문배열 체크
						// 말이 움직이면 cnt센다.
						q.add(new Node(x, y, n.cnt + 1));
					}
				}
			}
			System.out.println(min);
		}
		sc.close();
	}
}