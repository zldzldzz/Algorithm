import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static boolean[][] visited = new boolean[30][30];
  static int n = 0;
  static double sumPercent = 0;
  static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  static double[] dirPercent;

  public static void dfs(int depth, double percent, int x, int y) {

    if (visited[x][y]) {
      return;
    }

    if (n == depth) {
      sumPercent += percent;
      return;
    }

    visited[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int dx = x + directions[i][0];
      int dy = y + directions[i][1];
      if (dx >= 1 && dy >= 1 && dx <= 30 && dy <= 30) {
        dfs(depth + 1, percent * dirPercent[i], dx, dy);
      }
    }
    visited[x][y] = false;
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());

    dirPercent = new double[4];
    dirPercent[0] = Double.parseDouble(st.nextToken()) / 100;
    dirPercent[1] = Double.parseDouble(st.nextToken()) / 100;
    dirPercent[2] = Double.parseDouble(st.nextToken()) / 100;
    dirPercent[3] = Double.parseDouble(st.nextToken()) / 100;

    dfs(0, 1, 15, 15);

    bw.write(sumPercent + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}