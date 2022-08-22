import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String ans = null;
		for (int tc = 1; tc < T + 1; tc++) {
			int N = sc.nextInt(); // 손님 수
			int M = sc.nextInt(); // 제조시간
			int K = sc.nextInt(); // 개수
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt(); // 언제도착?
			}
			Arrays.sort(arr);
			int b = 0; // 붕어빵개수
			if (arr[0] < M) { // 오픈안했어요
				ans = "Impossible";
			} else {
				b = (arr[0] / M) * K; // 만들고
				b--; // 하나먹어
				ans = "Possible";
				if (N > 1) { // for문은 손님이 2명이상일때 돌아야해
					int num = 2;
					for (int i = 1; i < N; i++) { // 다음손님부터
						// M의 배수마다 붕어빵 만들어야해
						if (arr[i] >= M * num) {
							b += K; //만들기
							b--;
							num++;
							ans = "Possible";
						} else { // 붕어빵 못만들었는데
							if (b == 0) { // 없어용
								ans = "Impossible";
								break;
							} else {
								b--; // 있던거 줄게
								ans = "Possible";
							}
						}

					}
				}
			}

			System.out.printf("#%d %s\n", tc, ans);
		} // 테케
	}
}
