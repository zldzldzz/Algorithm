import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m;
		int count = 0;

		//섬 개수
		n = Integer.parseInt(br.readLine());
		//간선 개수
		m = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[n + 1][n + 1];
		boolean[] visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			String[] line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			map[a][b] = true;
			map[b][a] = true;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 1; i <= n; i++) {
				if (!visited[i] && map[now][i]) {
					visited[i] = true;
					q.add(i);
					count++;
				}
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
}