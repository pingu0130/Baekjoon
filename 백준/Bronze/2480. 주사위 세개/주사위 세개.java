import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		TreeSet<Integer> num = new TreeSet<>();
		num.add(a);
		num.add(b);
		num.add(c); // TreeSet에 넣기
		int ans = 0;
		if (num.size() == 1) { // 길이가 1이면(셋다 같으면)
			ans = 10000 + (a * 1000);
		} else if (num.size() == 2) { // 둘만같으면
			if (a == b) {
				ans = 1000 + a * 100;
			} else if (a == c) {
				ans = 1000 + a * 100;
			} else {
				ans = 1000 + b * 100;
			}
		} else if (num.size() == 3) { // 셋다 다르면
			ans = num.last() * 100; // 최댓값출력해서 연산
		} else {
		}

		System.out.println(ans);
		sc.close();
	}
}