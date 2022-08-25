import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt(); // 학생수
			int K = sc.nextInt() - 1; // 학생번호
			double[] arr = new double[N];
			for (int i = 0; i < N; i++) {
				int mid = sc.nextInt();
				int fin = sc.nextInt();
				int re = sc.nextInt();
				double score = (mid * 0.35) + (fin * 0.45) + (re * 0.2);
				arr[i] = score;
			}
			double[] Sortarr = Arrays.copyOf(arr, N);
			Arrays.sort(Sortarr); // 오름차순점수별로 나열
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (Sortarr[i] == arr[K]) {
					idx = i;
					break;
				}
			}
			String[] grade = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };
			N /= 10; // 한 등급에 몇명인지 계산
			idx /= N; // 몫이 등급
			System.out.println(grade[idx]);
		}
	}
}
