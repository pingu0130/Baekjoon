import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			set.add(arr[i] % 42);
		}
		System.out.println(set.size());
	}
}
