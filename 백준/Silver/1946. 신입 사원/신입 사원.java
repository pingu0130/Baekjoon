import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N + 1];
			for (int i = 0; i < N; i++) {
				int a = sc.nextInt();
				arr[a] = sc.nextInt();
			}
			int cnt = 0;
			int num = arr[1];
			for (int i = 2; i <= N; i++) {
				if (arr[i] > num) {
					cnt++;
				} else {
					num = arr[i];
				}
			}
			System.out.println(N - cnt);
		}

		sc.close();
	} // main
}