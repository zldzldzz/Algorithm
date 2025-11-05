import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static class City {
		int cost = 0;
		int value = 0;

		public City(int cost, int value) {
			this.cost = cost;
			this.value = value;
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int wTarget = Integer.parseInt(st.nextToken());
		int vCount = Integer.parseInt(st.nextToken());

		List<City> list = new ArrayList<>();
		//dpSize은 dp 배열의 최대 범위를 나타 낸다. = 가장 큰 사람 수 + 목표 수
		int dpSize = -1;
		
		for (int i = 0; i < vCount; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			dpSize = Math.max(dpSize, value);
			list.add(new City(cost, value));
		}
		
		dpSize = wTarget + dpSize;
		int[] dp = new int[dpSize];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		//시작점으로 사람이 0인 경우는 비용이 0이라고 초기화
		dp[0] = 0;

		for (int i = 0; i < dpSize; i++) {
			for (int j = 0; j < vCount; j++) {
				int cost =list.get(j).cost;
				int value = list.get(j).value;
				// 점화식 조건
				if (i - value >= 0 && dp[i - value] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - value] + cost);
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = wTarget; i<dpSize; i++) {
			if(dp[i] == Integer.MAX_VALUE){
				continue;
			}else {
				result = Math.min(result, dp[i]);
			}
		}

		bw.write(result+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}