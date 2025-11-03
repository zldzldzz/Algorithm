import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[][] map;

	// 1-1. 목표 정의
	// 목표: (예) 최대 이익, 최소 횟수, 최대 개수 등을 구한다.
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}

		// 데이터 정렬 (탐욕적 선택을 쉽게 하기 위해)
		Arrays.sort(map, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		//정렬된 데이터 리스트를 순회한다.
		for (int[] ints : map) {
			int start = ints[0];
			int end = ints[1];
			int nearEnd = 0;

			if (!pq.isEmpty()) {
				nearEnd = pq.peek();
			}
			//항목이 현재_상태_정보의 제약 조건을 만족하는가?
			if(nearEnd<=start){
				// 선택 (Take): 탐욕적 선택을 실행
				pq.poll();
				// 상태 업데이트 (Update)
				pq.add(end);
			}else {
				// 건너뛰기 (Skip)
				pq.add(end);
			}
		}
		
		bw.write(pq.size() + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}