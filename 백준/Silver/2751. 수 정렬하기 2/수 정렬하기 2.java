import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> a = new ArrayList<>(); // 양수리스트
		ArrayList<Integer> b = new ArrayList<>(); // 음수리스트
		int max = 0;
		int min = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num >= 0) { // 양수면 양수배열에
				a.add(num);
				if (max < num) {
					max = num;
				}
			} else { // 음수면 음수배열에
				b.add(num);
				if (min > num) {
					min = num;
				}
			}
		}

		int[] counta = new int[max + 1]; // 양수카운팅
		int[] sorta = new int[a.size()];
		for (int i = 0; i < a.size(); i++) {
			counta[a.get(i)]++;
		}
		for (int i = 1; i < counta.length; i++) { // 양수누적합
			counta[i] += counta[i - 1];
		}
		for (int i = 0; i < a.size(); i++) {
			sorta[--counta[a.get(i)]] = a.get(i);
		}
		//
		int[] countb = new int[Math.abs(min) + 1]; // 음수카운팅
		int[] sortb = new int[b.size()];
		for (int i = 0; i < b.size(); i++) {
			countb[Math.abs(b.get(i))]++; // 절대값으로 인덱스계산
		}
		for (int i = 1; i < countb.length; i++) { // 음수누적합
			countb[i] += countb[i - 1];
		}
		for (int i = 0; i < b.size(); i++) {
			sortb[--countb[Math.abs(b.get(i))]] = b.get(i);
		}
		//
		StringBuilder sb = new StringBuilder();
		for (int i = b.size() - 1; i >= 0; i--) { // 음수출력
//			sb.append(sortb[i]).append("\n");
			bw.write(sortb[i] + "\n");
		}
		for (int i = 0; i < a.size(); i++) {
//			sb.append(sorta[i]).append("\n");
			bw.write(sorta[i] + "\n");

		}

		br.close();
		bw.flush();
		bw.close();
	}
}
