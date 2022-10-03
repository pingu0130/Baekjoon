import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class tree implements Comparable<tree> {
		int r, c, age;

		tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(tree o) {
			return Integer.compare(this.age, o.age);
		}
	}

	static int N, M, K;
	static int[][] bab, A;
	static PriorityQueue<tree> pq, alive, die;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		bab = new int[N][N];
		A = new int[N][N];
		// 원래 땅의 양분 5
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bab[i][j] = 5;
			}
		}
		// 로봇이 주는 양분
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		// 나무정보
		// 우선순위큐를 사용해 나이가 낮은 숫자부터 꺼낸다.
		pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			int treex = sc.nextInt() - 1;
			int treey = sc.nextInt() - 1;
			int age = sc.nextInt();
			pq.add(new tree(treex, treey, age));
		}
		alive = new PriorityQueue<>();
		die = new PriorityQueue<>();

		// K년 반복
		for (int i = 0; i < K; i++) {
			spring();
			sw();
			f();
		}
		System.out.println(pq.size());
		sc.close();
	}

	private static void spring() {
		// pq가 빌때까지 동작
		while (!pq.isEmpty()) {
			tree node = pq.poll();
			// 양분 먹을 수 있으면 먹고 나이올리기
			if (bab[node.r][node.c] - node.age >= 0) {
				bab[node.r][node.c] -= node.age;
				alive.add(new tree(node.r, node.c, node.age + 1));
			} else { // 못먹었으면 죽은나무큐에 보관
				die.add(new tree(node.r, node.c, node.age));
			}
		}
	}

	private static void sw() {
		// 여름에 죽은나무 양분되기
		while (!die.isEmpty()) {
			tree node = die.poll();
			bab[node.r][node.c] += (node.age / 2);
		}
		// 겨울에 로봇이 양분주기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bab[i][j] += A[i][j];
			}
		}
	}

	private static void f() {
		// 가을에 5의배수 나무 번식하기. 다시 pq로 돌아가
		int[][] dx = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		while (!alive.isEmpty()) {
			tree node = alive.poll();
			pq.add(new tree(node.r, node.c, node.age));
			if (node.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int x = node.r + dx[i][0];
					int y = node.c + dx[i][1];
					if (x >= 0 && y >= 0 && x < N && y < N) {
						pq.add(new tree(x, y, 1));
					}
				}
			}
		}

	}

}