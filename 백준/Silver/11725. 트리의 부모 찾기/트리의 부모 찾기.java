import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int nodeCount = Integer.parseInt(st.nextToken());

		//노드 수 만큼 리스트 생성
		List<Integer>[] list = new List[nodeCount + 1];
		for (int i = 1; i <= nodeCount; i++) {
			list[i] = new ArrayList<>();
		}

		// 양 노드에 서로 입력 누가 부모인지 아직 모음
		for (int i = 0; i < nodeCount - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		//부모 찾기 준비
		int[] preNode = new int[nodeCount + 1];
		boolean[] visited = new boolean[nodeCount + 1];

		ArrayDeque<Integer> q = new ArrayDeque<>();
		// 1부터 내려가기 위해 1를 큐에 넣고 방문 표시
		q.add(1);
		visited[1] = true;

		while (!q.isEmpty()) {
			//부모 지정 알고리즘 탐색을 할때 방문 표시가 되어있는 노드로 변경
			// 부모 지정후 해당 노드도 부모가 되기 위해 방문 체크 후 q에 삽입
			//가장 먼저 1이 나오면 부모가 1인 노드를 방문 표시 후 부모를 1로 지정
			int node = q.poll();
			for (int i : list[node]) {
				if (!visited[i]) {
					visited[i] = true;
					preNode[i] = node;
					q.add(i);
				}
			}
		}
		// 부모 출력
		for (int i = 2; i <= nodeCount; i++) {
			bw.write(String.valueOf(preNode[i]) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}