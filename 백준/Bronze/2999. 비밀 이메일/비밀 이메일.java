import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] arr = s.toCharArray();
		int i = s.length();
		List<Integer> list = new ArrayList<>();
		for (int k = 1; k <= i; k++) {
			if (i % k == 0) { // i의 약수
				list.add(k);
			}
		}
		int C = list.get(list.size() / 2);
		int R = i / C;
		char[][] me = new char[R][C];
		int a = 0;
		for (int y = 0; y < C; y++) {
			for (int x = 0; x < R; x++) {
				me[x][y] = arr[a];
				a++;
			}
		}
		for (int x = 0; x < R; x++) {
			for (int y = 0; y < C; y++) {
				System.out.print(me[x][y]);
			}
		}

	}
}
