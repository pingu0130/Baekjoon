import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		// 다 대문자로 바꾸기
		s = s.toUpperCase();
		int max = 0;
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			// 카운트배열에 담아주기
			arr[s.charAt(i) - 65]++;
		}
		int idx = 0;
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if (max < arr[i]) {
				max = arr[i];
				idx = i;
				cnt = 0;
			} else if (max == arr[i]) {
				cnt++;
			}
		}
		if (cnt == 0) {
			char c = (char) (idx + 65);
			System.out.println(c);
		} else {
			System.out.println("?");
		}
	}
}