import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 정점 수
	static int n = 0;
	// 간선 수
	static int m = 0;
	// 노드
	static long[] node;

	static final long INF = Long.MAX_VALUE;

	static class Edge {
		int start;
		int end;
		long cost;

		public Edge(int start, int end, long cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

	static List<Edge> list;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		node = new long[n + 1];
		Arrays.fill(node, INF);

		list = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());

			list.add(new Edge(start, end, cost));
		}
		node[1] = 0;

		for (int i = 1; i < n; i++) {
			for (Edge e : list) {

				int start = e.start;
				int end = e.end;
				long cost = e.cost;

				if (node[start] != INF && node[end] > node[start] + cost) {
					node[end] = node[start] + cost;
				}
			}
		}

		// 4. 음수 사이클 판별 로직 (N번째 순회)
		boolean isCycle = false;
		for (Edge e : list) {
			int start = e.start;
			int end = e.end;
			long cost = e.cost;
			if (node[start] != INF && node[end] > node[start] + cost) {
				isCycle = true;
				break; // 사이클 발견 시 바로 종료
			}
		}

		for (int i = 2; i < n + 1; i++) {
			if (node[i] == INF) {
				node[i] = -1;
			}
		}

		if (isCycle) {
			bw.write("-1");
		} else {
			for (int i = 2; i < n + 1; i++) {
				bw.write(String.valueOf(node[i]));
				bw.newLine();
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}