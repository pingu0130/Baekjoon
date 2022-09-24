import java.util.Scanner;

public class Main {

	static int[][] arr;
	static boolean[] cheak;
	static int N, K, cnt;

	public static void vir(int n) {
		for (int i = 0; i < K; i++) {
			if (arr[i][0] == n) {
				if (!cheak[arr[i][1]]) {
					cnt++;
					cheak[arr[i][1]] = true;
					vir(arr[i][1]);
				}
			} else if (arr[i][1] == n) {
				if (!cheak[arr[i][0]]) {
					cnt++;
					cheak[arr[i][0]] = true;
					vir(arr[i][0]);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[K][2];
		cheak = new boolean[N + 1];
		cheak[1] = true;
		for (int i = 0; i < K; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		vir(1);
		System.out.println(cnt);
		sc.close();
	}
}