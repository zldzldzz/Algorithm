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
		String[] mapSize = br.readLine().split(" ");
		int row = Integer.parseInt(mapSize[0]);
		int col = Integer.parseInt(mapSize[1]);
		int[][] map = new int[row][col];

		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		int kx = 0;
		int ky = 0;

		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> yq = new LinkedList<>();
		boolean first = false;
		for (int i = 0; i < row; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if (map[i][j] != 0) {
					q.add(new int[] {i, j});
				}
			}
		}
		int year = 0;

		while (true) {
			int count = 0;
			if (q.isEmpty()) {
				bw.write("0\n");
				break;
			}
			boolean[][] visited = new boolean[row][col];

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (!visited[i][j] && map[i][j] != 0) {
						count++;
						yq.add(new int[] {i, j});
						visited[i][j] = true;
						while (!yq.isEmpty()) {
							int[] now = yq.poll();
							for (int l = 0; l < 4; l++) {
								int nx = now[0] + dx[l];
								int ny = now[1] + dy[l];
								if (nx >= 0 && ny >= 0 && nx < row && ny < col) {
									if (map[nx][ny] > 0 && !visited[nx][ny]) {
										visited[nx][ny] = true;
										yq.add(new int[] {nx, ny});
									}
								}
							}
						}
					}
				}
			}
			if (count != 1) {
				bw.write(String.valueOf(year) + "\n");
				break;
			}
			//빙산 녹이기
			year++;
			Queue<int[]> q2 = new LinkedList<>();
			while (!q.isEmpty()) {
				int ocean = 0;
				int[] now = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = now[0] + dx[i];
					int ny = now[1] + dy[i];
					if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
						continue;
					}
					if (map[nx][ny] == 0) {
						ocean++;
					}
				}
				if (ocean > 0) {
					if (ocean >= map[now[0]][now[1]]) {
						q2.add(new int[] {now[0], now[1], 0});
					} else {
						q2.add(new int[] {now[0], now[1], (map[now[0]][now[1]] - ocean)});
					}
				} else {
					if (ocean == 0) {
						q2.add(new int[] {now[0], now[1], map[now[0]][now[1]]});
					}
				}
			}
			while (!q2.isEmpty()) {
				int[] now = q2.poll();
				if (now[2] == 0) {
					map[now[0]][now[1]] = 0;
				} else {
					map[now[0]][now[1]] = now[2];
					q.add(new int[] {now[0], now[1]});
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}