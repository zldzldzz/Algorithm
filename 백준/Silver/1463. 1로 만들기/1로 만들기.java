import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int x = Integer.parseInt(br.readLine());
		Queue<Integer[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[x+1];

		q.add(new Integer[] {1, 0});
		visited[1]=true;

		int ans = 0;

		while (!q.isEmpty()) {
			Integer[] now = q.poll();
			int n = now[0];

			if (n == x) {
				ans= now[1];
				break;
			}

			if (n * 3 <= x&&!visited[n*3]) {
				q.add(new Integer[] {n * 3, now[1] + 1});
				visited[n * 3] = true;
			}
			if (n * 2 <= x&&!visited[n*2]) {
				q.add(new Integer[] {n * 2, now[1] + 1});
				visited[n * 2] = true;
			}
			if (n + 1 <= x&&!visited[n+1]) {
				q.add(new Integer[] {n + 1, now[1] + 1});
				visited[n + 1] = true;
			}
		}
		bw.write(String.valueOf(ans));

		bw.flush();
		bw.close();
		br.close();
	}
}