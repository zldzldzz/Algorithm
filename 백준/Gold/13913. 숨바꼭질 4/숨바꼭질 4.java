import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 100_001;

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[MAX + 1];
		int[] prev = new int[MAX + 1];
		Arrays.fill(prev, -1);
		Deque<Integer[]> q = new ArrayDeque<>();

		q.add(new Integer[] {n, 0});
		visited[n] = true;

		int result = -1;

		while (!q.isEmpty()) {

			Integer[] now = q.poll();

			if (now[0] == k) {
				result = now[1];
				break;
			}

			if (now[0] * 2 >= 0 && now[0] * 2 < MAX && !visited[now[0] * 2]) {
				q.add(new Integer[] {now[0] * 2, now[1] + 1});
				prev[now[0] * 2] = now[0];
				visited[now[0] * 2] = true;
			}
			if (now[0] - 1 >= 0 && now[0] - 1 < MAX && !visited[now[0] - 1]) {
				q.add(new Integer[] {now[0] - 1, now[1] + 1});
				prev[now[0] - 1] = now[0];
				visited[now[0] - 1] = true;
			}
			if (now[0] + 1 >= 0 && now[0] + 1 < MAX && !visited[now[0] + 1]) {
				q.add(new Integer[] {now[0] + 1, now[1] + 1});
				prev[now[0] + 1] = now[0];
				visited[now[0] + 1] = true;
			}
		}

		List<Integer> path = new ArrayList<>();

		if (result != -1) {
			for (int i = k; i != -1; i = prev[i]) {
				path.add(i);
			}
		}

		bw.write(String.valueOf(result) + "\n");

		Collections.reverse(path);

		for (Integer i : path) {
			bw.write(String.valueOf(i) + " ");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}