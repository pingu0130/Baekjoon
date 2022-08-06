import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // 시
		int B = sc.nextInt(); // 분
		int C = sc.nextInt(); // 요리시간
		int hour = C / 60; // 혹시 몇시간이니?
		int min = C % 60; // 몇분이니
		A += hour; // 끝나는시간
		B += min;
		if (B >= 60) { // 60분이넘으면서
			if (A >= 23) { // 23시면
				A++; // A하나늘리고 (24시)
				A -= 24; // 0시부터 다시세
				B -= 60; // 0분부터 다시세
			} else {
				A++; // A늘리고
				B -= 60; // 0분부터 다시세
			}
		} else {
			if (A >= 24) { // 24시면(분에서 안올라오니까)
				A -= 24; //0시부터
			}

		}
		System.out.printf("%d %d", A, B);

		sc.close();
	}
}
