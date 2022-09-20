import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr, ans;
	static boolean sel;

	public static void set(int n, int k) {
		if (sel)
			return;
		if (n == 7) {
			int sum = 0;
			for (int i : ans) {
				sum += i;
			}
			if (sum == 100) {
				sel = true;
				Arrays.sort(ans);
				for (int t : ans)
					System.out.println(t);
			}
			return;
		}
		for (int i = k; i < 9; i++) {
			ans[n] = arr[i];
			set(n + 1, i + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		ans = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		set(0, 0);

	}
}