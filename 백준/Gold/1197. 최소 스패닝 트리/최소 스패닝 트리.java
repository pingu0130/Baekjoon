import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] node = new int[E][3];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			// 시작, 도착, 간선값
			node[i][0] = Integer.parseInt(st.nextToken());
			node[i][1] = Integer.parseInt(st.nextToken());
			node[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(node, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		double ans = 0;
		int pick = 0;
		for (int i = 0; i < E; i++) {
			// 간선을 돌면서 최소값순서대로 더한다.
			int n = findSet(node[i][0]);
			int c = findSet(node[i][1]);
			if (n != c) {
				union(n, c);
				ans += node[i][2];
				pick++;
			}
			if (pick == V) {
				break;
			}
		}
		System.out.println((int) ans);

	}

	private static int findSet(int x) {
		if (p[x] != x)
			return p[x]=findSet(p[x]);
		return p[x];
	}

	private static void union(int n, int c) {
		p[findSet(n)] = findSet(c);
	}

}