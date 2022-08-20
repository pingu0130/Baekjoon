import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() - 1; // 맨 처음 1을 빼줌
		int i = 0;
		int cnt = 0;
		while (true) {
			N -= (6 * i);
			if (N > 0) {
				cnt++;
				i++;
			} else {
				cnt++;
				break;
			}
		} // while
		System.out.println(cnt);
		sc.close();
	}
}
