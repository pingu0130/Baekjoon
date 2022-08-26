import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int H1 = sc.nextInt();
			int M1 = sc.nextInt();
			int H2 = sc.nextInt();
			int M2 = sc.nextInt();

			int ansH = 0;
			int ansM = 0;
			int PlusH = 0;
			if (M1 + M2 > 59) { // 60분넘으면
				PlusH = (M1 + M2) / 60; // 시간으로 넘기고
				ansM = (M1 + M2) % 60; // 남은게 분
			} else {
				ansM = M1 + M2;
			}
			if (H1 + H2 + PlusH > 12) { // 12시 넘으면
				ansH = (H1 + H2 + PlusH) - 12;
			} else {
				ansH = H1 + H2 + PlusH;
			}
			System.out.printf("#%d %d %d\n", tc, ansH, ansM);

		} // 테케
		sc.close();
	}
}
