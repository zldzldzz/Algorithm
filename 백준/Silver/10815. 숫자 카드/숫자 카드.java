import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] sang = br.readLine().split(" ");
		HashSet<String> set = new HashSet<>(Arrays.asList(sang));
		int m = Integer.parseInt(br.readLine());
		String[] jung = br.readLine().split(" ");

		for (int i = 0; i < m; i++) {
			if (set.contains(jung[i])) {
				bw.write("1 ");
			} else {
				bw.write("0 ");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}