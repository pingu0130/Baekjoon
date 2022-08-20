
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt(); // 스위치개수
		int[] arr = new int[S];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int N = sc.nextInt(); // 사람수
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt(); // 성별
			int b = sc.nextInt(); // 수
			if (a == 1) { // 남자면
				int n = 1;
				while (b * n <= arr.length) { // 배열을 넘기전까지
					if (arr[b * n - 1] == 1) {
						arr[b * n - 1] = 0;
					} else {
						arr[b * n - 1] = 1;
					}
					n++;
				}
			} else { // 여자면
				Stack<Integer> lefts = new Stack<>();
				Stack<Integer> rights = new Stack<>();
				b -= 1;
				for (int z = arr.length - 1; z >= b + 1; z--) { // 끝에서부터 b다음칸까지
					rights.push(arr[z]);
				}
				for (int y = 0; y <= b - 1; y++) { // 0부터 b전칸까지
					lefts.push(arr[y]);
				}
				int cnt = 0;
				int min = Math.min(lefts.size(), rights.size());
				for (int x = 0; x < min; x++) {
					int rtop = rights.pop(); // 버리기
					int ltop = lefts.pop();
					if (rtop == ltop) { // 왼쪽top이랑 오른쪽top이 같으면 대칭이야
						cnt++; // 대칭 하나 있다
					} else { // 대칭아니면 끝
						break;
					}
				}
				if (cnt != 0) { // 대칭이 있으면
					for (int c = 0; c <= cnt; c++) {
						if (arr[b + c] == 1) {
							arr[b + c] = 0;
							arr[b - c] = 0; // 대칭이라 양쪽 다 바꿔도돼
						} else {
							arr[b + c] = 1;
							arr[b - c] = 1;
						}
					}
				} else { // 대칭이 없으면 b만바꿔야해
					if (arr[b] == 1) {
						arr[b] = 0;
					} else {
						arr[b] = 1;
					}
				}

			} // 여자면

		} // 테케
			// 출력만들기...
		Stack<Integer> ans = new Stack<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			ans.push(arr[i]);
		}
		while (!ans.isEmpty()) {
			for (int i = 0; i < 20; i++) { // 20개씩출력하면서
				System.out.print(ans.pop() + " "); // 버리기
				if (ans.isEmpty()) {
					break;
				}
			}
			System.out.println();
		}

		sc.close();
	}
}
