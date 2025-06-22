import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            String[] strings = br.readLine().split(" ");
            int m= Integer.parseInt(strings[0]);
            int n= Integer.parseInt(strings[1]);
            int length=Integer.parseInt(strings[2]);

            int[][] arry= new int[m][n];
            boolean[][] v= new boolean[m][n];

            for (int j = 0; j < length; j++) {
                String[] s = br.readLine().split(" ");
                arry[Integer.parseInt(s[0])][Integer.parseInt(s[1])]=1;
            }

            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int count=0;

            ArrayDeque<int[]> q = new ArrayDeque<>();

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if(arry[j][k]==1 && !v[j][k]){
                        q.offer(new int[]{j, k});
                        v[j][k] = true;


                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            int x = cur[0];
                            int y = cur[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dx[d];
                                int ny = y + dy[d];

                                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                                    if (arry[nx][ny] == 1 && !v[nx][ny]) {
                                        q.offer(new int[]{nx, ny});
                                        v[nx][ny] = true;
                                    }
                                }
                            }
                        }
                        count++;
                    }

                }

            }
            bw.write(count+"\n");
        }
        bw.close();
    }
}
