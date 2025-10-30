import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	//int 범위보다 큰 값을 받기 위해 long 사용
	static final long INF = Long.MAX_VALUE / 4;

	// 간선의 정보를 배열을 사용해 시작점은 필요 없음.
	// 도착지, 시작점에서 도착지 까지의 거리 저장
	public static class Edge {
		int end;
		int distance;

		public Edge(int end, int distance) {
			this.end = end;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점 수
		int vCount = Integer.parseInt(st.nextToken());

		// 간선 수
		int eCount = Integer.parseInt(st.nextToken());

		//시작 정점
		int vStart = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

		// 정점 마다 관련 다리 모음
		// 간선 리스트를 정점 수 만큼 만든다. (시작점은 배열의 인덱스로 사용)
		List<Edge>[] list = new ArrayList[vCount + 1];
		for (int i = 1; i <= vCount; i++) {
			list[i] = new ArrayList<>();
		}

		// 간선 정보 입력
		for (int i = 1; i <= eCount; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[start].add(new Edge(end, w));
		}

		// 최단 거리가 들어갈 배열
		long[] dist = new long[vCount + 1];

		// 최단 거리가 가능한 최대치를 넘어서지 않도록 Long.MAX_VALUE로 설정 (오버플로우 방지 목적)
		Arrays.fill(dist, INF);
		// 시작점 거리 초기화
		dist[vStart] = 0;

		// 거리가 가장 짧은 다리 먼저 처리 하기 위해 우선 순위 큐 사용
		PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparing(a->a[0]));

		// 시작 정점에서 시작
		q.add(new long[] {0, vStart});

		while (!q.isEmpty()) {
			// 큐의 값 읽기
			long[] cur = q.poll();

			// start까지 거리
			long currentDist = cur[0];

			// 간선의 시작점
			int start = (int) cur[1];

			// 이미 처리된 값인지 비교
			// start에 저장된 최단 경로와 큐에 저장된 start까지의 거리를 비교를 통해
			// 이미 저장 값이 더 작으면 무시
			if (currentDist > dist[start]) {
				continue;
			}
			// start에서 시작하는 모든 간선 조회
			for (Edge e : list[start]) {
				int end = e.end;
				long cost = e.distance + dist[start];
				// 이미 처리된 결과와 비교한다.
				if(dist[end] > cost) {
					dist[end] = cost;
					q.add(new long[] {cost, end});
				}
			}
		}
		//결과 출력
		for (int i = 1; i <=vCount ; i++) {
			if(dist[i] == INF){
				bw.write("INF\n");
				continue;
			}
			bw.write(String.valueOf(dist[i]));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}