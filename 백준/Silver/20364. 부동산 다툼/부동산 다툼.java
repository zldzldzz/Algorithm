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
  static StringTokenizer st;
  static int N;
  static int Q;
  static int[] duck;
  static int[] land;
  static int[] result;

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());
    // 오리가 희망 하는 땅
    duck = new int[Q + 1];
    // 땅의 주인
    land = new int[N + 1];
    // 결과
    result = new int[Q + 1];

    for (int i = 1; i <= Q; i++) {
      duck[i] = Integer.parseInt(br.readLine());
    }
    
    // dfs 사용했다가 엉뚱한 곳에서 막히는 원인이 정방향이라는 것을 알게 되고 수정
    for (int i = 1; i <= Q; i++) {
      
      int crr = duck[i];
      int block = 0;

      while (crr >= 1) {
        if (land[crr] != 0) {
          block = crr;
        }
        crr = crr / 2;
      }
      if (block != 0) {
        result[i] = block;
      } else {
        result[i] = 0;
        land[duck[i]]=i;
      }
    }

    for (int i = 1; i <= Q; i++) {
      bw.write(result[i] + "\n");
    }

    bw.flush();
    bw.close();
    br.close();

  }
}