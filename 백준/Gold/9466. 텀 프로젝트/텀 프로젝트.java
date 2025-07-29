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
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] student = new int[n];
			int[] studentcount = new int[n];
			String[] line = br.readLine().split(" ");
			Queue<Integer> q = new LinkedList<>();
			int count = 0;
			for (int j = 0; j < n; j++) {
				student[j] = Integer.parseInt(line[j]) - 1;
				studentcount[student[j]]++;
			}
			for (int j = 0; j < n; j++) {
				if (studentcount[j] == 0) {
					q.add(student[j]);
					count++;
				}
			}
			while (!q.isEmpty()) {
				int u = q.poll();
				studentcount[u]--;
				if (studentcount[u] == 0) {
					count++;
					q.add(student[u]);
				}
			}
			bw.write(String.valueOf(count) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}