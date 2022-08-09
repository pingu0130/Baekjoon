import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num, sum = 0;
		int x, y;
		int a, b;
		int cnt = 0;
		a = N / 10; // 십의자리
		b = N % 10; // 일의자리
		do {
			sum = a + b;
			x = sum / 10;
			y = sum % 10;
			num = (10 * b) + y;
			a = num / 10;
			b = num % 10;
			cnt++;
		} while (num != N);
		System.out.println(cnt);
		sc.close();
	}
}
