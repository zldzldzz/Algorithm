import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr = new int[9][9];
	static List<int[]> list = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean find = false;

	public static void dfs(int depth) throws IOException {

		if (find) {
			return;
		}

		if (depth == list.size()) {
			find = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					bw.write(String.valueOf(arr[i][j]) + " ");
				}
				bw.newLine();
			}
			return;
		}

		int[] now = list.get(depth);

		for (int i = 1; i <= 9; i++) {
			boolean flag = false;

			for (int j = 0; j < 9; j++) {
				if (arr[now[0]][j] == i || arr[j][now[1]] == i) {
					flag = true;
				}
			}

			int nx = (now[0] / 3) * 3;
			int ny = (now[1] / 3) * 3;
			for (int k = 0; k < 3; k++) {
				for (int l = 0; l < 3; l++) {
					if (nx + k < 9 && ny + l < 9 && arr[nx + k][ny + l] == i) {
						flag = true;
					}
				}
			}

			if (!flag) {
				arr[now[0]][now[1]] = i;
				dfs(depth + 1);
				arr[now[0]][now[1]] = 0;
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					list.add(new int[] {i, j});
				}
			}
		}

		dfs(0);

		br.close();
		bw.flush();
		bw.close();

	}
}