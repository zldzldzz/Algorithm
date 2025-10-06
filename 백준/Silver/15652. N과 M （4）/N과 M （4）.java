import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] arr;
	static boolean[] visited;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static void dfs(int length, int start) throws IOException {

		if (length == m) {
			for (int i = 0; i < length; i++) {
				bw.write(String.valueOf(arr[i]) + " ");
			}
			bw.newLine();
			return;
		}

		for (int i = start; i <= n; i++) {

			arr[length] = i;
			dfs(length + 1, i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		visited = new boolean[n + 1];
		dfs(0, 1);
		bw.flush();
		bw.close();
		br.close();
	}
}