import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 학생수
		int K = sc.nextInt(); // 최대인원수
		int[][] arr = new int[6][2];
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt(); // 성별
			int Y = sc.nextInt(); // 학년
			if (S == 0) {
				arr[Y - 1][0]++;
			} else {
				arr[Y - 1][1]++;
			}

		}
		int room = 0; // 방개수
		for (int i = 0; i < 6; i++) { // 배열을 탐색해서
			for (int j = 0; j < 2; j++) {
				room += arr[i][j] / K; // 명수만큼 방 구하고
				if (arr[i][j] % K != 0) { // 나머지인원이 있으면 방 하나 더필요해
					room += 1;
				}

			}
		}
		System.out.println(room);
		sc.close();
	}
}
