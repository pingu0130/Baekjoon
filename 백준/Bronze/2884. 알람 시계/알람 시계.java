import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		int alarm = M - 45;
		if (H == 0) { // 0시이면서
			if (alarm < 0) { // H가 바뀌어야한다면
				H = 23; // 23시로바꿔주고
				M += 15; // M 계산
			} else {
				M -= 45;

			}
		} else {
			if (alarm < 0) { // H가 바뀌어야한다면
				H--; // -1 바꿔주고
				M += 15; // M 계산

			} else {
				M -= 45;

			}
		}
		System.out.printf("%d %d", H, M);
		sc.close();
	}
}
