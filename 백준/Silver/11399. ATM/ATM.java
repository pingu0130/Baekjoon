import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr); // 정렬해서
		int sum = 0;
		int cnt = N;
		for (int i = 0; i < N; i++) {
			sum += arr[i] * cnt; // 작은수는 N번씩 더해짐
			cnt--;
		}
		System.out.println(sum);
		sc.close();
	}

}