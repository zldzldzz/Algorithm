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
		int m = Integer.parseInt(line[0]);
		int n = Integer.parseInt(line[1]);

		for (int i = m; i <= n; i++) {
			boolean flag = false;
			if (i <= 1) {
				flag = true;
			} else {
				for (int j = 2; j * j <= i; j++) {
					if (i % j == 0) {
						flag = true;
						break;
					}
				}
			}

			if (!flag) {
				bw.write(String.valueOf(i) + "\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}