import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Integer length = Integer.parseInt(br.readLine());
		String[] Aline = br.readLine().split(" ");
		String[] Bline = br.readLine().split(" ");
		int[] A = new int[length];
		int[] B = new int[length];
		for (int i = 0; i < length; i++) {
			A[i] = Integer.parseInt(Aline[i]);
			B[i] = Integer.parseInt(Bline[i]);
		}
		Arrays.sort(A);
		Arrays.sort(B);
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum += A[i] * B[length - i - 1];
		}
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		br.close();
	}
}