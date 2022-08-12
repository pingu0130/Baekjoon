import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		} // 키 다 더하기
		Loop1: for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((sum - (arr[i] + arr[j])) == 100) { // 총합-키가 100이면
					arr[i] = 0;
					arr[j] = 0;
					break Loop1;
				}
			}
		}
		Arrays.sort(arr);
		for (int q = 2; q < 9; q++) { // 앞에는 00이니까 2부터 출력
			System.out.println(arr[q]);
		}
		sc.close();
	}
}
