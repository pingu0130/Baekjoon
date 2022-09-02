import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); // 채널개수
		String[] ch = new String[N];
		for (int i = 0; i < N; i++) {
			ch[i] = sc.next();
		}
		int idx1 = 0;
		int idx2 = 0;
		// 최대한 적게 움직이려면 하나씩 찾아서 올리는게 아니라 끝까지 한번 탐색한 다음 한번에 올리는게 나을걸?
		for (int i = 0; i < N; i++) {
			if (ch[i].equals("KBS1")) { // 채널 찾으면
				idx1 = i; // 인덱스 저장
			} else if (ch[i].equals("KBS2")) {
				idx2 = i;
			}
		}
		if (idx1 > idx2) {
			// 1채널부터 조정
			for (int n = 0; n < idx1; n++)
				sb.append("1"); // 더 아래있는 채널까지 화살표 내리기
			for (int n = 0; n < idx1; n++) {
				sb.append("4"); // 인덱스0까지 올린다
			}
			// 2채널 조정
			for (int n = 0; n < idx2 + 1; n++) { // 뒤에서 한놈이 올라왔기 때문에 인덱스가 밀렸어.
				sb.append("1");
			}
			for (int n = 1; n < idx2 + 1; n++) {
				sb.append("4");
			}
		} else if (idx1 < idx2) {
			// 1채널부터 조정
			for (int n = 0; n < idx1; n++)
				sb.append("1");
			for (int n = 0; n < idx1; n++) {
				sb.append("4"); // 인덱스 0까지 올린다.
			}
			// 2채널조정
			for (int n = 0; n < idx2; n++) {
				sb.append("1");
			}
			for (int n = 1; n < idx2; n++) {
				sb.append("4");
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
