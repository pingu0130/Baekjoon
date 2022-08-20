import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String ans = null;
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int[] arr = new int[a];
			for (int j = 0; j < a; j++) { // A초딩의딱지
				arr[j] = sc.nextInt();
			}

			int b = sc.nextInt();
			int[] brr = new int[b];
			for (int j = 0; j < b; j++) { // B초딩의딱지
				brr[j] = sc.nextInt();
			}

			Arrays.sort(arr); // 정렬해서 스택에 넣기 그럼 4가 위로와
			Stack<Integer> aS = new Stack<>();
			for (int j = 0; j < a; j++) {
				aS.add(arr[j]);
			}
			Arrays.sort(brr);
			Stack<Integer> bS = new Stack<>();
			for (int j = 0; j < b; j++) {
				bS.add(brr[j]);
			}
			while (true) {
				int atop = aS.peek(); // 꼭대기끼리 비교
				int btop = bS.peek();
				if (atop > btop) {
					ans = "A";
					break;
				} else if (atop < btop) {
					ans = "B";
					break;
				}
				aS.pop();
				bS.pop();
				if (aS.isEmpty() && bS.isEmpty()) { // 둘다비었으면 비김
					ans = "D";
					break;
				} else if (aS.isEmpty()) {
					ans = "B";
					break;
				} else if (bS.isEmpty()) {
					ans = "A";
					break;
				}
			} // while
			System.out.println(ans);
		} // 테케
		sc.close();
	}
}