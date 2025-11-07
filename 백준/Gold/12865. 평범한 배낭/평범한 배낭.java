import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] bag = new int[N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      bag[i][0] = Integer.parseInt(st.nextToken());
      bag[i][1] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[K + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;

    for (int i = 0; i < N; i++) {
      int w = bag[i][0];
      int v = bag[i][1];
      for (int j = K; j >=w; j--) {
        if (j - w >= 0 && dp[j - w] != -1) {
          dp[j] = Math.max(dp[j], dp[j - w] + v);
        }
      }
    }

    dp[K]=Arrays.stream(dp).max().getAsInt();
    bw.write(dp[K]+"\n");

    bw.flush();
    bw.close();
    br.close();
  }
}