import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    
    // xor 계산을 위해 행, 열, 대각선을 인덱스들을 10진수로 미리 저장
    int[] MASKS = {448, 56, 7, 292, 146, 73, 273, 84};

    for (int i = 0; i < N; i++) {
      // bfs의 조건을 위한 방문 처리
      boolean[] visited = new boolean[512];
      Queue<Integer[]> queue = new LinkedList<>();
      
      // 문제에서 제공하는 배열을 2진수로 저장하기 위한 문자열(StringBuilder)
      StringBuilder builder = new StringBuilder();

      int result = 0;

      for (int j = 0; j < 3; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int k = 0; k < 3; k++) {
          // 하나 씩 짤라서 T 하면 1 넣기
          if (st.nextToken().equals("T")) {
            builder.append(1);
          } else {
            builder.append(0);
          }
        }
      }
      
      // 입력 받은 문자열(이진수)-> 10진수 init으로 저장
      int init = Integer.parseInt(builder.toString(), 2);
      
      //bfs 기저 설정
      visited[init] = true;
      queue.add(new Integer[]{init, 0});

      while (!queue.isEmpty()) {
        Integer[] curr = queue.poll();
        int currIndex = curr[0];
        int count = curr[1];

        if (currIndex==0||currIndex==511) {
          result = count;
          break;
        }

        for (int j = 0; j < MASKS.length; j++) {
          // 자바의 xor 계산
          int next = currIndex^MASKS[j];

          if (!visited[next]) {
            visited[next] = true;
            queue.add(new Integer[]{next, count+1});
          }
        }
        result= -1;
      }

      bw.write(result+"\n");
    }

    bw.flush();
    bw.close();
    br.close();

  }
}