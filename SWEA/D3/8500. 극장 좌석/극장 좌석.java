import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int sit = 0;
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			Collections.sort(list);
			for (int i = 0; i < N; i++) {
				sit += list.get(i) + 1;
			}
			sit += list.get(N - 1); // 맨 마지막에 오른쪽 자리
			System.out.printf("#%d %d\n", tc, sit);
		} // 테케
		sc.close();
	}
}