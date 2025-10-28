import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n = 0;
	static int m = 0;
	static List<Integer> list;
	static boolean[] visited;
	static List<Integer> print;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// depth은 배열의 첫번째 선택 기준
	public static void dfs(int depth) throws IOException {
		if (depth == m) {
			for (Integer i : print) {
				bw.write(String.valueOf(i)+" ");
			}
			bw.newLine();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				print.add(list.get(i));
				dfs(depth + 1);
				print.remove(print.size() - 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		print = new ArrayList<Integer>(m);
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);
		dfs(0);
		bw.flush();
		bw.close();
		br.close();
	}
}