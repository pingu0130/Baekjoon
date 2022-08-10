import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) { // 점수 배열에 받기
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr); //정렬해서
		double max = arr[N - 1]; //최댓값찾고
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i]; //모든 수 더해서
		}
		double ans = (100 / max * sum) / N; //계산식
		System.out.println(ans);

	}
}