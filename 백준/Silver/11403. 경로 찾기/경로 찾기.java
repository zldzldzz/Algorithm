import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n;

	static int[][] result;

	//해당 컬럼의 다리 직렬로 변경하기
	public static void change(int row, int start) {
		boolean[] seen = new boolean[n];
		LinkedList<Integer> stack = new LinkedList<>();
		stack.push(start);
		seen[start] = true;

		while (!stack.isEmpty()) {
			int v = stack.pop();
			for (int i = 0; i < n; i++) {
				if (result[v][i] == 1) {
					if (result[row][i] == 0) result[row][i] = 1; // 도달성 반영
					if (!seen[i]) { // 사이클 차단
						seen[i] = true;
						stack.push(i);
					}
				}
			}
		}
	}

	public static void dfs(int row) {
		if (row == n) {
			return;
		}
		for (int i = 0; i < n; i++) {
			if(result[row][i] == 1) {
				change(row, i);
			}
		}
		dfs(row + 1);
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		result = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}