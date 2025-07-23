import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int h = Integer.parseInt(input[2]);

        boolean[][][] visited = new boolean[m][n][h];
        int[][][] map = new int[m][n][h];

        Queue<Integer[]> q= new LinkedList<>();

        int[] dx={1,0,-1,0,0,0};
        int[] dy={0,-1,0,1,0,0};
        int[] dz={0,0,0,0,-1,1};

       for(int i=0;i<h;i++){
           for(int j=0;j<n;j++){
               String[] line = br.readLine().split(" ");
               for (int k = 0; k < m; k++) {
                   map[k][j][i]= Integer.parseInt(line[k]);
                   if(map[k][j][i]==1){
                       visited[k][j][i]=true;
                       q.add(new Integer[]{k,j,i, 0});
                   }

               }
           }
       }

        int max=0;
        while (!q.isEmpty()){
            Integer[] now = q.poll();
            max=Math.max(max,now[3]);
            for (int i = 0; i < 6; i++) {
                if(now[1]+dy[i]>=0&&now[1]+dy[i]<n&&now[0]+dx[i]>=0&&now[0]+dx[i]<m && now[2]+dz[i]>=0&&now[2]+dz[i]<h&&!visited[now[0]+dx[i]][now[1]+dy[i]][now[2]+dz[i]])
                {
                    if(map[now[0]+dx[i]][now[1]+dy[i]][now[2]+dz[i]]==0){
                        q.add(new Integer[]{now[0]+dx[i],now[1]+dy[i],now[2]+dz[i], now[3]+1});
                        visited[now[0]+dx[i]][now[1]+dy[i]][now[2]+dz[i]]=true;
                    }
                }
            }
        }

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[k][j][i] == 0 && !visited[k][j][i]){
                        max = -1;  // 익지 않은 토마토 발견
                        break;
                    }
                }
                if(max == -1) break;
            }
            if(max == -1) break;
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();

    }
}