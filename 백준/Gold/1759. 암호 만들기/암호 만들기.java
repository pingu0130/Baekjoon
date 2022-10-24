import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * 비밀번호 조합을 만든 다음에 자음모음 조건을 체크한다.
	 */
	static int L, C, cnt;
	static String[] arr, ans;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		arr = new String[C];
		check = new boolean[C];
		for (int i = 0; i < C; i++) {
			arr[i] = sc.next();
		}
		Arrays.sort(arr);
		ans = new String[L];
		com(0, 0);
		sc.close();
	}

	private static void com(int n, int m) {
		// 조합 다 모았다
		if (m == L) {
			// 배열에 모음1 자음2가 있는지 체크
			int mo = 0;
			int ja = 0;
			for (int i = 0; i < L; i++) {
				if (ans[i].equals("a") || ans[i].equals("e") || ans[i].equals("i") || ans[i].equals("o")
						|| ans[i].equals("u")) {
					mo++;
				} else {
					ja++;
				}
			}

			if (mo >= 1 && ja >= 2) {
				Arrays.sort(ans);
				for (int i = 0; i < L; i++) {
					System.out.print(ans[i]);
				}
				System.out.println();
			}
			return;
		}
		if (n == C) {
			return;
		}
		ans[m] = arr[n];
		check[n] = true;
		com(n + 1, m + 1);
		check[n] = false;
		com(n + 1, m);
	}
}