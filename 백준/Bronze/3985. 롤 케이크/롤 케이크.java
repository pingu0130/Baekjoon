import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); // 케이크길이
		int N = sc.nextInt(); // 방청객수
		int[] arr = new int[L]; // 롤케이크
		int maxw = 0; // 가장많이쓴놈
		int max = 0;
		for (int i = 1; i < N + 1; i++) {
			int p = sc.nextInt() - 1; //배열은 0부터시작이고 얘네는 1부터세니까 -1해서 배열에 맞춰준다
			int k = sc.nextInt() - 1;
			int q = k - p + 1;// 몇칸?
			if (max < q) {
				max = q;
				maxw = i; // 손님번호저장
			}
			for (int j = p; j <= k; j++) {
				if (arr[j] == 0) { // 케이크가 비었으면
					arr[j] = i; // i번 손님은 i로 칠해
				}
			}
		} // 색칠끝
		int maxc = 0; // 가장많이받은놈
		max = 0;
		for (int i = 1; i < N + 1; i++) { // 제일많이받은놈 검사
			int cnt = 0;
			for (int j = 0; j < L; j++) {
				if (arr[j] == i) { // i번 손님이 가진 i케이크면
					cnt++;
				}
			}
			if (max < cnt) {
				max = cnt;
				maxc = i;
			}
		}
		System.out.println(maxw);
		System.out.println(maxc);
		sc.close();
	}
}
