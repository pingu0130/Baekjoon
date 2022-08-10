import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for (int i = 0; i < C; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			double sum = 0;
			for (int j = 0; j < N; j++) { // 배열에 넣기
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			double avg = sum / N;
			double cnt = 0;
			for (int j = 0; j < N; j++) { // 평균보다 잘본놈
				if (arr[j] > avg) {
					cnt++;
				}
			}
			double rate = cnt / N * 100;
			System.out.printf("%.3f%%\n", rate);
			rate = 0;
		}
		sc.close();
	}
}
