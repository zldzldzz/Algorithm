import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int result = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[m][n];
		boolean[][] visited = new boolean[m][n];

		ArrayDeque<Integer[]> q = new ArrayDeque<>();
		int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new Integer[] {i, j, 0});
					visited[i][j] = true;
				}
			}
		}
		while (!q.isEmpty()) {
			Integer[] now = q.poll();
			result = Math.max(result, now[2]);
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dir[i][0];
				int y = now[1] + dir[i][1];
				if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
					if (map[x][y] == 0) {
						visited[x][y] = true;
						q.add(new Integer[] {x, y, now[2] + 1});
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					result = -1;
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}