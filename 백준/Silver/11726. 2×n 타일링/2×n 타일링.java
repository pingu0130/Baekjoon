import java.util.Scanner;

public class Main {
	static int[] arr;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[1001];
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i < n + 1; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
		}
		System.out.println(arr[n]);
		sc.close();
	}
}