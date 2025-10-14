import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;

	static int n;
	static int m;

	static int[][] dir1 = {{-1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int[][] dir2 = {{0, -1}, {0, 1}, {1, 0}, {1, 0}};

	static int max = 0;

	public static boolean isval(int row, int col) {
		if (row >= 0 && row < n && col >= 0 && col < m) {
			return true;
		}
		return false;
	}

	public static boolean check(int row, int col, int index) {
		if (visited[row][col]) {
			return false;
		}
		int x1 = row + dir1[index][0];
		int y1 = col + dir1[index][1];
		int x2 = row + dir2[index][0];
		int y2 = col + dir2[index][1];

		return isval(x1, y1) && isval(x2, y2) && !visited[x1][y1] && !visited[x2][y2];
	}

	public static int add(int row, int col, int centerIndex) {
		int x1 = row + dir1[centerIndex][0];
		int y1 = col + dir1[centerIndex][1];
		int x2 = row + dir2[centerIndex][0];
		int y2 = col + dir2[centerIndex][1];

		visited[row][col] = true;
		visited[x1][y1] = true;
		visited[x2][y2] = true;

		int sum = map[row][col] * 2 + map[x1][y1] + map[x2][y2];

		return sum;
	}

	public static void back(int row, int col, int centerIndex) {
		int x1 = row + dir1[centerIndex][0];
		int y1 = col + dir1[centerIndex][1];
		int x2 = row + dir2[centerIndex][0];
		int y2 = col + dir2[centerIndex][1];

		visited[row][col] = false;
		visited[x1][y1] = false;
		visited[x2][y2] = false;
		return;
	}

	public static void dfs(int row, int col, int sum) {
		if (row == n) {
			max = Math.max(max, sum);
			return;
		}

		int nr = row;
		int nc = col + 1;

		if (nc == m) {
			nr = row + 1;
			nc = 0;
		}
		if (!visited[row][col]) {

			for (int i = 0; i < 4; i++) {
				if (check(row, col, i)) {

					int total = add(row, col, i);

					dfs(nr, nc, sum + total);

					back(row, col, i);
				}
			}
		}

		dfs(nr, nc, sum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, 0);
		bw.write(String.valueOf(max));

		bw.flush();
		bw.close();
		br.close();
	}
}