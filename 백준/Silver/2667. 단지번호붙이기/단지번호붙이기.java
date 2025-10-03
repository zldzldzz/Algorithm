import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int result = 0;
		List<Integer> houseCount = new LinkedList<>();

		int n = Integer.parseInt(br.readLine());

		String[][] map = new String[n][n];
		boolean[][] visited = new boolean[n][n];

		int[] xd = {1, 0, -1, 0};
		int[] yd = {0, 1, 0, -1};

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			map[i] = line;
		}

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].equals("1")) {
					if (!visited[i][j]) {
						queue.add(new int[] {i, j});
						visited[i][j] = true;
						result++;
						int house = 1;
						while (!queue.isEmpty()) {
							int[] now = queue.poll();
							for (int k = 0; k < 4; k++) {
								int x = now[0] + xd[k];
								int y = now[1] + yd[k];
								if (x >= 0 && x < n && y >= 0 && y < n) {
									if (map[x][y].equals("1") && !visited[x][y]) {
										house++;
										visited[x][y] = true;
										queue.add(new int[] {x, y});
									}
								}
							}
						}
						houseCount.add(house);
					}
				}
			}
		}

		Collections.sort(houseCount);

		bw.write(String.valueOf(result)+"\n");
		for (Integer i : houseCount) {
			bw.write(String.valueOf(i)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}