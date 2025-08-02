import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Integer length = Integer.parseInt(br.readLine());
		for (int i = 0; i < length; i++) {
			String[] mn = br.readLine().split(" ");
			int n = Integer.parseInt(mn[0]);
			int m = Integer.parseInt(mn[1]);
			if (n == m) {
				bw.write("1\n");
				continue;
			} else {
				int count = 1;
				for (int j = 0; j < n; j++) {
					count = count * (m - j) / (j + 1);
				}
				bw.write(String.valueOf(count) + "\n");
			}

		}
		bw.flush();
		bw.close();
		br.close();
	}
}