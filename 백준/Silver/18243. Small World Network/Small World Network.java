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

    int[][] edges = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      Arrays.fill(edges[i], Integer.MAX_VALUE/2);
    }

    for (int i = 1; i <= N; i++) {
      edges[i][i] = 0;
    }

    for (int i = 1; i <= K; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      edges[a][b] = 1;
      edges[b][a] = 1;
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        for (int k = 1; k <= N; k++) {
          if (edges[j][k] > edges[j][i] + edges[i][k]) {
            edges[j][k] = edges[j][i] + edges[i][k];
            edges[k][j] = edges[j][k];
          }
        }
      }
    }

    int m = 0;
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        m = Math.max(m, edges[i][j]);
      }
    }
    if(m <=6){
      bw.write("Small World!\n");
    }else {
      bw.write("Big World!\n");
    }
    bw.flush();
    bw.close();
    br.close();

  }
}