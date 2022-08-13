import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String sit = sc.next();
		char[] arr = sit.toCharArray();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] == 'L') {
				cnt++;
			}
		}
		int ans = 0;
		if (cnt > 0) { // L이있다는거
			ans = N - (cnt / 2) + 1;
		} else {
			ans = N;
		}
		System.out.println(ans);
		sc.close();
	}
}