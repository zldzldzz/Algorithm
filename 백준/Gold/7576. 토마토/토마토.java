import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[][] map = new String[m][n];
        boolean[][] visited = new boolean[m][n];


        int[] dx={1, 0, -1, 0};
        int[] dy={0,-1, 0, 1};

        for (int i = 0; i < m; i++) {
            map[i]=br.readLine().split(" ");
        }

        Queue<Integer[]> q = new LinkedList<>();
        int max=0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j].equals("1")&&!visited[i][j]){
                    q.add(new Integer[]{i,j, 0});
                    visited[i][j]=true;
                }

            }
        }

        while (!q.isEmpty()){
            Integer[] now = q.poll();
            max=Math.max(max,now[2]);
            for (int k = 0; k < 4; k++) {
                int x = now[0]+dx[k];
                int y = now[1]+dy[k];
                if(x>=0&&y>=0&&x<m&&y<n&&!visited[x][y]){
                    if(map[x][y].equals("0")){
                        q.add(new Integer[]{x,y,now[2]+1});
                        visited[x][y]=true;
                    }
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]==false&&map[i][j].equals("0")){
                    max=-1;
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();

    }
}