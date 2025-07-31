import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int l = Integer.parseInt(line[1]);
		boolean find = false;
		int result = -1;
		for (int i = l; i <= 100; i++) {
			int numerator = 2 * n - i * (i - 1);
			if (numerator < 0)
				break;
			if (numerator % (2 * i) == 0) {
				int x = numerator / (2 * i); // 시작 숫자
				find = true;
				for (int j = 0; j < i; j++) {
					bw.write((x + j) + " ");
				}
				bw.write("\n");
				break;
			}
		}
		if (!find) {
			bw.write("-1\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}