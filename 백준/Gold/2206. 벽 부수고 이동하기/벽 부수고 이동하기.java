import java.awt.desktop.QuitEvent;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int count=-1;

        int[] dx={1,0,-1,0};
        int[] dy= {0,1,0,-1};


        String[][] map = new String[n][m];
        boolean[][][] visited = new boolean[n][m][2];

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0,1,0});
        visited[0][0][0] = true;


        for (int i = 0; i < n; i++) {
            map[i]=br.readLine().split("");
        }

        while (!q.isEmpty()){

            int[] now = q.poll();
            if(now[0]==(n-1)&&now[1]==(m-1)){
                count=now[2];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int x = now[0]+dx[i];
                int y = now[1]+dy[i];
                if(x>=0&&y>=0&&x<n&&y<m&&!visited[x][y][now[3]]){
                    if(map[x][y].equals("0")){
                        visited[x][y][now[3]]=true;
                        q.add(new int[]{x,y,now[2]+1,now[3]});
                    }else if(map[x][y].equals("1")&&now[3]==0){
                        visited[x][y][1] = true;
                        q.add(new int[]{x, y, now[2]+1, 1});
                    }
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}



