import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int ans = 0;
		int m = 0;
		for (int i = 0; i < 10; i++) {
			m = sc.nextInt();
			sum += m;
			if (sum > 100) { // 100이면 출력
				break;
			}
		}
		int a = Math.abs(100 - sum); // 지금 값과 그전 값의 100에대한 차를 구해
		int b = Math.abs(100 - (sum - m));
		if (a > b) { // 지금이 더 차이나면
			ans = sum - m; // 예전거출력
		} else if (a == b) {
			ans = sum;
		} else {
			ans = sum;
		}
		System.out.println(ans);

		sc.close();
	}
}
