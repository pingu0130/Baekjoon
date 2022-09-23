import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static List<Integer> list;
	static int N;
	static int[][] dx = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	// 클래스를 선언해 Node에서 두개의 인자를 받을 수 있게 함
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		arr = new int[N + 2][N + 2];
		// 정답 저장 list
		list = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			String s = sc.nextLine();
			int idx = 0;
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = s.charAt(idx) - '0';
				idx++;
			}
		}
		// BFS 아파트 찾기
		Queue<Node> queue = new LinkedList<>();
		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				// 아파트 발견하면 큐에 저장하고 해당 아파트 근처를 다시 수색
				if (arr[i][j] == 1) {
					cnt++;
					queue.add(new Node(i, j));
					arr[i][j] = 0;
					while (!queue.isEmpty()) {
						Node n = queue.poll();
						// 4방탐색해서 아파트있으면 cnt
						for (int dr = 0; dr < 4; dr++) {
							if (arr[n.r + dx[dr][0]][n.c + dx[dr][1]] == 1) {
								arr[n.r + dx[dr][0]][n.c + dx[dr][1]] = 0;

								cnt++;
								queue.add(new Node(n.r + dx[dr][0], n.c + dx[dr][1]));
							}

						}
					} // while
					list.add(cnt);
					cnt = 0;
				}
			}
		} // for
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}