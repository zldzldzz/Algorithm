import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MAX = 100_001;
		StringTokenizer st = new StringTokenizer(br.readLine());
		//수빈 위치
		n = Integer.parseInt(st.nextToken());
		// 동생 위치
		k = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[MAX];
		Deque<Integer[]> q = new ArrayDeque<>();
		q.add(new Integer[] {n, 0});
		visited[n] = true;

		if (n == k) {
			bw.write("0");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		while (!q.isEmpty()) {
			Integer[] now = q.pollFirst();

			if (now[0] == k) {
				bw.write(String.valueOf(now[1]));
				break;
			}
			if (now[0] * 2 < MAX && !visited[now[0] * 2]) {
				visited[now[0] * 2] = true;
				q.add(new Integer[] {now[0] * 2, now[1]});
			}
			if (now[0] - 1 >= 0 && now[0] - 1 < MAX && !visited[now[0] - 1]) {
				visited[now[0] - 1] = true;
				q.add(new Integer[] {now[0] - 1, now[1] + 1});
			}
			if (now[0] + 1 < MAX && !visited[now[0] + 1]) {
				visited[now[0] + 1] = true;
				q.add(new Integer[] {now[0] + 1, now[1] + 1});
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}