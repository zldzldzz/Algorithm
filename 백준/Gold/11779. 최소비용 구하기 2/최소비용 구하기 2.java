import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int vCount;

	// 간선(버스)의 정보를 배열을 사용해 시작점은 필요 없음.
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
		//도시 수
		vCount = Integer.parseInt(br.readLine());
		// 버스 수
		int edgeCount = Integer.parseInt(br.readLine());
		StringTokenizer st;

		// 도시를 기준으로 버스의 정보를 담을 리스트
		List<Edge>[] lists = new LinkedList[vCount + 1];

		for (int i = 0; i < lists.length; i++) {
			lists[i] = new LinkedList<>();
		}

		for (int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(br.readLine());
			//버스 기준 시작점
			int u = Integer.parseInt(st.nextToken());
			//버스 기준 종착지
			int v = Integer.parseInt(st.nextToken());
			//가중치
			int w = Integer.parseInt(st.nextToken());
			lists[u].add(new Edge(v, w));
		}

		st = new StringTokenizer(br.readLine());

		int vStart = Integer.parseInt(st.nextToken());
		int vEnd = Integer.parseInt(st.nextToken());

		// 최단 거리가 들어갈 배열
		long[] dist = new long[vCount + 1];
		
		// 해당 정점까지 가는 최적 경로의 시작점 저장
		// route[index] = 1 이라면 index로 가는 최적의 경로 는 1에서 출발하는 간선이다.
		int[] route = new int[vCount + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[vStart] = 0;

		PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

		q.add(new long[] {0, vStart});

		while (!q.isEmpty()) {
			long[] cur = q.poll();
			// start까지 거리
			long currentDist = cur[0];

			// 간선의 시작점
			int start = (int)cur[1];

			if (currentDist > dist[start]) {
				continue;
			}

			for (Edge e : lists[start]) {
				int end = e.end;
				long distance = e.distance + dist[start];
				if (dist[end] > distance) {
					route[end] = start;
					dist[end] = distance;
					q.add(new long[] {distance, end});
				}
			}
		}

		ArrayList<Integer> routes = new ArrayList<>();

		int current = vEnd;
		
		while (current != 0) {
			routes.add(current);
			current =route[current];
		}

		// 다익스트라 결과
		bw.write(dist[vEnd] + "\n");

		// 경로 출력
		bw.write(routes.size() + "\n");

		for (int i = routes.size()-1; i >= 0; i--) {
			bw.write(routes.get(i) + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}

// 경로 찾는 방식을 못 찾아서 참고 https://moonsbeen.tistory.com/239