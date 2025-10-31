import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		//정점 수
		int vCount = Integer.parseInt(st.nextToken());
		// 가중치 총합
		double wCount = Integer.parseInt(st.nextToken());

		//다리 정보 저장
		List<Integer>[] edges = new ArrayList[vCount + 1];
		for (int i = 1; i <= vCount; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < vCount-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}

		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[vCount + 1];

		q.add(1);
		double sum = 0;
		//리프 노드 확인 후 없으면 결과 ++
		while (!q.isEmpty()) {
			int u = q.poll();
			if (!visited[u]) {
				boolean isLeaf = true;
				for (int i = 0; i < edges[u].size(); i++) {
					int childIndex = edges[u].get(i);
					if (!visited[childIndex]) {
						isLeaf = false;
						q.add(childIndex);
					}
				}
				if (isLeaf) {
					sum++;
				}
				visited[u] = true;
			}
		}
		double result = wCount/sum;
		bw.write(String.valueOf(result));

		bw.flush();
		bw.close();
		br.close();
	}
}