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
      //방문을 했었는지 검토
      return;
    }

    if (n == depth) {
      //이동거리가 목표에 도달하면 퍼센트 측정 (단순 경로 확률 측정)
      sumPercent += percent;
      return;
    }

    visited[x][y] = true;
    
    //4가지 방향으로 이동
    for (int i = 0; i < 4; i++) {
      int dx = x + directions[i][0];
      int dy = y + directions[i][1];
      // indexOut을 방지 하기 위한 조건
      if (dx >= 1 && dy >= 1 && dx <= 30 && dy <= 30) {
        dfs(depth + 1, percent * dirPercent[i], dx, dy);
      }
    }
    // 방문 해제
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