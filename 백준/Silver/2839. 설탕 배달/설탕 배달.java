import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		int cnt = 0;
		int min = 9999;
		int q = N / 5;
		for (int i = 0; i < q + 1; i++) {
			int r = N - (5 * i);
			if (r % 3 == 0) {
				cnt = (r / 3) + i;
				if (min > cnt) {
					min = cnt;
				}
				cnt = 0;
			}
		}
		ans = min;
		// 아예 못가져가는 경우
		if (min == 9999) {
			ans = -1;
		}
		System.out.println(ans);

		sc.close();
	}

}
