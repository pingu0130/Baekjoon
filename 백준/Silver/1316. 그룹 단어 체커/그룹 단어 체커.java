import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 단어의 개수
		int cnt = 0;
		for (int tc = 1; tc < N + 1; tc++) {
			String s = sc.next();
			List<Character> list = new ArrayList<>();
			for (int i = 0; i < s.length(); i++) {
				list.add(s.charAt(i));
			}
			int k = 1;
			int size = list.size() - 1;
			while (size != 0) {
				if (list.get(k - 1) == list.get(k)) { // 앞뒤가 같으면
					list.remove(k - 1); // 앞 삭제
				} else {
					k++;
				}
				size--;
			}
			boolean flag = true;
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i) == list.get(j)) { // 같은 단어가 있으면
						flag = false;
					}
				}
			}
			if (flag == true) {
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
