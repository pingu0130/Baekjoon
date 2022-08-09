import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) { // 배열에 입력받기
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.printf("%d %d", arr[0], arr[N - 1]);
		sc.close();
	}
}
