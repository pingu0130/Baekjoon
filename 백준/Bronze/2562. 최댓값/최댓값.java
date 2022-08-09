import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) { // 배열에 받기
			arr[i] = sc.nextInt();
		}
		int max = 0;
		int no = 0;
		for (int i = 0; i < 9; i++) {
			if (arr[i] > max) {
				max = arr[i];
				no = i + 1;
			}
		}
		System.out.println(max);
		System.out.println(no);
		sc.close();
	}
}