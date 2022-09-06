import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		// x,y는 유일하게 존재하고 보장된다
		int x, y;
		if (d * b - a * e != 0) { // by zero에러를 잡기 위해 0인지 검사한다.
			y = (c * d - f * a) / (d * b - a * e);
		} else {
			y = 0;
		}
		if (e * a - b * d != 0) {
			x = (e * c - f * b) / (e * a - b * d);
		} else {
			x = 0;
		}
		System.out.printf("%d %d", x, y);
		sc.close();
	}
}