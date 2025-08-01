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
		int minlength = Integer.MAX_VALUE;
		Integer n = Integer.parseInt(br.readLine());
		int[] dx = new int[] {1, 0, -1, 0};
		int[] dy = new int[] {0, -1, 0, 1};

		String[][] map = new String[n][n];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = line[j];
			}
		}

		int islandCounter = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].equals("1")) {
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i, j});
					map[i][j] = String.valueOf(islandCounter);
					while (!q.isEmpty()) {
						int[] now = q.poll();

						for (int k = 0; k < 4; k++) {
							int x = now[0] + dx[k];
							int y = now[1] + dy[k];

							if (x >= 0 && y >= 0 && x < n && y < n && map[x][y].equals("1")) {
								map[x][y] = String.valueOf(islandCounter);
								q.add(new int[] {x, y});
							}
						}
					}
					islandCounter++;
				}
			}
		}

		for (int island = 2; island < islandCounter; island++) {
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j].equals(String.valueOf(island))) {
						boolean isBorder = false;
						for (int k = 0; k < 4; k++) {
							int x = i + dx[k];
							int y = j + dy[k];
							if (x >= 0 && y >= 0 && x < n && y < n && map[x][y].equals("0")) {
								isBorder = true;
								break;
							}
						}
						if (isBorder) {
							q.add(new int[] {i, j, 0});
							visited[i][j] = true;
						}
					}
				}
			}
			boolean find = false;
			while (!q.isEmpty()) {
				int[] now = q.poll();
				for (int i = 0; i < 4; i++) {
					int x = now[0] + dx[i];
					int y = now[1] + dy[i];

					if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y]) {
						continue;
					}

					if (map[x][y].equals("0")) {
						visited[x][y] = true;
						q.add(new int[] {x, y, now[2] + 1});
					} else if (!map[x][y].equals(String.valueOf(island))) {
						find = true;
						minlength = Math.min(minlength, now[2]);
						break;
					}
				}
				if (find) {
					break;
				}
			}
		}
		bw.write(String.valueOf(minlength) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}