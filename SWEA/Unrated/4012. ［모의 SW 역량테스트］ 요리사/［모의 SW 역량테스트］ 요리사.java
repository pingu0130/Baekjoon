import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, cnt, min;
	static int A, B;
	static int[][] arr;
	static int[] arrA;
	static int[] arrB;

	public static void taste(int idx, int sidx) {
		if (idx == N) {
			return;
		} else if (sidx == cnt) {
			int x = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < cnt; j++) {
					if (i == arrA[j]) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					arrB[x] = i;
					x++;
				}
				flag = false;
			}
			for (int i = 0; i < cnt; i++) {
				for (int j = i + 1; j < cnt; j++) {
					A += arr[arrA[i]][arrA[j]];
					A += arr[arrA[j]][arrA[i]];
				}
			}
			for (int i = 0; i < cnt; i++) {
				for (int j = i + 1; j < cnt; j++) {
					B += arr[arrB[i]][arrB[j]];
					B += arr[arrB[j]][arrB[i]];
				}
			}
			min = Math.min(min, Math.abs(A - B));
			A = 0;
			B = 0;
			return;
		}
		arrA[sidx] = idx;
		taste(idx + 1, sidx + 1);
		taste(idx + 1, sidx);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = N / 2;
			min = 99999;
			arrA = new int[cnt];
			arrB = new int[cnt];
			taste(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}
}