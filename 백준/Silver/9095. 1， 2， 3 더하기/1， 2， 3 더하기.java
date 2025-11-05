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

		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());

			//인덱스: 해당 숫자 value: 될 수 있는 방법
			int[] dp = new int[target + 1];
			Arrays.fill(dp, -1);

			if (target >= 1) dp[1] = 1; // (1)
			if (target >= 2) dp[2] = 2; // (1+1), (2)
			if (target >= 3) dp[3] = 4;

			for (int j = 4; j <= target; j++) {

				dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
			}

			bw.write(dp[target]+"\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}