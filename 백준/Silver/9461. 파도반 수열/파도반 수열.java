import java.util.Scanner;

public class Main {
	static int N;
	static double[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new double[101];
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 1;
			for (int i = 4; i <= N; i++) {
				arr[i] = arr[i - 3] + arr[i - 2];
			}
			System.out.println(Math.round(arr[N]));
		}
		sc.close();
	}
}