import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long dNum = 0;
		long gNum = 0;

		List<Integer>[] list = new List[n + 1];

		List<Integer[]> line = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
			line.add(new Integer[] {a, b});
		}

		for (int i = 0; i < line.size(); i++) {
			Integer[] now = line.get(i);
			long degree1 = list[now[0]].size();
			long degree2 = list[now[1]].size();
			dNum += (degree1 - 1) * (degree2 - 1);
		}

		for (int i = 1; i <= n; i++) {
			long k = list[i].size();
			if (k >= 3) {
				gNum += k * (k - 1) * (k - 2) / 6;
			}
		}

		if (dNum == gNum * 3) {
			bw.write("DUDUDUNGA");
		} else if (dNum > gNum * 3) {
			bw.write("D");
		} else if (dNum < gNum * 3) {
			bw.write("G");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}