import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        boolean[][] v= new boolean[n][m];
        int[][] arrary=new int[n][m];

        for (int i = 0; i < n; i++) {
            
            String[] str1 = br.readLine().split("");
            int[] num = new int[str1.length];
            
            for (int j = 0; j < str1.length; j++) {
                num[j]=Integer.parseInt(str1[j]);
                if(num[j]==1){
                    arrary[i][j]=1;
                }
            }
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        q.offer(new int[]{0,0});
        
        v[0][0]=true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int my = y + dy[d];

                if (0 <= nx && nx < n && 0 <= my && my < m) {
                    if (arrary[nx][my] != 0 && !v[nx][my]) {
                        q.offer(new int[]{nx, my});
                        v[nx][my] = true;
                        arrary[nx][my]=arrary[x][y]+1;
                    }
                }
            }
        }
        bw.write(String.valueOf(arrary[n-1][m-1]));
        bw.flush();
        bw.close();
        br.close();
    }
}
