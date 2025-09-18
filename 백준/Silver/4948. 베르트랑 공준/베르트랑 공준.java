import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			Integer m = Integer.parseInt(br.readLine());
			int count = 0;
			if (m == 0) {
				break;
			}
			for (int i = m+1; i <= 2 * m; i++) {
				if (i < 2) {
					continue;
				}
				boolean flag = false;
				for (int j = 2; j * j <= i; j++) {
					if (i % j == 0) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					count++;
				}
			}
			bw.write(String.valueOf(count) + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}