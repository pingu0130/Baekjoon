import java.util.Scanner;

public class Main {

	static int N, cnt;
	static int[] map;
    //0과 null을 구분하기위해 integer로 받기
	static Integer[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = sc.nextInt();
		}
		memo = new Integer[N + 1];
		memo[0] = map[0];
		memo[1] = map[1];
		if (N >= 2) {
			memo[2] = map[1] + map[2];
		}
		System.out.println(up(N));
		sc.close();
	}

	private static int up(int n) {
		if (memo[n] == null) {
			// 점프 후 걷기, 혹은 걷기 후 점프 두가지 방법이 있기 때문에
			memo[n] = Math.max(up(n - 2), up(n - 3) + map[n - 1]) + map[n];
		}
		return memo[n];
	}
}