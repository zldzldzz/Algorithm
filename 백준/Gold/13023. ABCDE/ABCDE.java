import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean flag = false;
	static boolean[] visited = null;
	static int n;
	static List<Integer>[] map;

	static void dfs(int node, int depth) {
		if (flag) {
			return;
		}
		if (depth == 4) {
			flag = true;
			return;
		}
		visited[node] = true;
		for (int next : map[node]) {
			if (!visited[next]) {
				dfs(next, depth + 1);
			}
			if (flag)
				return;
		}
		visited[node] = false;
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new List[n];
		for (int i = 0; i < n; i++) {
			map[i] = new LinkedList<Integer>();
		}
		visited = new boolean[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x].add(y);
			map[y].add(x);
		}

		for (int i = 0; i < n; i++) {
			dfs(i, 0);
			if (flag)
				break;
		}

		if (flag) {
			bw.write("1\n");
		} else {
			bw.write("0\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
