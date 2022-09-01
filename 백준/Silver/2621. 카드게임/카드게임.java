import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] card = new int[4];
		int[] num = new int[10];
		for (int i = 0; i < 5; i++) {
			String s = sc.next();
			if (s.contains("R")) { // 배열에 카운팅
				card[0]++;
			} else if (s.contains("B")) {
				card[1]++;
			} else if (s.contains("Y")) {
				card[2]++;
			} else if (s.contains("G")) {
				card[3]++;
			}
			int n = sc.nextInt();
			num[n]++;
		}

		int ans = 0;
		loop: for (int i = 1; i < 10; i++) { // 숫자먼저 맞추기
			if (num[i] == 4) { // 포카드
				ans = 800 + i;
				break;
			} else if (num[i] == 3) { // 트리플 또는 풀하우스
				for (int k = 1; k < 10; k++) {
					if (num[k] == 2) { // 페어가 있으면
						ans = (i * 10) + k + 700; // 풀하우스
						break loop;
					}
				}
				// 페어없으면
				ans = i + 400; // 트리플
			} else if (num[i] == 2) {// 페어
				for (int k = i + 1; k < 10; k++) { // 내 뒤부터 페어검사
					if (num[k] == 2) { // 페어가 있으면
						ans = (k * 10) + i + 300; // 투페어
						break loop;
					}
				}
				// 원페어
				ans = i + 200;
			}
		}
		if (ans == 0) { // 위에서 답이 안나왔으면..
			loop: for (int i = 0; i < 4; i++) { // 카드배열을 돌면서
				if (card[i] == 5) { // 다섯장 색이 모두같을때
					for (int k = 1; k < 6; k++) {
						if (num[k] == num[k + 1] && num[k + 1] == num[k + 2] && num[k + 2] == num[k + 3]
								&& num[k + 3] == num[k + 4]) {// 다섯장이 숫자연속하면
							// 스트레이트 플러시
							ans = (k + 4) + 900;
							break loop;
						}
					}
					// 그냥 색만같아. 플러시구나
					int max = 0;
					for (int k = 1; k < 10; k++) {
						if (num[k] == 1) {
							max = Math.max(max, k);
						}
					}
					ans = max + 600;
				}
			}

		}
		if (ans == 0) { // 아직도 답이 없어? 스트레이트구나
			for (int k = 1; k < 6; k++) {
				if (num[k] == num[k + 1] && num[k + 1] == num[k + 2] && num[k + 2] == num[k + 3]
						&& num[k + 3] == num[k + 4]) {// 다섯장이 숫자연속하면
					ans = (k + 4) + 500;
					break;
				}
			}
		}
		if (ans == 0) {// 하이카드구나
			int max = 0;
			for (int k = 1; k < 10; k++) {
				if (num[k] == 1) {
					max = Math.max(max, k);
				}
			}
			ans = max + 100;

		}
		System.out.println(ans);
	}
}
