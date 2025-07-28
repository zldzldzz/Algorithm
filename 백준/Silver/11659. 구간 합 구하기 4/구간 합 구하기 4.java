import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] MN = br.readLine().split(" ");
		int n = Integer.parseInt(MN[0]);
		int m = Integer.parseInt(MN[1]);
		int[] arr = new int[n + 1];
		String[] line = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(line[i - 1]) + arr[i - 1];
		}
		for (int i = 0; i < m; i++) {
			String[] cmd = br.readLine().split(" ");
			int a = Integer.parseInt(cmd[0]);
			int b = Integer.parseInt(cmd[1]);
			int sum = arr[b] - arr[a - 1];
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}



