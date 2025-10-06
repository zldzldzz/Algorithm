import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int r;
	static int c;
	static char[] chars;
	static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static char[][] map;
	static int maxCount;
	static boolean[] visited = new boolean[26];

	public static void dfs(int depth, int x, int y) {

		visited[map[x][y] - 'A'] = true;
		maxCount = Math.max(maxCount, depth);

		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
				int next = map[nx][ny] - 'A';
				if (!visited[next]) {
					dfs(depth + 1, nx, ny);
				}
			}
		}
		visited[map[x][y] - 'A'] = false;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];

		chars = new char[r * c];

		for (int i = 0; i < r; i++) {
			String line = br.readLine();

			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		dfs(1, 0, 0);
		bw.write(String.valueOf(maxCount));

		bw.flush();
		bw.close();
		br.close();
	}
}