import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i < T + 1; i++) { // 테케
			String s = sc.next();
			char[] arr = s.toCharArray(); // ox한칸씩 넣기
			int cnt = 0;
			int score = 0;
			for (int j = 0; j < arr.length; j++) { // 배열을 돌면서
				if (arr[j] == 'O') { // O가 나오면
					cnt++; // 하나세고
					score += cnt; // 점수에 더하기
				} else {
					cnt = 0; // 연속이 끊기면 cnt초기화
				}
			}
			System.out.println(score);

		}
	}
}
