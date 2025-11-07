import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n + 1];

    // 최대 3개 오를 수 없음
    // 1~2칸만 이동
    for (int i = 1; i < n + 1; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);

		dp[0] = 0;

		if (n >= 1) dp[1] = arr[1];
		if (n >= 2) dp[2] = arr[1] + arr[2];

    for (int i = 3; i <= n; i++) {
      if (dp[i] <= dp[i - 1] + arr[i]) {
        dp[i]= Math.max(dp[i - 2], dp[i - 3] + arr[i-1])+arr[i];
      }

      if (dp[i] <= dp[i - 2] + arr[i]) {
        dp[i] = dp[i - 2] + arr[i];
      }
    }
		System.out.println(dp[n]);

    bw.flush();
    bw.close();
    br.close();
  }
}