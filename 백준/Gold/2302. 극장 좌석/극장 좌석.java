import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());

    int vipSize = Integer.parseInt(br.readLine());
    int[] vip = new int[vipSize + 1];
    for (int i = 0; i < vipSize; i++) {
      vip[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[41];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= 40; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    int result = 1;
    int preVip = 0;
    vip[vipSize] = n + 1;
    for (int i = 0; i <= vipSize; i++) {
      int endVip = vip[i];
      result = result * dp[endVip - preVip - 1];
      preVip = endVip;
    }

    System.out.println(result);
  }
}