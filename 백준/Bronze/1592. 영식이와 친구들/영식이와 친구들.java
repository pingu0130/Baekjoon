import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 친구개수
		int M = sc.nextInt(); // 공횟수
		int L = sc.nextInt(); // 건너뛰기
		int[] arr = new int[N]; // 몇번 받았는지 검사하는 배열
		int idx = 0;
		int cnt = 0;
		arr[0] = 1; //맨처음놈은 항상 공을 한 번 가짐
		loop: while (true) {
			for (int i = 0; i < N; i++) {
				if (arr[i] == M) { //누군가 M번 받았으면 끝
					break loop;
				}
			}
			if (arr[idx] % 2 != 0) { // 홀수면
				if (idx + L >= N) { //배열을 넘어가면
					idx = ((idx + L) % N);
					arr[idx]++;
				} else {
					idx += L;
					arr[idx]++;
				}
			} else { // 짝수면
				if (idx - L < 0) {
					idx = N + (idx - L);
					arr[idx]++;
				} else {
					idx -= L;
					arr[idx]++;
				}
			}
			cnt++;
		} // while
		System.out.println(cnt);
		sc.close();
	}
}
