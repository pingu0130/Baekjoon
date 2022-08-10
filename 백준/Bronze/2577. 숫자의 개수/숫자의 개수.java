import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int mul = A * B * C;
		String s = Integer.toString(mul);
		char[] arr = s.toCharArray();
		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		int[] ans = new int[10];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 10; j++) {
				if (arr[i] == num[j]) {
					ans[j]++;
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(ans[i]);
		}
		sc.close();
	}
}
