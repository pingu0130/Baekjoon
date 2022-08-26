import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc < T; tc++) {
			String s = sc.nextLine();
			int K = s.charAt(s.length() - 1) - '0';
			if (K % 2 == 0) {
				System.out.println("even");
			} else {
				System.out.println("odd");
			}
		}
		sc.close();
	}
}
