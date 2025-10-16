import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int lastDays;
	static int maxValue;
	static List<Integer[]> counsel;

	//dfs를 돌면서 분기적으로 반복을 통해서 최대 값을 비교해서 넘긴다.
	public static void dfs(int today, int totalVal) {

		maxValue = Math.max(maxValue, totalVal);

		if (today >= lastDays) {
			return;
		}

		int day = counsel.get(today)[0];
		int val = counsel.get(today)[1];

		if (today + day <= lastDays) {
			dfs(today + day, totalVal + val);
		}
		dfs(today + 1, totalVal);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		lastDays = Integer.parseInt(br.readLine());

		counsel = new LinkedList<>();

		for (int i = 0; i < lastDays; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Integer day = Integer.parseInt(st.nextToken());
			Integer cost = Integer.parseInt(st.nextToken());
			counsel.add(new Integer[] {day, cost});
		}
		dfs(0, 0);

		bw.write(String.valueOf(maxValue));
		bw.flush();
		bw.close();
		br.close();
	}
}