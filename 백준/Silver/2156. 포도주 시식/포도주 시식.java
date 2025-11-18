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
    int size = Integer.parseInt(br.readLine());
    int[] arr = new int[size+1];

    for (int i = 1; i < size+1; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[size+ 1];

    dp[0] = 0;
    if (size >= 1) {
      dp[1] = arr[1];
    }
    if (size >= 2) {
      dp[2] = arr[2]+arr[1];
    }

    for (int i = 3; i <= size; i++) {
      dp[i] = Math.max(dp[i - 2]+arr[i], dp[i - 3] + arr[i - 1]+arr[i]);
      dp[i] = Math.max(dp[i], dp[i - 1]);
    }
    int max= Arrays.stream(dp).max().getAsInt();
    bw.write(max+"\n");



    bw.flush();
    bw.close();
    br.close();
  }
}